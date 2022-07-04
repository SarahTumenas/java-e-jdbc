package br.com.alura.lojavirtual.controller;

import java.sql.Connection;

import java.util.List;

import br.com.alura.lojavirtual.dao.CategoriaDAO;
import br.com.alura.lojavirtual.factory.ConnectionFactory;
import br.com.alura.lojavirtual.modelo.Categoria;


public class CategoriaController {

	private CategoriaDAO categoriaDao;

	public CategoriaController()  {
		Connection connection = new ConnectionFactory().recuperarConexao();

		this.categoriaDao = new CategoriaDAO(connection);
	}

	public List<Categoria> listar()  {

		return this.categoriaDao.listar();
	}
}
