package edu.fae.dao;

import java.util.List;

import edu.fae.model.Produto;

/**
 * Defini��o de Dao de produto
 * 
 * @author Robson J. P.
 * @since 1.0
 */
public interface ProdutoDao extends Dao<Produto>{

	public List<Produto> listaPorCategoria(Long id);
}
