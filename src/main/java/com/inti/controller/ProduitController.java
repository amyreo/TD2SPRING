package com.inti.controller;

import java.util.ArrayList;
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
import com.inti.service.ProduitServiceImpl;

@RestController
@RequestMapping("produit")
public class ProduitController {

	@Autowired
	ProduitServiceImpl psi;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Produit_Magasin", joinColumns = @JoinColumn(name = "Produit"), inverseJoinColumns = @JoinColumn(name = "Magasin"))
	List<Magasin> lMagasin;
	
	@GetMapping("/affichage")
	public String affichageNomProduit(
			@RequestParam(name = "nom", defaultValue = "Chaise", required = true) String nomp) {
		return nomp;
	}

	@GetMapping("/prix")
	public double affichagePrixProduit(
			@RequestParam(name = "prix", defaultValue = "15", required = true) double prixp) {
		return prixp;
	}

	@GetMapping("/calcul")
	public List<String> affichageCalculProduit(
			@RequestParam(name = "nom", defaultValue = "Jesaispasencore", required = true) String nomp,
			@RequestParam(name = "prixHT", defaultValue = "136", required = true) double prixht) {
		List<String> results = new ArrayList<>();
		double prixttc = 1.8 * prixht;
		String prixttcString = Double.toString(prixttc);
		results.add(nomp);
		results.add(prixttcString);
		return results;
	}

	@PostMapping("/saveProduit")
	public void saveProduit(@RequestBody Produit prod) {
		System.out.println(prod.toString());
		psi.saveProduit(prod);
	}

	@GetMapping("/getProduit/{id}")
	public Produit getProduit(@PathVariable int id) {
		return psi.getProduit(id);
	}

	@GetMapping("/getProduits")
	public List<Produit> getProduits() {
		return psi.getProduits();
	}

	@PostMapping("deleteProduit")
	public void deleteProduit(@PathVariable int id) {
		System.out.println(psi.getProduit(id).toString());
		psi.deleteProduit(id);
	}
}
