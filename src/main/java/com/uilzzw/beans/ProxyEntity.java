package com.uilzzw.beans;

public class ProxyEntity {
    private String ipAddress;
    private String port;
    private String protocol;
    // 0-Can used;1-Can't used;2-Don't Validate;3-Deleted;4-Died;
    private int canBeUsed;

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

    public int getCanBeUsed() {
	return canBeUsed;
    }

    public void setCanBeUsed(int canBeUsed) {
	this.canBeUsed = canBeUsed;
    }
}
