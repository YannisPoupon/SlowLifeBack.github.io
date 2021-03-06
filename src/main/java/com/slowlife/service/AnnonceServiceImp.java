package com.slowlife.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.slowlife.dao.AnnonceDao;
import com.slowlife.entity.Annonce;
import com.slowlife.entity.Producteur;

@Service
public class AnnonceServiceImp implements AnnonceService{
	
	@Autowired
	AnnonceDao aDao;


	@Override
	public void save(Annonce annonce) {
		aDao.save(annonce);
	}

	@Override
	public Annonce findById(int id) {
		return aDao.findById(id).get();
	}

	@Override
	public List<Annonce> findAll() {
		return aDao.findAll();
	}

	@Override
	public void delete(int id) {
		aDao.deleteById(id);
		
	}

	@Override
	public List<Annonce> findByProducteur(Producteur p) {
		// TODO Auto-generated method stub
		return aDao.findByProducteur(p);
	}

	@Override
	public List<Annonce> findComByNomAndVille(String ville, Date dateDebut, Date dateFin) {
		// TODO Auto-generated method stub
		return aDao.findComByNomAndVille(ville, dateDebut, dateFin);
	}
	
	

}
