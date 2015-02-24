package edu.fae.dao.hibernate;

import org.hibernate.Query;

import edu.fae.dao.UsuarioDao;
import edu.fae.model.Usuario;
import edu.fae.util.Util;

/**
 * Implementa��o do UsuarioDao em Hibernate
 * @author Jimmy Hardy Liss
 * @since 1.0
 */
public class UsuarioDaoHibernate extends AbstractDaoHibernate<Usuario> implements UsuarioDao {

	public Usuario login(String usuario, String senha) {
		//Cria a consulta de Usuario por id
		Query query = getSession().createQuery("from Usuario where username=:username and senha=:senha");
		//Seta o par�metro id
		query.setString("username", usuario);
		query.setString("senha", Util.gerarMD5(senha));
		//Executa a consulta retornando um resultado apenas
		return (Usuario) query.uniqueResult();	
	}

	
}
