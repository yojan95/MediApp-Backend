package com.alexis.service;

import java.util.List;

import com.alexis.model.Menu;

public interface IMenuService extends ICRUD<Menu, Integer>{
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
