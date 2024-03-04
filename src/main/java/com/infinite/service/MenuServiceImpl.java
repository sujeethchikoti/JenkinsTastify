package com.infinite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infinite.model.MenuItem;
import com.infinite.model.Restaurant;
import com.infinite.repository.IMenuDao;
@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	IMenuDao menudao;
	
	@Transactional
	public List<MenuItem> getMenu(int id) {
		// TODO Auto-generated method stub
		return menudao.getMenu(id);
	}

	@Transactional
	public List<MenuItem> getItem(int id) {
		// TODO Auto-generated method stub
		return menudao.getItem(id);
	}
	
	@Transactional
	public List<MenuItem> getAllmenu() {
		// TODO Auto-generated method stub
		return menudao.getAllmenu();
	}
	
	@Transactional
	public MenuItem addmenuItem(MenuItem mitem) {
		
		return menudao.addmenuItem(mitem);
	}

	@Transactional
	public void deletemenuItem(int id) {
		// TODO Auto-generated method stub
		menudao.deletemenuItem(id);
	}

	
	@Transactional
	public void addmenuItem(String name, Integer res_id, Integer rate) {
		// TODO Auto-generated method stub
		menudao.addmenuItem(name, res_id, rate);
	}

	


	
}
