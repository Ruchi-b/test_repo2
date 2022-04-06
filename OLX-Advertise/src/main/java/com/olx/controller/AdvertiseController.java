package com.olx.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.olx.service.AdvertiseService;

import ch.qos.logback.core.status.Status;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@RestController
@RequestMapping("/olx")
@CrossOrigin(origins="*")
public class AdvertiseController {
	
	@Autowired
	AdvertiseService advertiseService;

	@PostMapping(value="/advertise",consumes=MediaType.APPLICATION_JSON_VALUE, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Reads all advertisement", notes="This api returns all users advertisement")
	public AdvertiseService addNewAdvertise(@RequestBody AdvertiseService data,@RequestHeader("auth-token") String authToken) {
	return  ((AdvertiseController) advertiseService).addNewAdvertise(data, authToken);
	}

	@PutMapping(value="/advertise/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Reads all advertisement id", notes="This api returns all users advertisement")
	public AdvertiseService updateAdvertise(@PathVariable("id") int id,@RequestBody AdvertiseService data,@RequestHeader("auth-token") String authToken) {
	return  advertiseService.updateAdvertise(id, data, authToken);
	}

	@GetMapping(value="/user/advertise", produces= {MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Reads all advertisement", notes="This api returns all users advertisement")
	public List<AdvertiseService> getAllMasterData(@RequestHeader("auth-token") String authToken){
	return  (List<AdvertiseService>) advertiseService.getAllAdvertiseService(authToken);
	}

	@GetMapping(value="/user/advertise/{advertiseId}", produces= {MediaType.APPLICATION_JSON_VALUE
			, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Reads all advertisement", notes="This api returns all users advertisement")
	public AdvertiseService getMasterDataOfUserById(@ApiParam(value="advertise id", name="id")@PathVariable("advertiseId") int id,@RequestHeader("auth-token") String authToken) {
	return  advertiseService.getAdvertiseServiceOfUserById(id,authToken);
	}

	@DeleteMapping(value="/user/advertise/{advertiseId}")
	@ApiOperation(value="Reads all advertisement", notes="This api returns all users advertisement")
	public boolean deleteMasterDataById(@PathVariable("advertiseId") int id,@RequestHeader("auth-token") String authToken) {
	return  advertiseService.deleteAdvertiseServiceById(id,authToken);
	}
	
	@GetMapping(value="/search/filtercriteria", produces= {MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Reads all advertisement", notes="This api returns all users advertisement")
	public List<AdvertiseService> searchAdvertisesByFilterCriteria(@RequestParam("searchText")String searchText,
	@RequestParam(name = "category", required = false)int categoryId, @RequestParam("postedBy")String postedBy,
	@RequestParam("dateCondition")String dateCondition,
	@RequestParam("onDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate onDate,
	@RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
	@RequestParam("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
	@RequestParam("sortedBy")String sortedBy, @RequestParam(name = "startIndex", defaultValue="0")int startIndex, @RequestParam(name="records", defaultValue = "10")int records
	) {
	return AdvertiseService.searchAdvertisesByFilterCriteria(searchText, categoryId, postedBy, dateCondition,
	onDate, fromDate, toDate, sortedBy, startIndex, records);
	}
	
	//14
	@GetMapping(value = "/advertise/search ", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Reads all advertisement", notes="This api returns all users advertisement")
	public AdvertiseService SearchAdvByText(String searchText){
	return advertiseService.SearchAdvertiseServiceByText(searchText);
	}


	//15

	@GetMapping(value = "/advertise/{advertiseId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Reads all advertisement", notes="This api returns all users advertisement")
	public AdvertiseService returnAdv(String id){
	return advertiseService.getAllAdvertiseService(id);
	}
	


}
