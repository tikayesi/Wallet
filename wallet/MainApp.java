package com.sti.bootcamp.wallet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.sti.bootcamp.wallet.dao.CustomerDao;
import com.sti.bootcamp.wallet.dao.impl.CustomerDBDaoImpl;
import com.sti.bootcamp.wallet.dao.impl.CustomerDummyDaoImpl;
import com.sti.bootcamp.wallet.model.Customer;

public class MainApp {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws ParseException, Exception{
		CustomerDao customerDao = new CustomerDummyDaoImpl();
		
		Customer customer1 = new Customer(0, "roy", "kumo", dateFormat.parse("1998-02-19"), "roykumo", "P@ssw0rd", "08123123123", "android");
		Customer customer2 = new Customer(0, "alex", "zander", dateFormat.parse("2000-04-14"), "alexzander", "P@ssw0rd", "0823232323", "iphone");
		
		customerDao.insert(customer1);
		customerDao.insert(customer2);
		
		List<Customer> list = customerDao.getList();
		if(list!=null && !list.isEmpty()) {
			for (Customer customer : list) {
				System.out.println("customer\t\t : "+customer.getCustomerNumber());
				System.out.println("firstName\t : "+customer.getFirstName());
				System.out.println("lastName\t\t : "+customer.getLastName());
				System.out.println("==================================");
			}
		}else {
			System.out.println("empty data");
		}
	}

}
