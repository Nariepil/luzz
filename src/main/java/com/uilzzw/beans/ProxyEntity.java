package com.uilzzw.beans;

public class ProxyEntity {
	private String ipAddress;
	private String port;
	private String protocol;
	private boolean canBeUsed;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public boolean isCanBeUsed() {
		return canBeUsed;
	}

	public void setCanBeUsed(boolean canBeUsed) {
		this.canBeUsed = canBeUsed;
	}

}
