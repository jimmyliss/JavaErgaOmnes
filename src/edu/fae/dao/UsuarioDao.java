package edu.fae.dao;

import edu.fae.model.Usuario;

/**
 * Defini��o de Dao de Usu�rio
 * 
 * @author Jimmy Hardy Liss
 * @since 1.0
 */
public interface UsuarioDao extends Dao<Usuario>{

	
	public Usuario login(String usuario, String senha);
}
