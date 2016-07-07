package com.fpt.ftel.hdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import com.fpt.ftel.core.config.CommonConfig;

public class HdfsIOSimple {
	private final FileSystem hdfs;

	public static void main(String[] args) throws IOException, URISyntaxException {
		HdfsIOSimple hdfsIOSimple = new HdfsIOSimple();
//		List<String> listFile = hdfsIOSimple.getAllFileInDir2("/data/payTV/log_parsed/2016/03/");
//		for(String file : listFile){
//			System.out.println(file);
//		}
		System.out.println(hdfsIOSimple.isExist("/data"));
	}
	
	public HdfsIOSimple() throws IOException{
		Configuration configuration = new Configuration();
		configuration.addResource(new Path(CommonConfig.getInstance().get(CommonConfig.HDFS_CORE_SITE)));
		configuration.addResource(new Path(CommonConfig.getInstance().get(CommonConfig.HDFS_SITE)));
		hdfs = FileSystem.get(configuration);
	}

	public void createFolder(String folderPath) throws IOException {
//		Path workingDir = hdfs.getWorkingDirectory();
//		System.out.println("Home folder: " + workingDir);
		Path newFolderPath = new Path(folderPath);
		System.out.println("Create fodler:" + newFolderPath);

		if (hdfs.exists(newFolderPath)) {
			hdfs.delete(newFolderPath, true); // Delete existing Directory
		}

		hdfs.mkdirs(newFolderPath);
	}

	public void write(String path, String content) throws IOException {
		Path file = new Path(path);
		OutputStream os = hdfs.create(file, true);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
		br.write(content);
		br.close();
	}

	public void write(String path, List<String> contents) throws IOException {
		Path file = new Path(path);
		OutputStream os = hdfs.create(file, true);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
		for (String string : contents) {
			br.write(string);
		}
		br.close();
	}

	public void write(String path, Map<String, String> contents) throws IOException {
		Path file = new Path(path);
		OutputStream os = hdfs.create(file, true);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
		for (String key : contents.keySet()) {
			br.write("(" + key + "," + contents.get(key) + ")");
			br.newLine();
		}
		br.close();
	}

	public List<String> getAllFileInDir2(String dir) throws FileNotFoundException, IOException {
		List<String> files = new ArrayList<String>();
		Path path = new Path(dir);
		FileStatus[] status = hdfs.listStatus(path); // you need to pass in your
														// hdfs path
		// System.out.println("Size: " + status.length);
		for (int i = 0; i < status.length; i++) {
			String name = status[i].getPath().getName();
			files.add(name);
		}
		return files;
	}

	public void move(String src, String dst) throws FileNotFoundException, IOException {
		Path oldPath = new Path(src);
		Path newPath = new Path(dst);
		hdfs.rename(oldPath, newPath);
	}

	public void delete(String dir) throws FileNotFoundException, IOException {
		Path path = new Path(dir);
		hdfs.delete(path, true);
	}

	public boolean isExist(String dir) throws FileNotFoundException, IOException {
		Path path = new Path(dir);
		return hdfs.exists(path);
	}

	public long getSpaceConsumed(String dir) throws FileNotFoundException, IOException {
		Path path = new Path(dir);
		return hdfs.getContentSummary(path).getSpaceConsumed();
	}

	public List<String> readContentOfDirectory(String dir) throws FileNotFoundException, IOException {
		Path path = new Path(dir);
		FileStatus[] status = hdfs.listStatus(path);
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < status.length; i++) {
			InputStream in = hdfs.open(status[i].getPath());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			line = br.readLine();
			while (line != null) {
				// System.out.println(line);
				result.add(line);
				line = br.readLine();
			}
		}
		return result;
	}

	public void close() throws IOException {
		hdfs.close();
	}
}
