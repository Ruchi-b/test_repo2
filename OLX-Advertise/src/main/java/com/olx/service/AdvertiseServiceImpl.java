package com.olx.service;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.status.Status;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {
	
	public List<Category> getAllCategories() {
	// TODO Auto-generated method stub
	return null;
	}
	
	
	public List<Status> getAllStatus() {
	// TODO Auto-generated method stub
	return null;
	}


	@Override
	public AdvertiseService updateAdvertise(int id, AdvertiseService data, String authToken) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AdvertiseService getAllAdvertiseService(String authToken) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AdvertiseService getAdvertiseServiceOfUserById(int id, String authToken) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean deleteAdvertiseServiceById(int id, String authToken) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public AdvertiseService SearchAdvertiseServiceByText(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}



}
