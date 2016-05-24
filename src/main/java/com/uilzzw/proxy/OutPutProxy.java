package com.uilzzw.proxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uilzzw.common.LogUtils;
import com.uilzzw.utils.ProxyConstants;

public class OutPutProxy {

	/**
	 * 
	 * 将获取到的ip地址,端口,协议的集合写入到文件
	 * 
	 * @param ipAddrList
	 *            IP集合
	 * @param filePath
	 *            需要保存的路径-->最后一层目录不能带"\"
	 * @param isSaveIpAddr
	 *            是否保存IP地址
	 * @param isSavePort
	 *            是否保存端口
	 * @param isSaveProtocol
	 *            是否保存协议
	 * @return
	 */
	public static boolean writeContentToFile(List<HashMap<String, String>> ipAddrList, String filePath,
			boolean isSaveIpAddr, boolean isSavePort, boolean isSaveProtocol) {
		String direc = filePath;
		LogUtils.getLogger().info("Directory Path is: [" + direc + "]");
		if (StringUtils.isBlank(filePath)) {
			LogUtils.getLogger().info("Don't choose the directory;We use the default directory");
			direc = System.getProperty("user.home");
			LogUtils.getLogger().info("Directory Path is: [" + direc + "]");
			filePath = System.getProperty("user.home") + "\\" + ProxyConstants.FILE_NAME;
			LogUtils.getLogger().info("proxy.txt absolute path is: [" + filePath + "]");
		} else {
			filePath += "\\" + ProxyConstants.FILE_NAME;
			LogUtils.getLogger().info("proxy.txt absolute path is: [" + filePath + "]");
		}
		if (ipAddrList == null || StringUtils.isBlank(filePath))
			return false;
		if (!isSaveIpAddr && !isSavePort && !isSaveProtocol)
			return false;
		File directory = new File(direc);
		if (!directory.exists()) {
			directory.mkdir();
			LogUtils.getLogger().info("Create directory===" + direc + "===successfull;");
		}
		File proxyTxt = new File(filePath);
		if (!proxyTxt.exists()) {
			try {
				boolean createNewFile = proxyTxt.createNewFile();
				if (createNewFile) {
					LogUtils.getLogger().info("Create File===" + proxyTxt.toString() + "===successfull;");
					FileWriter fw = new FileWriter(proxyTxt, true);
					contentToFile(ipAddrList, isSaveIpAddr, isSavePort, isSaveProtocol, fw);
					return true;
				} else {
					LogUtils.getLogger().error("Create File===" + proxyTxt.toString() + "===failed;");
					return false;
				}
			} catch (IOException e) {
				LogUtils.getLogger().error("Create File===" + proxyTxt.toString() + "===failed;", new Throwable(e));
				return false;
			}
		} else if (proxyTxt.exists()) {
			try {
				FileWriter fw = new FileWriter(proxyTxt, true);
				contentToFile(ipAddrList, isSaveIpAddr, isSavePort, isSaveProtocol, fw);
				return true;
			} catch (IOException e) {
				LogUtils.getLogger().error("Copy To File===" + proxyTxt.toString() + "===failed;", new Throwable(e));
				return false;
			}
		}
		return false;
	}

	/**
	 * 数据写入文本文档
	 * 
	 * @param ipAddrList
	 * @param isSaveIpAddr
	 * @param isSavePort
	 * @param isSaveProtocol
	 * @param fw
	 * @throws IOException
	 */
	private static void contentToFile(List<HashMap<String, String>> ipAddrList, boolean isSaveIpAddr,
			boolean isSavePort, boolean isSaveProtocol, FileWriter fw) throws IOException {
		LogUtils.getLogger().info("=======Starting Copy To File=======");
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < ipAddrList.size(); i++) {
			HashMap<String, String> ipElem = ipAddrList.get(i);
			StringBuffer ipSB = new StringBuffer();
			if (isSaveIpAddr) {
				String ip = ipElem.get("ipAddr");
				ipSB.append(ip);
			}
			if (isSavePort) {
				String port = ipElem.get("port");
				ipSB.append(":").append(port);
			}
			if (isSaveProtocol) {
				String protocol = ipElem.get("protocol");
				ipSB.append(",").append(protocol);
			}
			LogUtils.getLogger().info("IP Address Info:" + ipSB.toString());
			StringBuffer buffer = ipSB.append("\r\n");
			String ipElemToString = buffer.toString();
			bw.append(ipElemToString);
		}
		LogUtils.getLogger().info("=========End Copy=========");
		bw.close();
	}
}
