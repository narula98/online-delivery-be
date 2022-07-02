package com.app.onlinedelivery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.onlinedelivery.dto.StoresDto;
import com.app.onlinedelivery.models.Items;
import com.app.onlinedelivery.models.Stores;
import com.app.onlinedelivery.repositories.ItemRepository;
import com.app.onlinedelivery.repositories.StoreRepository;

@RestController
@RequestMapping("/items")
public class ItemsController {
   
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private ItemRepository itemsRepository;
	
	
	@GetMapping("/search")
	public ResponseEntity<?> getStoreForItemSearch(@RequestParam String searchText){
	  List<Stores> getStores =	storeRepository.findAll();
	  List<StoresDto.GetStoresBySearch> getStoreNames = new ArrayList<>(); 
	  for(Stores store : getStores) {
		List<Items> itemList= store.getItemList().stream().filter(x->x.getName().equals(searchText)).collect(Collectors.toList());
		if(!itemList.isEmpty()) {
			StoresDto.GetStoresBySearch searchedStores = new StoresDto.GetStoresBySearch();
			searchedStores.setName(store.getStore_name());
			searchedStores.setStoreId(store.getStoreid());
			getStoreNames.add(searchedStores);
		}
	  }
	  
	  if(!getStoreNames.isEmpty()){
		  return new ResponseEntity(getStoreNames, HttpStatus.ACCEPTED);
	  }
	  return new ResponseEntity(null, HttpStatus.ACCEPTED);
	}
	
   @GetMapping("/getStoreItems")
   public ResponseEntity<?> getItemsByStoreId(@RequestParam Long storeId){
	   Stores store = storeRepository.getReferenceById(storeId);
	   if(store != null) {
		   return new ResponseEntity(store.getItemList(), HttpStatus.ACCEPTED);
	   }
	   
	   return new ResponseEntity("Incorrect store id",HttpStatus.BAD_REQUEST);
   }

}
