package bank;

import java.net.Authenticator;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

public class Menu {
  private Scanner scanner;

  public static void main(String[] args) {
    System.out.println("Welcome to Globe Bank International");
    Menu menu = new Menu();
    menu.scanner = new Scanner(System.in);




    menu.scanner.close();
    
  }
  private Customer authenCustomer(){
    System.out.println("Please enter your username");
    String username = scanner.next();

    System.out.println("Please enter your password");
    String password = scanner.next();

    Customer customer = null;
    try{
      customer = Authentication.login(username,password);

    } catch (LoginException e){
      System.out.println("There is an error: " + e.getMessage());
    }
}
}
