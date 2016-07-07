package com.fpt.ftel.core.utils;

import java.text.DecimalFormat;

public class NumberUtils {
	public static final DecimalFormat FORMAT_DOUBLE = new DecimalFormat("#.####");
	
	public static String getTwoCharNumber(int number) {
		return String.format("%02d", number);
	}
}
