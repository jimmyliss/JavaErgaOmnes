package edu.fae.dao.hibernate;

import java.util.Date;

import edu.fae.dao.PedidoDao;
import edu.fae.model.Pedido;

/**
 * Implementação do PedidoDao em Hibernate
 * @author JimmyLiss
 * @since 1.0
 */
public class PedidoDaoHibernate extends AbstractDaoHibernate<Pedido> implements PedidoDao {

	@Override
	public Pedido getNewModel() {
		Pedido pedido = new Pedido();
		pedido.setDataAtual(new Date());
		return pedido;
	}

	
}
