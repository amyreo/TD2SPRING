package com.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Produit;
import com.inti.repository.IProduitRepository;

@RestController
@RequestMapping("produit")
public class ProduitController {

	IProduitRepository ipr;

	@PostMapping("/affichageProduit")
	public String affichageNomProduit(
			@RequestParam(name = "nom", defaultValue = "Jesaispasencore", required = true) String nomp) {
		return nomp;
	}

	@PostMapping("/prix")
	public double affichagePrixProduit(
			@RequestParam(name = "prix", defaultValue = "15", required = true) double prixp) {
		return prixp;
	}

	@PostMapping("/calcul")
	public List<String> affichageCalculProduit(@RequestParam(name = "nom",defaultValue = "Jesaispasencore", required = true) String nomp, @RequestParam(name = "prixHT", defaultValue = "136", required = true) double prixht) {
		List<String> results = new ArrayList<>();
		double prixttc = 1.8 * prixht;
		String prixttcString = Double.toString(prixttc);
		results.add(nomp);
		results.add(prixttcString);
		return results;
	}
}
