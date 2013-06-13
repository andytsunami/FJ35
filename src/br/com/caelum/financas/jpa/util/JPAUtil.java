package br.com.caelum.financas.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("contas-mysql");

	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
