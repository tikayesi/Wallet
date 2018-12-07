package com.sti.bootcamp.wallet.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sti.bootcamp.wallet.dao.CustomerDao;
import com.sti.bootcamp.wallet.helper.CustomerDataHelper;
import com.sti.bootcamp.wallet.model.Customer;

public class CustomerDBDaoImpl implements CustomerDao {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
	@Override
	public void insert(Customer customer) throws Exception{
		preparedStatement = getConnection()
                .prepareStatement("INSERT INTO `bootcamp`.`customer`\n" + 
                		"(`first_name`, `last_name`, `birth_date`, `username`, `password`, `phone_number`, `phone_type`)\n" + 
                		"VALUES\n" + 
                		"(?,?,?,?,?,?,?)");

		preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setDate(3, new java.sql.Date(customer.getBirthDate().getTime()));
        preparedStatement.setString(4, customer.getUsername());
        preparedStatement.setString(5, customer.getPassword());
        preparedStatement.setString(6, customer.getPhoneNumber());
        preparedStatement.setString(7, customer.getPhoneType());
        preparedStatement.executeUpdate();
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
	public List<Customer> getList() throws Exception{
		statement = getConnection().createStatement();
        resultSet = statement.executeQuery("select * from customer");
        
        List<Customer> list = new ArrayList<>();
        
        while (resultSet.next()) {
        		Customer customer = new Customer();
        		customer.setBirthDate(resultSet.getDate("birth_date"));
        		customer.setCustomerNumber(resultSet.getInt("customer_number"));
        		customer.setFirstName(resultSet.getString("first_name"));
        		customer.setLastName(resultSet.getString("last_name"));
        		customer.setUsername(resultSet.getString("username"));
        		customer.setPassword(resultSet.getString("password"));
        		customer.setPhoneNumber(resultSet.getString("phone_number"));
        		customer.setPhoneType(resultSet.getString("phone_type"));
        		
        		list.add(customer);
        }
        
        return list;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		if(connect == null || connect.isClosed()) {
			Class.forName("com.mysql.jdbc.Driver");
	        connect = DriverManager.getConnection("jdbc:mysql://localhost/bootcamp?user=root&password=admin123");
		}
		return connect;
	}
}
