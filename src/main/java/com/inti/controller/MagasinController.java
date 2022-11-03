package com.inti.controller;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Magasin;
import com.inti.model.Produit;
import com.inti.repository.IMagasinRepository;
import com.inti.repository.IProduitRepository;
import com.inti.service.MagasinServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("magasin")
public class MagasinController {

	@Autowired
	MagasinServiceImpl psi;

	@Autowired
	IMagasinRepository imr;

	@Autowired
	IProduitRepository ipr;

	@PostMapping("/saveMagasin")
	public void saveMagasin(@RequestBody Magasin prod) {
		if (prod != null) {
			psi.saveMagasin(prod);
		}
		log.error("L'objet magasin " + prod + "n'a pas pu être enregistré en BDD.");
	}

	@GetMapping("/getMagasin/{id}")
	public Magasin getMagasin(@PathVariable int id) {
		return psi.getMagasin(id);
	}

	@GetMapping("/getMagasins")
	public List<Magasin> getMagasins() {
		return psi.getMagasins();
	}

	@PostMapping("deleteMagasin/{id}")
	public boolean deleteMagasin(@PathVariable int id) {
		
		int maxId = imr.findMaxId();
		log.info("maxID : " + maxId);
		if (id > 0 && id < maxId) {
			imr.deleteById(id);
			return true;
		}
		return false;
	}

	@PostMapping("associerProduits/{id}")
	public boolean associerProduitsToMagasin(@PathVariable int id) {

		try {
			Magasin magasin = imr.findById(id).get();
			List<Produit> listeProduit = ipr.findAll();
			magasin.setLProduit(listeProduit);
			imr.save(magasin);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	@GetMapping("byName/{nom}")
	public Magasin getMagasinByNom(@PathVariable String nom) {
		return imr.findByNom(nom);
	}
	
	@GetMapping("byCpAndVille")
	public Magasin getMagasinByCpAndVille(@RequestParam(name = "cp") String cp, @RequestParam(name = "ville") String ville) {
		return imr.findByCpAndVille(cp, ville);
	}
	
	@PostMapping("updateAdresseCp")
	public void updateMagasinByAdresseAndCp(@RequestParam(name = "adresse") String adresse, @RequestParam(name = "cp") String cp, @RequestParam(name = "id") int id) {
		imr.updateAdresseAndCpById(adresse, cp, id);
	}
	
	
}
