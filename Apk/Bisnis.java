package Apk;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import Apk.ConnectionDb;

import Apk.Data;
import Apk.ConnectionDb;

public class Bisnis {
	
	String relation="";
	Data data = new Data();
	ConnectionDb koneksi = new ConnectionDb();
	Connection connection = (Connection) koneksi.getConnection();
	
	
	public String insertData(Data a) {
		PreparedStatement ps=null;	
		try {
			String query = "insert into nasabah (norek,nama,alamat) values (?, ?, ?)";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, a.getNorek());
			ps.setString(2, a.getNama());
			ps.setString(3, a.getAlamat());
			ps.executeUpdate();
			relation = "Success";
		}catch(Exception e) {
			relation = "Failed!";
		}
		
		return relation;
	}
	
	public List<Data> view(){
PreparedStatement ps=null;
		
		List<Data> list = new ArrayList<>();
		
		try {
			String query = "select * from nasabah";
			ps = (PreparedStatement) connection.prepareStatement(query);					
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Data data = new Data();
				data.setNorek(rs.getString("norek"));
				data.setNama(rs.getString("nama"));
				data.setAlamat(rs.getString("alamat"));
				list.add(data);
			}
		}catch(Exception e) {
		}
		return list;
	}
	
	public String updateData(Data a) {
		ConnectionDb koneksi = new ConnectionDb();
		Connection connection = (Connection) koneksi.getConnection();
		
		PreparedStatement ps=null;	
		try {
			String query = "update nasabah set nama=?, alamat=? where norek=?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, a.getNama());
			ps.setString(2, a.getAlamat());
			ps.setString(3, a.getNorek()); 
			
			System.out.println(ps);
			ps.executeUpdate();
			relation ="Data was Update";
		}catch(Exception e) {
			relation = "Update was Failed!";
		}
		
		return relation;
	}
	
	public String deleteData(Data a) {
		PreparedStatement ps=null;
		try {		
			String query = "delete from nasabah where norek = ?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, a.getNorek());
			
			System.out.println(ps);
			ps.executeUpdate();
			relation = "Data was deleted";
		}catch(Exception e) {
			relation = "Delete was failed!";
		}
		return relation;
	}
	}


