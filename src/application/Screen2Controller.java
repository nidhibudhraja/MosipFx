package application;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Screen2Controller {
	@FXML
	private TextField imgTextField;
	
	@FXML
	private Label uploadStatus;
	
	@FXML
	private ImageView ImgID;
	
	
	@FXML
	public void submitButtonOnAction(ActionEvent event) throws Exception {
		if(imgTextField.getText()=="") {
			uploadStatus.setText("Please upload ID Image");
			return;
		}
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		// Step 2
		User u = (User) stage.getUserData();
		
		insertData(u);
		
	}
	public void insertData(User u)throws Exception {
		
		// Step 3
		String fname = u.getFname();
		String lname = u.getLname();
		int age=u.getAge();
		String pfname="";
		String plname="";
		if(age<=5) {
				pfname=u.getPfname();
				plname=u.getPlname();
		}
		System.out.println(fname +" "+lname+" "+age);
		InputStream in=new FileInputStream(imgTextField.getText());
		DBConnection connDB=new DBConnection();
		Connection conn=connDB.getConn();
		
		//String queryString="INSERT INTO Users (fname,lname,age,pfname,plname,img) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt=conn.prepareStatement("INSERT INTO Users (fname, lname, age, pfname,plname,img) VALUES (?, ?, ?,?,?,?)");
			stmt.setString(1,fname);
			stmt.setString(2, lname);
			stmt.setInt(3, age);
			stmt.setString(4, pfname);
			stmt.setString(5, plname);
			stmt.setBlob(6,in );
		
			boolean success=stmt.execute();

			uploadStatus.setText("Record Saved Successfully");
			

			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
	}
	
	@FXML
	public void uploadButtonOnAction(ActionEvent event) {
		FileChooser fChooser=new FileChooser();
		fChooser.setTitle("Select your ID image");
		File selectedFile=fChooser.showOpenDialog(null);
		if (selectedFile != null) {
			if(selectedFile.length()/Math.pow(1024,2)<=2)
				imgTextField.setText(selectedFile.getPath());
			else {
				imgTextField.setText("");
				uploadStatus.setText("File size more than 2MB not allowed. Select smaller size file");
			}
		 }else {
			 imgTextField.setText("");
			 uploadStatus.setText("No file chosen.Select a file");
		 }
		
	}
	
	@FXML
	public void prevButtonOnAction(ActionEvent event) {
		
		 // Step 2
		  Node node = (Node) event.getSource();
		  // Step 3
		  Stage stage = (Stage) node.getScene().getWindow();
		  User user=(User) stage.getUserData();
		  stage.close();
		  try {
			 // Step 4
			 FXMLLoader loader=new FXMLLoader(getClass().getResource("/application/Screen1.fxml"));
			 
			 Parent root = (Parent)loader.load();
			 Screen1Controller screen1Controller=loader.getController();
			 screen1Controller.reloadFormData(user);
		    
			 // Step 5
		    stage.setUserData(user);
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
