package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Magasin;


public interface IMagasinRepository extends JpaRepository<Magasin, Integer>{

	Magasin findByNom(String nom);
	Magasin findByAdresse (String adresse);
	Magasin findByCp (String cp);
	Magasin findByVille (String ville);
	
}
