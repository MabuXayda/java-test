package com.fpt.ftel.paytv.object;

import com.google.gson.annotations.SerializedName;

public class RawLog {
	// @SerializedName("_index")
	// String index;
	// @SerializedName("_type")
	// String type;
	// @SerializedName("_id")
	// String id;
	// @SerializedName("_score")
	// Integer score;
	public class Source {
		// @SerializedName("tags")
		// List<String> tags;
		// @SerializedName("@timestamp")
		// String timestamp;
		// @SerializedName("index_day")
		// String index_day;
		// @SerializedName("host")
		// String host;
		// @SerializedName("type")
		// String type;
		// @SerializedName("path")
		// String path;
		// @SerializedName("message")
		// String message;
		// @SerializedName("@version")
		// String version;
		public class Fields {
			// @SerializedName("Duration")
			// Integer duration;
			// @SerializedName("ItemName")
			// String itemName;
			// @SerializedName("Key")
			// String key;
			// @SerializedName("isLandingPage")
			// String isLandingPage;
			// @SerializedName("ElapsedTimePlaying")
			// String elapsedTimePlaying;
			@SerializedName("Screen")
			String screen;

			public String getScreen() {
				return screen;
			}

			// @SerializedName("SecondaryDNS")
			// String secondaryDNS;
			// @SerializedName("LocalType")
			// String localType;
			// @SerializedName("SubnetMask")
			// String subnetMask;
			@SerializedName("ip_wan")
			String ip_wan;

			public String getIp_wan() {
				return ip_wan;
			}

			// @SerializedName("PreviousSubMenuId")
			// String previousSubMenuId;
			// @SerializedName("PreviousItemId")
			// String previousItemId;
			// @SerializedName("Multicast")
			// String multicast;
			// @SerializedName("PrimaryDNS")
			// String primaryDNS;
			// @SerializedName("DefaultGetway")
			// String defaultGetway;
			// @SerializedName("Ip")
			// String ip;
			// @SerializedName("Session")
			// String session;
			// @SerializedName("PreviousScreen")
			// String previousScreen;
			// @SerializedName("PreviousAppId")
			// String previousAppId;
			// @SerializedName("PreviousDuration")
			// String previousDuration;
			@SerializedName("SessionSubMenu")
			String sessionSubMenu;

			public String getSessionSubMenu() {
				return sessionSubMenu;
			}
			// @SerializedName("SessionMenu")
			// String sessionMenu;
			// @SerializedName("Mac")
			// String mac;
			// @SerializedName("Event")
			// String event;
			// @SerializedName("AppId")
			// String appId;

			@SerializedName("Firmware")
			String firmware;

			public String getFirmware() {
				return firmware;
			}

			@SerializedName("BoxTime")
			String boxTime;

			public String getBoxTime() {
				return boxTime;
			}

			@SerializedName("Contract")
			String contract;

			public String getContract() {
				return contract;
			}

			@SerializedName("AppName")
			String appName;

			public String getAppName() {
				return appName;
			}

			@SerializedName("RealTimePlaying")
			String realTimePlaying;

			public String getRealTimePlaying() {
				return realTimePlaying;
			}

			@SerializedName("SessionMainMenu")
			String sessionMainMenu;

			public String getSessionMainMenu() {
				return sessionMainMenu;
			}

			@SerializedName("ItemId")
			String itemId;

			public String getItemId() {
				return itemId;
			}

			@SerializedName("LogId")
			String logId;

			public String getLogId() {
				return logId;
			}

			@SerializedName("CustomerID")
			String customerId;

			public String getCustomerId() {
				return customerId;
			}
		}

		@SerializedName("received_at")
		String received_at;

		public String getReceived_at() {
			return received_at;
		}

		@SerializedName("fields")
		Fields fields;

		public Fields getFields() {
			return fields;
		}
	}

	@SerializedName("_source")
	Source source;

	public Source getSource() {
		return source;
	}
}