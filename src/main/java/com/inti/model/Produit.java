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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="ProduitSpring")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Produit {
	
	@Id
	@NonNull
	private int id;
	private String nom;
	private String reference;
	private double prix;
	private double poids;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Produit_Magasin", joinColumns = @JoinColumn(name = "Produit"), inverseJoinColumns = @JoinColumn(name = "Magasin"))
	@JsonIgnore
	List<Magasin> lMagasin;
	
}
