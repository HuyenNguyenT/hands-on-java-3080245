package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataSource {
  public static Connection connection(){
    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;
    try{
      connection = DriverManager.getConnection(db_file);
      System.out.println("we're connection");
    } catch(SQLException e){
      e.printStackTrace();
    }
    return connection;
  }

  /**
   * @param username
   * @return
   */
  public static Customer getCustomer(String username){
    String sql = "select * from customers where username =?";
    Customer customer = null;
    try(Connection connection = connection();
    PreparedStatement statement = connection.prepareStatement(sql)){
      statement.setString(1,username);
      try(ResultSet resultSet = statement.executeQuery()){
        customer = new Customer(
          resultSet.getInt("id"),
         resultSet.getString("name"),
         resultSet.getString("username"),
         resultSet.getString("password"),
         resultSet.getInt("account_id"));
      }

    } catch(SQLException e){
        e.printStackTrace();
    }
      return customer;
  }

  public static void main(String[] args){
   
    Customer customer = getCustomer("hnegal76@umn.edu");
    System.out.println(customer.getName());
  }
}

