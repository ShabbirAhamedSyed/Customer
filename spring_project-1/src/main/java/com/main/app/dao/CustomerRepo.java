package com.main.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.app.model.Customer;
// This class handles all database logic and interact with DB
// below annotation will mark class as repository and it's objects will be managed by spring ioc container 
@Repository
public class CustomerRepo {
	// Dependency injection auto
	@Autowired
	private JdbcTemplate jdbc;
	// default constructor
	public CustomerRepo(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
		jdbc.execute("create database if not exists customer;");
		jdbc.execute("use customer;");
		jdbc.execute("create table if not exists details(id int primary key auto_increment,\r\n"
				+ "name varchar(50),\r\n"
				+ "email varchar(50),\r\n"
				+ "address varchar(50),\r\n"
				+ "contact varchar(10),\r\n"
				+ "country varchar(50));");	
	}
	
	// method to get all customer details it will return List<Map<String, Object>> of all customers
	public List<Map<String, Object>> findAll(){
		String query = "select * from details";
		List<Map<String, Object>> res =jdbc.queryForList(query);
		return res;
	}
	// method to get customer by id it will return List<Map<String, Object>> of customer
	public  List<Map<String, Object>> findById(int id){
		String query = "select * from details where id=?";
		 List<Map<String, Object>> res = jdbc.queryForList(query, id);
		 return res;
	}
        // method to insert new customer it will return integer
	public int insertNewCus(Customer cus) {
		// TODO Auto-generated method stub
		String query="insert into details(name,email,address,contact,country) values(?,?,?,?,?)";
		int res =jdbc.update(query,cus.getName(),cus.getEmail(),cus.getAddress(),cus.getContact(),cus.getCountry());
		return res;
	}
        // method to update existing customer it will return 1 or 0 
	public int update(Customer cus) {
		// TODO Auto-generated method stub
		String query="update details set name=?,email=?,address=?,contact=?,country=? where id=?";
		int res = jdbc.update(query,cus.getName(),cus.getEmail(),cus.getAddress(),cus.getContact(),cus.getCountry(),cus.getId());
		return res;
	}
        //  method to delete a existing customer it return 1 or 0
	public int delete(int id) {
		// TODO Auto-generated method stub
		String query = "delete from details where id=?";
		int res = jdbc.update(query, id);
		return res;
	}
	
	

}
