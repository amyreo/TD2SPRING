package com.inti.service;

import java.util.List;

import com.inti.model.Magasin;

public interface IMagasinService {
	
	public List<Magasin> getMagasins();
	
	public Magasin getMagasin(int id);
	
	public void saveMagasin(Magasin prod);
	
	public void deleteMagasin(int id);
}
