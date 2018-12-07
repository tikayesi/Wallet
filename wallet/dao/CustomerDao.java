package com.sti.bootcamp.wallet.dao;

import java.util.List;

import com.sti.bootcamp.wallet.model.Customer;

public interface CustomerDao {
	void insert(Customer customer) throws Exception;
	void update(Customer customer) throws Exception;
	void delete(int id) throws Exception;
	List<Customer> getList() throws Exception;
}
