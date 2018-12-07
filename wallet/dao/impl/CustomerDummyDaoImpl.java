package com.sti.bootcamp.wallet.dao.impl;

import java.util.List;

import com.sti.bootcamp.wallet.dao.CustomerDao;
import com.sti.bootcamp.wallet.helper.CustomerDataHelper;
import com.sti.bootcamp.wallet.model.Customer;

public class CustomerDummyDaoImpl implements CustomerDao {
	
	@Override
	public void insert(Customer customer)  throws Exception{
		CustomerDataHelper.getInstance().insert(customer);
	}

	@Override
	public void update(Customer customer)  throws Exception{
		CustomerDataHelper.getInstance().update(customer);
	}

	@Override
	public void delete(int id)  throws Exception{
		CustomerDataHelper.getInstance().delete(id);
	}

	@Override
	public List<Customer> getList()  throws Exception{
		return CustomerDataHelper.getInstance().getAllData();
	}

}
