package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {

	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public Double mediaDaConta(Conta conta) {

		TypedQuery<Double> query = em
				.createQuery(
						"select avg(m.valor) from Movimentacao m where m.conta = :conta and m.tipoMovimentacao = :tipo",
						Double.class);

		query.setParameter("conta", conta);
		query.setParameter("tipo", TipoMovimentacao.SAIDA);

		return query.getSingleResult();

	}

	public Long totalDeMovimentacoes(Conta conta) {
		TypedQuery<Long> query = em.createNamedQuery("totalDeMovimentacoes",
				Long.class);
		query.setParameter("conta", conta);

		return query.getSingleResult();
	}

}
