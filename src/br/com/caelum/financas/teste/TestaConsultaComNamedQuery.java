package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConsultaComNamedQuery {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		MovimentacaoDao dao = new MovimentacaoDao(em);

		Conta conta = new Conta();
		conta.setId(1);

		System.out.println(dao.totalDeMovimentacoes(conta));

	}

}
