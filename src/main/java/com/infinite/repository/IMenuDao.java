package com.infinite.repository;

import java.util.List;

import com.infinite.model.MenuItem;

public interface IMenuDao {

	public List<MenuItem> getMenu(int id);

	public List<MenuItem> getItem(int id);
	
	public List<MenuItem> getAllmenu();

	public MenuItem addmenuItem(MenuItem mitem);

	public MenuItem deletemenuItem(MenuItem mitem,int id);
}
