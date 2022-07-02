package com.app.onlinedelivery.dto;

import lombok.Data;

public class StoresDto {
  
	@Data
	public static class GetStoresBySearch{
		private String name;
		private Long storeId;
		private String area;
	}

}
