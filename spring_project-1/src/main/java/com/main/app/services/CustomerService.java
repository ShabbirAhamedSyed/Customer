package com.main.app.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.app.dao.CustomerRepo;
import com.main.app.model.Customer;
// In this class we have all methods to interact with DAO(Repository)
// the below annotation mark class as service it will have it's business logic 
// it create spring bean managed by spring IOC(creating,initializing,destruction)  for dependencies injection
@Service
public class CustomerService {
	// dependency injection of CustomerRepo automatically
	@Autowired
	private CustomerRepo repo;
	// this method will call the findAll method in repo and returns the List<Map<String, Object>> of all customers
	public List<Map<String, Object>> getAllCus(){
		List<Map<String, Object>> res = this.repo.findAll();
		return res;
		
	}
	//  this method will call the findById method in repo and returns the List<Map<String, Object>> of all customers
	public  List<Map<String, Object>> getById(int id){
		 List<Map<String, Object>> res = this.repo.findById(id);
		 return res;
	}
	 // this method will call the insertNewCus method in repo and returns the integer
	public int insertCus(Customer cus) {
		// TODO Auto-generated method stub
		int res = this.repo.insertNewCus(cus);
		return res;
	}
	//  this method will call the update method in repo and returns the integer
	public int updateCus(Customer cus) {
		// TODO Auto-generated method stub
		int res = this.repo.update(cus);
		return res;
	}
	//  this method will call the delete method in repo and returns the integer
	public int delById(int id) {
		// TODO Auto-generated method stub
		int res = this.repo.delete(id);
		return res;
	}
	

}
