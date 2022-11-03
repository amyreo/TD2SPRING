package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Magasin;
import com.inti.repository.IMagasinRepository;

@Service
public class MagasinServiceImpl implements IMagasinService {

	@Autowired
	IMagasinRepository ipr;

	@Override
	public List<Magasin> getMagasins() {
		List<Magasin> lMagasin = ipr.findAll();
		return lMagasin;
	}

	@Override
	public Magasin getMagasin(int id) {
		return ipr.findById(id).get();
	}

	@Override
	public void saveMagasin(Magasin prod) {
		ipr.save(prod);

	}

	@Override
	public void deleteMagasin(int id) {
		ipr.delete(ipr.findById(id).get());

	}

}
