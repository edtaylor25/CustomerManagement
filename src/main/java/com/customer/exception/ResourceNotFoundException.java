package com.customer.exception;

public class ResourceNotFoundException extends RuntimeException{
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("customer not found", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
