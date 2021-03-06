package com.slowlife.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slowlife.dao.AdminDao;
import com.slowlife.entity.Admin;

@Service
public class AdminServiceImp implements AdminService{
	
	@Autowired
	AdminDao aDao;


	@Override
	public void save(Admin admin) {
		aDao.save(admin);
	}

	@Override
	public Admin findById(int id) {
		return aDao.findById(id).get();
	}

	@Override
	public List<Admin> findAll() {
		return aDao.findAll();
	}

	@Override
	public void delete(int id) {
		aDao.deleteById(id);
		
	}
	
	

}
