package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.ProdutoDao;
import edu.fae.model.Produto;

/**
 * Implementa��o do ProdutoDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
public class ProdutoDaoHibernate extends AbstractDaoHibernate<Produto> implements ProdutoDao {

	public List<Produto> listaPorCategoria(Long id) {
		//Cria a consulta de Produto por Categoria
		Query query = getSession().createQuery("from Produto where categoria.id=:id");
		//Seta o par�metro id
		query.setLong("id", id);
		//Executa a consulta retornando um resultado apenas
		List<Produto> produtos = query.list();
		return produtos;
	}
	
}
