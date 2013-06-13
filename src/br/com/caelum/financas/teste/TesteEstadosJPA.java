package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.jpa.util.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TesteEstadosJPA {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 1);

		System.out.println(conta.getTitular());

		// Testes do capitulo

		em.getTransaction().commit();

		em.close();

	}
}