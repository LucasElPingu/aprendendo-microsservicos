package com.lucaselpingu.hrworker.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	//Recebe um object como parametro e chama o construtor da super classe mandando a mensgem
	public ResourceNotFoundException(Object id) {
		super("Id " + id + " Not Found!!!");
	}
}
