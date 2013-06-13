package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.jpa.util.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TesteJPARelacionamento {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Maria dos Santos");
		conta.setBanco("Caixa");
		conta.setAgencia("043");
		conta.setNumero("54321");

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal(123.9));
		movimentacao.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		em.persist(conta);
		em.persist(movimentacao);

		em.getTransaction().commit();
		em.close();

	}
}