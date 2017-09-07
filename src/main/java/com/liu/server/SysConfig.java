package com.liu.server;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SysConfig {

	static JsonObject config;

	public static void init(JsonObject src) {
		config = src;
	}

	/**
	 * 
	 * @param key 层级key abc.def.ghi
	 * @return
	 */
	public static String get(String key) {
		JsonElement ele = getElement(key);
		return ele == null ? null : ele.getAsString();
	}

	/**
	 * 
	 * @param key 层级key abc.def.ghi
	 * @return
	 */
	public static JsonObject getObj(String key) {
		JsonElement ele = getElement(key);
		return ele == null ? null : ele.getAsJsonObject();
	}

	/**
	 * 
	 * @param key 层级key abc.def.ghi
	 * @return
	 */
	public static JsonArray getArray(String key) {
		JsonElement ele = getElement(key);
		return ele == null ? null : ele.getAsJsonArray();
	}

	private static JsonElement getElement(String key) {
		if (key == null || config == null) {
			return null;
		}
		String[] strs = key.split("\\.");
		JsonElement ele = config;
		for (String str : strs) {
			if (ele.isJsonObject()) {
				ele = ele.getAsJsonObject().get(str);
			} else {
				ele = null;
			}

			if (ele == null) {
				break;
			}
		}
		return ele;
	}

	/**
	 * 作者本地调试时，才返回true,其它时候返回 false
	 * 
	 * @return
	 */
	public static boolean localDebug() {
		String debug = SysConfig.get("local_debug_temp");
		return debug != null && debug.equals("true");
	}

	public static void assertHas(String key) {
		String value = get(key);
		if (value == null) {
			throw new RuntimeException("必须的配置文件内容缺失, key:" + key);
		}
	}

	public static void assertHasObj(String key) {
		JsonObject value = getObj(key);
		if (value == null) {
			throw new RuntimeException("必须的配置文件内容缺失, key:" + key);
		}
	}

	public static void main(String[] args) {
		// 初始化配置读取
		URL url = ServerStartupListener.class.getResource("/sys_config.json");
		File sysConfig = new File(url.getPath());
		try {
				JsonObject json = new JsonParser().parse(new FileReader(sysConfig)).getAsJsonObject();
				SysConfig.init(json);
				System.out.println(SysConfig.get("sys_name"));
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
