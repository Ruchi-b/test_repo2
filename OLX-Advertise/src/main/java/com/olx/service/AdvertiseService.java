package com.olx.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale.Category;

import ch.qos.logback.core.status.Status;

public interface AdvertiseService {
	public List<Category> getAllCategories();
	public List<Status> getAllStatus();
	public static List<AdvertiseService> searchAdvertisesByFilterCriteria(String searchText, int categoryId,
			String postedBy, String dateCondition, LocalDate onDate, LocalDate fromDate, LocalDate toDate,
			String sortedBy, int startIndex, int records) {
		// TODO Auto-generated method stub
		return null;
	}
	public AdvertiseService updateAdvertise(int id, AdvertiseService data, String authToken);
	public AdvertiseService getAllAdvertiseService(String authToken);
	public AdvertiseService getAdvertiseServiceOfUserById(int id, String authToken);
	public boolean deleteAdvertiseServiceById(int id, String authToken);
	public AdvertiseService SearchAdvertiseServiceByText(String searchText);
	

}
