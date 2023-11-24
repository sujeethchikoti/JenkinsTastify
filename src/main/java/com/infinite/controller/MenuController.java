package com.infinite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.model.MenuItem;
import com.infinite.model.Restaurant;
import com.infinite.service.IMenuService;

@RestController

@CrossOrigin("http://localhost:3000/")
public class MenuController {

	@Autowired
	IMenuService menuserv;

	@RequestMapping(value = "/menu/{restaurent_id}", method = RequestMethod.GET)
	public List<MenuItem> getMenu(@PathVariable int restaurent_id) {
		List<MenuItem> menuls = menuserv.getMenu(restaurent_id);
		return menuls;

	}

	@RequestMapping(value = "/cartitem/{item_id}", method = RequestMethod.GET)
	public List<MenuItem> getItem(@PathVariable int item_id) {
		List<MenuItem> menuls = menuserv.getItem(item_id);
		return menuls;

	}
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public List<MenuItem> getAllmenu() {
		return menuserv.getAllmenu();

	}
	@RequestMapping(value = "/menu1", method = RequestMethod.GET)
	public List<MenuItem> getMenu1(MenuItem item) {
		int id = 1;
		return menuserv.getMenu(id);

	}

	@RequestMapping(value = "/menu2", method = RequestMethod.GET)
	public List<MenuItem> getMenu2(MenuItem item) {
		int id = 2;
		return menuserv.getMenu(id);

	}

	@RequestMapping(value = "/menu3", method = RequestMethod.GET)
	public List<MenuItem> getMenu3(MenuItem item) {
		int id = 3;
		return menuserv.getMenu(id);

	}

	@RequestMapping(value = "/addmenu", method = RequestMethod.POST)
	public ResponseEntity<String> addmenu(@RequestBody MenuItem mitem) {

		try {

			menuserv.addmenuItem(mitem);
			return ResponseEntity.ok("Item is addedd.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Action Failed.");
		}
	}

	@RequestMapping(value = "/deletemenu", method = RequestMethod.POST)
	public ResponseEntity<String> deletemenu(@RequestBody MenuItem mitem) {
		
		int id = mitem.getItemId();
		System.out.print(id);
		try {

			menuserv.deletemenuItem(mitem,id);
			return ResponseEntity.ok("Item is deleted.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Action Failed.");
		}
	}
}
