package edu.fae.dao.hibernate;

import org.hibernate.Query;

import edu.fae.dao.GrupoDao;
import edu.fae.model.Grupo;

/**
 * Implementa��o do ProdutoDao em Hibernate
 * @author Jimmy Hardy Liss
 * @since 1.0
 */
public class GrupoDaoHibernate extends AbstractDaoHibernate<Grupo> implements GrupoDao {

	public Grupo findByName(String name) {
		Query query = getSession().createQuery("from Grupo where nome like :name");
		//Seta o par�metro id
		query.setString("name", name);
		//Executa a consulta retornando um resultado apenas
		return (Grupo) query.uniqueResult();
	}
	
}
