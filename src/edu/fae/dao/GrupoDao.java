package edu.fae.dao;

import edu.fae.model.Grupo;

/**
 * Defini��o de Dao de produto
 * 
 * @author Jimmy Hardy Liss
 * @since 1.0
 */
public interface GrupoDao extends Dao<Grupo>{
	
	public Grupo findByName(String name);
}
