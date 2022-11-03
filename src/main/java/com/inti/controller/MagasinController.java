package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Magasin;
import com.inti.service.MagasinServiceImpl;

@RestController
@RequestMapping("magasin")
public class MagasinController {

	
	
	
	@Autowired
	MagasinServiceImpl psi;

	@PostMapping("/saveMagasin")
	public void saveMagasin(@RequestBody Magasin prod) {
		System.out.println(prod.toString());
		psi.saveMagasin(prod);
	}

	@GetMapping("/getMagasin/{id}")
	public Magasin getMagasin(@PathVariable int id) {
		return psi.getMagasin(id);
	}

	@GetMapping("/getMagasins")
	public List<Magasin> getMagasins() {
		return psi.getMagasins();
	}

	@PostMapping("deleteMagasin")
	public void deleteMagasin(@PathVariable int id) {
		System.out.println(psi.getMagasin(id).toString());
		psi.deleteMagasin(id);
	}
}
