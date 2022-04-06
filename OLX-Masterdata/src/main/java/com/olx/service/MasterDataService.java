package com.olx.service;

import java.util.List;
import java.util.Locale.Category;

import com.olx.dto.Categories;

import ch.qos.logback.core.status.Status;

public interface MasterDataService {
	//public MasterDataService addNewAdvertise(MasterDataService data,String authToken);
	//public MasterDataService updateAdvertise(int id,MasterDataService data,String authToken);
	//public List<MasterDataService> getAllMasterData(String authToken);
	//public MasterDataService getMasterDataOfUserById(int id,String authToken);
	//public boolean deleteMasterDataById(int id,String authToken);
	//public MasterDataService getMasterDataById(int id,String authToken);
	public List<Categories> getAllCategories();
	public List<Status> getAllStatus();
	


}
