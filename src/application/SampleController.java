package application;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
			validateLogin();
		}else {
			loginMsg.setText("Please enter username and password");
		}
		   
	}
	public void validateLogin() {
		DBConnection connDB=new DBConnection();
		Connection conn=connDB.getConn();
		String queryString="Select count(1) from logintb where username='"+usernameTextField.getText()+"' AND password='"+passwordField.getText()+"'";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(queryString);
			while(rs.next()) {
				if(rs.getInt(1)==1) {
					loginMsg.setText("Login Successful :)");
				}else {
					loginMsg.setText("Invalid Login! Please Try Again");
				}
			}
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
	}
	
}
