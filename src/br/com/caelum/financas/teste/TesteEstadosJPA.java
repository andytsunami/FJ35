package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.jpa.util.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TesteEstadosJPA {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Maria dos Santos");
		conta.setBanco("Caixa");
		conta.setAgencia("043");
		conta.setNumero("54321");

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		em.close();

	}
}