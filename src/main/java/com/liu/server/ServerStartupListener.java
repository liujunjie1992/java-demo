package com.liu.server;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ServerStartupListener implements ServletContextListener {
	private Logger LOG = LoggerFactory.getLogger(ServerStartupListener.class);
	
	JsonParser parser = new JsonParser();
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		URL url = ServerStartupListener.class.getResource("/sys_config.json");
		File sysConfig = new File(url.getPath());
		try {
			String sysConfigStr = FileUtils.readFileToString(sysConfig, "utf-8");
			JsonObject json = parser.parse(sysConfigStr).getAsJsonObject();
			SysConfig.init(json);
			
			SysConfig.assertHas("sys_name");
			LOG.debug(SysConfig.get("sys_name"));
		} catch (IOException e) {
			LOG.error("加载 resume_config.json失败. ", e);
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
