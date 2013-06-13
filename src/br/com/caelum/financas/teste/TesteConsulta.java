package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsulta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(1);

		Query query = em
				.createQuery("select m from Movimentacao m where m.conta.id = "
						+ conta.getId());

		@SuppressWarnings("unchecked")
		List<Movimentacao> movimentacoes = query.getResultList();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("\nValor R$ " + movimentacao.getValor());
			System.out.println("Descricacao: " + movimentacao.getDescricao());
		}

		em.close();

	}

}
