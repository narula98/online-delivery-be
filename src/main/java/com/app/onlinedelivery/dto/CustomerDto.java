package com.app.onlinedelivery.dto;

import lombok.Data;

public class CustomerDto {

	@Data
	public static class CustomerLogin{
		private String email;
		private String password;
	}

	@Data
	public static class CustomerSignup{
		private String email;
		private String password;
		private String address;
		private float lattitude;
		private float longitude;
	}
}
