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

import com.olx.dto.Categories;
import com.olx.service.MasterDataService;

import ch.qos.logback.core.status.Status;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/olx")
@CrossOrigin(origins="*")
public class MasterDataController {
	
	@Autowired
	MasterDataService masterDataService;

	
	@GetMapping(value="/categories",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Reads all categories", notes="This api returns all categories")
	public List<Categories> getAllCategories() {
		return masterDataService.getAllCategories();
	}

	@GetMapping(value="/status",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Reads all status", notes="This api returns status")
	public List<Status> getAllStatus() {
	return masterDataService.getAllStatus();
	}
	


}
