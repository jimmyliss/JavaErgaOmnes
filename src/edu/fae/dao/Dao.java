package edu.fae.dao;

import java.util.List;

import edu.fae.model.Model;

public interface Dao<MODEL extends Model> {
	/**
	 * Busca todos os us�rios
	 * 
	 * @return
	 */
	public List<MODEL> findAll();
	
	/**
	 * Salva um usu�rio. Inser��o e altera��o
	 * 
	 * @param usuario
	 */
	public void save(MODEL object);
	
	/**
	 * Remove um usu�rio
	 * @param usuario
	 */
	public void remove(MODEL object);
	
	/**
	 * Procura um usu�rio por id
	 * @param id 
	 * @return Usu�rio encontrado
	 */
	public MODEL findById(Long id);
	
	public MODEL getNewModel();
}
