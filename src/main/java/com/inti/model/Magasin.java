package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "Magasin_spring")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Magasin {

	@Id
	@NonNull
	private int id;
	private String nom;
	private String adresse;
	private String cp;
	private String ville;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Produit_Magasin", joinColumns = @JoinColumn(name = "Magasin"), inverseJoinColumns = @JoinColumn(name = "Produit"))
	List<Produit> lProduit;
}
