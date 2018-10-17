package com.rama.java.generics;

public class ServiceImpl implements Service<String> {

	@Override
	public String getService(String service) {
		
		return service;
	}
	
	public static void main(String[] args) {
		ServiceImpl serviceImpl=new ServiceImpl();
		System.out.println(serviceImpl.getService("network service"));
	}

}
