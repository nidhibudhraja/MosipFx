package application;

import java.io.File;
import java.io.IOException;
import java.lang.ModuleLayer.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Screen2Controller {
	@FXML
	private Label imgLabel;
	
	
	private void receiveData(ActionEvent event) {
	  // Step 1
	  Node node = (Node) event.getSource();
	  Stage stage = (Stage) node.getScene().getWindow();
	  // Step 2
	  User u = (User) stage.getUserData();
	  // Step 3
	  String fname = u.getFname();
	  String lname = u.getLname();
	  int age=u.getAge();
	  System.out.println(fname +" "+lname+" "+age);
	}
	
	@FXML
	public void submitButtonOnAction(ActionEvent event) {
		receiveData(event);
	}
	
	@FXML
	public void uploadButtonOnAction(ActionEvent event) {
		FileChooser fChooser=new FileChooser();
		fChooser.setTitle("Select your ID image");
		File selectedFile=fChooser.showOpenDialog(null);
		if (selectedFile != null) {
			if(selectedFile.length()/Math.pow(1024,2)<=2)
				imgLabel.setText(selectedFile.getPath());
			else {
				imgLabel.setText("File size more than 2MB not allowed. Select smaller size file");
			}
		 }else {
			 imgLabel.setText("No file chosen.Select a file");
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
