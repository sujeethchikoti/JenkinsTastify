package com.infinite.service;

import java.util.List;

import com.infinite.model.MenuItem;
import com.infinite.model.Restaurant;

public interface IMenuService {

	public List<MenuItem> getMenu(int restaurent_id);
	
	public List<MenuItem> getItem(int id);
	
	public List<MenuItem> getAllmenu();

public MenuItem addmenuItem(MenuItem mitem);
	
public MenuItem deletemenuItem(MenuItem mitem,int id);
	
}
