package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inti.model.Magasin;

public interface IMagasinRepository extends JpaRepository<Magasin, Integer> {

	Magasin findByNom(String nom);

	Magasin findByAdresse(String adresse);

	Magasin findByCp(String cp);

	Magasin findByVille(String ville);

	Magasin findByCpAndVille(String cp, String ville);

	@Query(value = "select max(id) from magasin_spring", nativeQuery = true)
	int findMaxId();

	@Query(value = "update magasin set adresse=:adresse, cp:=cp where id=:id", nativeQuery = true)
	void updateAdresseAndCpById(@Param("adresse") String adresse, @Param("cp") String cp, @Param("id") int id);

}
