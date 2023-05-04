package com.bth3.laptop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LaptopDAO {
	private String jdbcURL = "jdbc:mysql://localhost/jdbc_demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "NguyenAnhKiet@@123";

    private static final String SELECT_ALL_LAPTOPS = "SELECT * FROM Laptop";
    private static final String SELECT_LAPTOP_BY_ID = "SELECT * FROM Laptop WHERE id=?";
    private static final String INSERT_LAPTOP_SQL = "INSERT INTO laptop VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE_LAPTOP_SQL = "UPDATE Laptop SET name=?,manudate=?,brand=?,sold=? WHERE id=?";
    private static final String DELETE_LAPTOP_BY_ID = "DELETE FROM laptop WHERE id=?";
    private static final String SEARCH_LAPTOP = "SELECT * FROM Laptop WHERE name LIKE ? OR brand LIKE ?";
    

    public LaptopDAO() {}

    protected Connection getConnection() {
    	Connection connection = null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	return connection;
    }

    public List<Laptop> selectAllLaptops(){
    	List<Laptop> laptops = new ArrayList<>();
    	try {
    		Connection connection = getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LAPTOPS);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while(resultSet.next()) {
    			int id = resultSet.getInt("id");
    			String name = resultSet.getString("name");
    			Date manudate = resultSet.getDate("manudate");
    			String brand = resultSet.getString("brand");
    			int sold = resultSet.getInt("sold");
    			laptops.add(new Laptop(id, name, manudate, brand, sold == 0 ? false : true));
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	return laptops;
    }
    
    public Laptop selectLaptop(int id) {
    	Laptop laptop = new Laptop();
    	try {
    		Connection connection = getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAPTOP_BY_ID);
    		preparedStatement.setInt(1, id);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while(resultSet.next()) {
    			laptop.setId(resultSet.getInt("id"));
    			laptop.setBrand(resultSet.getString("brand"));
    			laptop.setDate(resultSet.getDate("manudate"));
    			laptop.setName(resultSet.getString("name"));
    			laptop.setSold(resultSet.getInt("sold") == 0 ? false : true);
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	return laptop;
    }
    public List<Laptop> searchLaptops(String keyword){
    	List<Laptop> laptops = new ArrayList<>();
    	try {
    		Connection connection = getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_LAPTOP);
    		preparedStatement.setString(1, keyword);
    		preparedStatement.setString(2, keyword);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while(resultSet.next()) {
    			int id = resultSet.getInt("id");
    			String name = resultSet.getString("name");
    			Date manudate = resultSet.getDate("manudate");
    			String brand = resultSet.getString("brand");
    			int sold = resultSet.getInt("sold");
    			laptops.add(new Laptop(id, name, manudate, brand, sold == 0 ? false : true));
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	return laptops;
    }

}
