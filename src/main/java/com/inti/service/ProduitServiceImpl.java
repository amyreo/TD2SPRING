package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Produit;
import com.inti.repository.IProduitRepository;

@Service
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	IProduitRepository ipr;

	@Override
	public Produit getProduit(int id) {

		return ipr.findById(id).get();
	}

	@Override
	public List<Produit> getProduits() {
		List<Produit> lProduit = ipr.findAll();
		return lProduit;
	}

	@Override
	public void saveProduit(Produit prod) {
		ipr.save(prod);

	}

	@Override
	public void deleteProduit(int id) {
		ipr.delete(ipr.findById(id).get());

	}

}
