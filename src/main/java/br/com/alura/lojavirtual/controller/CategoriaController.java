package br.com.alura.lojavirtual.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.lojavirtual.modelo.Categoria;


public class CategoriaController {

	public List<Categoria> listar() {
		List<Categoria> categorias = 
				new ArrayList<>();
		categorias.add(new Categoria(1, "Categoria de teste")); 
		return categorias;
	}
}
