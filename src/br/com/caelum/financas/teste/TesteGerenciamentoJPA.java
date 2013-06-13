package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.jpa.util.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TesteGerenciamentoJPA {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 1);

		em.getTransaction().commit();

		conta.setTitular("Lala");
		em.getTransaction().begin();
		em.merge(conta);
		em.getTransaction().commit();
		em.close();

	}

}
