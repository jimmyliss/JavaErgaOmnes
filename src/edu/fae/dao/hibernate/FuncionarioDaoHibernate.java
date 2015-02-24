package edu.fae.dao.hibernate;

import edu.fae.dao.FuncionarioDao;
import edu.fae.model.Funcionario;

/**
 * Implementa��o do UsuarioDao em Hibernate
 * @author Jimmy Hardy Liss
 * @since 1.0
 */
public class FuncionarioDaoHibernate extends AbstractDaoHibernate<Funcionario> implements FuncionarioDao {

	/*public Usuario login(String usuario, String senha) {
		//Cria a consulta de Usuario por id
		Query query = getSession().createQuery("from Usuario where username=:username and senha=:senha");
		//Seta o par�metro id
		query.setString("username", usuario);
		query.setString("senha", Util.gerarMD5(senha));
		//Executa a consulta retornando um resultado apenas
		return (Usuario) query.uniqueResult();	
	}
*/
	
}
