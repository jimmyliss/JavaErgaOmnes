package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.fae.model.Model;

public abstract class AbstractDaoHibernate<MODEL extends Model> {

	public List<MODEL> findAll() {
		//Busca a sess�o do Hibernate getSession()
		//Cria um HQL para buscar os usu�rio
		//E retorna uma lista com o resultado da consulta HQL
		return getSession().createQuery("from "+getModelClassName()).list();
	}
	
	public MODEL findById(Long id) {
		//Cria a consulta de Usuario por id
		Query query = getSession().createQuery("from "+getModelClassName()+" where id=:id");
		//Seta o par�metro id
		query.setLong("id", id);
		//Executa a consulta retornando um resultado apenas
		return (MODEL) query.uniqueResult();
	}	
	
	public void save(MODEL model) {
		//Salva o usu�rio
		//Faz as opera��o de update e insert
		//update quando o objeto tem id
		//insert quando o objeto n�o tem id
		getSession().saveOrUpdate(model);
	}
	
	
	public void remove(MODEL model) {
		//Remove o usu�rio da se de dados
		getSession().delete(model);
	}
	
	
	protected String getModelClassName() {
		String classname = this.getClass().getSimpleName();
		if(classname.endsWith("DaoHibernate")) {
			return classname.substring(0, classname.length() - 12);
		}
		return null;
	}
	
	public MODEL getNewModel() {
		try {
			String className = "edu.fae.model."+getModelClassName(); 
			return (MODEL) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	protected Session getSession() {
		return HibernateUtil.getSession();
	}
}
