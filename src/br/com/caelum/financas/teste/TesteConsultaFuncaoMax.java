package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		Conta conta = em.find(Conta.class, 1);

		Query query = em
				.createQuery("select max(m.valor) from Movimentacao m where m.conta = :conta");

		query.setParameter("conta", conta);

		BigDecimal quant = (BigDecimal) query.getSingleResult();

		System.out.println(quant);

	}

}
