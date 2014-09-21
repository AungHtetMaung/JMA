package com.jms.servicecontroller.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf;
	static {
		try {
			emf = Persistence.createEntityManagerFactory("JPAUnit");
			System.out.println("get em");
		}catch(Throwable e) {
			System.out.println("em"+e.getMessage());
		}
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
