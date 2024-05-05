package com.invento.product.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {

	private String message;
	
	public ErrorResponse(String message) {
		
		super();
		this.message = message;
	}
}
