package com.projetospring.primeiroSpring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(Object id) {
		super("ID: " + id + " not found!");
	}
}
