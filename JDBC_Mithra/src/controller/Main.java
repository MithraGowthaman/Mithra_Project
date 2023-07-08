package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import dao.LoginDAO;
import dao.productDAO;
import model.Login;
import model.Product;
public class Main {
//buffer reader input only string
public static void main(String args[]) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
{
BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
int choice,option;

Login login = new Login();
LoginDAO logindao = new LoginDAO();
Product product = new Product();
productDAO productdao = new productDAO();
do {
System.out.println("1.Admin");
System.out.println("2.Agent");
System.out.println("3.Exit");
choice = Integer.parseInt(br.readLine());
switch(choice){
case 1: System.out.println("_____________");
System.out.println("Enter the username");
String username = br.readLine();
System.out.println("Enter the password");
String password = br.readLine();
login.setUsername(username);
login.setPassword(password);
if(logindao.validate(login)) {
System.out.println("________________");
System.out.println("Login Successfull");

do {
System.out.println("_______________");
System.out.println("1.Add Products");
System.out.println("2.View Inventory Details");
System.out.println("3.Logout");
System.out.println("______________");
option = Integer.parseInt(br.readLine());
switch(option) {
case 1:System.out.println("Enter the product id: ");
int productId = Integer.parseInt(br.readLine());
System.out.println("Enter the product name");
String productname = br.readLine();
System.out.println("Enter the min sell quantity: ");
int minsell = Integer.parseInt(br.readLine());
System.out.println("Enter the product price");
int price = Integer.parseInt(br.readLine());
System.out.println("Enter the product quantity");
int quantity = Integer.parseInt(br.readLine());
product.setProductName(productname);
product.setProductId(productId);
product.setMinSellQuantity(minsell);
product.setPrice(price);
product.setQuantity(quantity);

productdao.addProduct(product);
break;

case 2: productdao.display();
break;
}
}while(option!=3);
}
else {
System.out.println("check your username and passowrd");
}
break;
case 2: System.out.println("______________________");
System.out.println("Enter the username: ");
String name = br.readLine();
System.out.println("Enter the password:");
String pass = br.readLine();
login.setUsername(name);
login.setPassword(pass);
if(logindao.validate(login)) {
System.out.println("___________________");
System.out.println("Login successfull");
do {
System.out.println("_________________");
System.out.println("1.Show Inventory");
System.out.println("2.Logout");
System.out.println("__________________");
option = Integer.parseInt(br.readLine());
switch(option) {
case 1: productdao.display();
break;

case 2: break;
}

}while(option!=2);
}
}
}while(choice != 3);
}

}