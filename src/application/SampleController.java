package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class SampleController {
	
	@FXML
	private Button loginButton;
	
	@FXML
	private Label loginMsg;
	
	@FXML 
	private TextField usernameTextField;
	
	@FXML
	private PasswordField passwordField;
	
	public void loginButtonOnAction(ActionEvent event) {
		if(usernameTextField.getText().isBlank()==false && passwordField.getText().isBlank()==false) {
			boolean valid=validateLogin();
			if(valid) {
				goToScreen1(event);
			}
		}else {
			loginMsg.setText("Please enter username and password");
		}
		   
	}
	public boolean validateLogin() {
		DBConnection connDB=new DBConnection();
		Connection conn=connDB.getConn();
		String queryString="Select count(1) from logintb where username='"+usernameTextField.getText()+"' AND password='"+passwordField.getText()+"'";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(queryString);
			
			while(rs.next()) {
				if(rs.getInt(1)==1) {
					loginMsg.setText("Login Successful :)");
					return true;
					
				}else {
					loginMsg.setText("Invalid Login! Please Try Again");
					return false;
				}
			}
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return false;
	}
	
	public void goToScreen1(ActionEvent event) {
		 // Step 2
		  Node node = (Node) event.getSource();
		  // Step 3
		  Stage stage = (Stage) node.getScene().getWindow();
		  stage.close();
		  try {
		    // Step 4
		    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/Screen1.fxml"));
		   
		    // Step 6
		    Scene scene = new Scene(root);
		    stage.setScene(scene);
		    // Step 7
		    stage.show();
		  } catch (IOException e) {
		    System.err.println(String.format("Error: %s", e.getMessage()));
		  }
	}
	
	
	
}
