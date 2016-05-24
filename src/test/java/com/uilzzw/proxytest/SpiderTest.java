package com.uilzzw.proxytest;

import java.util.HashMap;
import java.util.List;

import com.uilzzw.common.LogUtils;
import com.uilzzw.common.UserAgent;
import com.uilzzw.proxy.OutPutProxy;
import com.uilzzw.proxy.SpiderProxy;
import com.uilzzw.utils.ProxyConstants;

public class SpiderTest {
    
    public static void main(String[] args) {
	String userAgent=UserAgent.GOOGLECHROME_WINDOWS;
	for (int i = 0; i < 10; i++) {
	    String url=ProxyConstants.NN_PROXY+i;
	    List<HashMap<String,String>> xiciProxy = SpiderProxy.getXiciProxy(url, userAgent);
	    LogUtils.getLogger().info(xiciProxy.toString());
	    OutPutProxy.writeContentToFile(xiciProxy, null, true, true, false);
	}
    }
}
