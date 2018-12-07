package com.sti.bootcamp.wallet.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sti.bootcamp.wallet.model.Customer;

public class CustomerDataHelper {
	private static int counter = 0;
	
	private static Map<Integer, Customer> mapData = null;
	private static CustomerDataHelper instance = null;
	
	private static Map<Integer, Customer> getMapData(){
		if(mapData == null) {
			mapData = new HashMap<>();
		}
		return mapData;
	}
	
	public List<Customer> getAllData(){
		return new ArrayList<>(getMapData().values());				
	}
	
	public void insert(Customer customer) {
		customer.setCustomerNumber(++counter);
		if(!getMapData().containsKey(customer.getCustomerNumber())) {
			getMapData().put(customer.getCustomerNumber(), customer);
		}
	}
	
	public void update(Customer customer) {
		Customer updateCustomer = getMapData().get(customer.getCustomerNumber());
		if(updateCustomer!=null) {
			updateCustomer.setBirthDate(customer.getBirthDate());
			updateCustomer.setFirstName(customer.getFirstName());
			updateCustomer.setLastName(customer.getLastName());
			updateCustomer.setUsername(customer.getUsername());
			updateCustomer.setPassword(customer.getPassword());
			updateCustomer.setPhoneNumber(customer.getPhoneNumber());
			updateCustomer.setPhoneType(customer.getPhoneType());
			
			getMapData().put(updateCustomer.getCustomerNumber(), updateCustomer);
		}
	}
	
	public void delete(int id) {
		if(getMapData().containsKey(id)) {
			getMapData().remove(id);
		}
	}
	
	public static CustomerDataHelper getInstance() {
		if(instance == null) {
			instance = new CustomerDataHelper();
		}
		return instance;
	}
}
