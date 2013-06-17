package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		Conta conta = em.find(Conta.class, 1);

		TypedQuery<Long> query = em.createQuery(
				"select count(m) from Movimentacao m where m.conta = :conta",
				Long.class);

		query.setParameter("conta", conta);

		Long quant = query.getSingleResult();

		System.out.println(quant);

	}

}
