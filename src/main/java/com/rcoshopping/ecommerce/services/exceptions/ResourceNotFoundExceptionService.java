package com.rcoshopping.ecommerce.services.exceptions;

public class ResourceNotFoundExceptionService  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExceptionService(Object id) {
		super("Resource not found. Id " + id);
	}
}