package com.cadsys;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeradorDeTabelas {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica;
		fabrica = Persistence.createEntityManagerFactory("cadsys");
		
		fabrica.close();
	}

}
