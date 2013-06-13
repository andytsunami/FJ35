package br.com.caelum.financas.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.caelum.financas.jpa.util.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TesteJPA {

	public static void main(String[] args) {
		Long inicio = System.currentTimeMillis();

		Conta conta = new Conta();
		conta.setTitular("Maria dos Santos");
		conta.setBanco("Caixa");
		conta.setAgencia("043");
		conta.setNumero("54321");
		conta.setSaldo(new BigDecimal(666.0));

		/**
		 * Usando HSQLDB
		 */

		// EntityManagerFactory emf = Persistence
		// .createEntityManagerFactory("contas-hsqldb");

		/**
		 * Usando PostgreSQL
		 */
		// EntityManagerFactory emf = Persistence
		// .createEntityManagerFactory("contas-postgres");

		/**
		 * Usando MySQL
		 */

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		em.close();
		Long fim = System.currentTimeMillis();
		System.out.println("Executado em " + (fim - inicio) / 1000 + "s");
	}
}
