package com.wisewin.circle.example.api.impl;


import com.wisewin.circle.example.api.AuthTokenAPI;
import com.wisewin.circle.example.comm.TokenUtil;

public class EasemobAuthToken implements AuthTokenAPI {

	@Override
	public Object getAuthToken(){
		return TokenUtil.getAccessToken();
	}
}
