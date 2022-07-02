package com.app.onlinedelivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.onlinedelivery.dto.StoresDto;
import com.app.onlinedelivery.models.Stores;
import com.app.onlinedelivery.repositories.StoreRepository;

@RestController
@RequestMapping("/store")
@CrossOrigin(origins = "*")
public class StoreController {
 
	@Autowired
	private StoreRepository storeRepository;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllStores(){
		List<Stores> storeList = storeRepository.findAll();
		List<StoresDto.GetStoresBySearch> storeListResp = new ArrayList<StoresDto.GetStoresBySearch>();
			storeRepository.findAll().forEach((store)->{
			StoresDto.GetStoresBySearch resp = new StoresDto.GetStoresBySearch();
			resp.setName(store.getStore_name());
			resp.setStoreId(store.getStoreid());
			resp.setArea(store.getArea());
			storeListResp.add(resp);
		});
	    return new ResponseEntity(storeListResp, HttpStatus.ACCEPTED);
	}
}
