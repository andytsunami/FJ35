package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.jpa.util.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaContaMovimentacoes {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		Query query = em
				.createQuery("select distinct c from Conta c join fetch c.movimentacoes where c.id = 1");

		Conta conta = (Conta) query.getSingleResult();

		em.close();

		System.out.println(conta.getMovimentacoes().size());

	}

}
