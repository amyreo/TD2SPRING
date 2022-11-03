package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "Magasin_spring")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Magasin {
	
	@Id
	@NonNull
	private int id;
	private String nom;
	private String adresse;
	private String cp;
	private String ville;

}
