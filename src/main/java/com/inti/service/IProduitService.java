package com.inti.service;

import java.util.List;

import com.inti.model.Produit;


public interface IProduitService {

	
	public List<Produit> getProduits();
	
	public Produit getProduit(int id);
	
	public void saveProduit(Produit prod);
	
	public void deleteProduit(int id);

}
