package com.rcoshopping.ecommerce.services.exceptions;

public class DatabaseExceptionService extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public DatabaseExceptionService(String message) {
		super(message);
	}
}
