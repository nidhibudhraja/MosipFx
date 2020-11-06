package application;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Screen1Controller implements Initializable {
	@FXML
	private AnchorPane screen1;
	
	@FXML 
	private TextField fnameTextField;
	
	@FXML
	private TextField lnameTextField;
	
	@FXML
	private AnchorPane parentDetailsPane;
	
	@FXML
	private TextField pfnameTextField;
	
	@FXML
	private TextField plnameTextField;
	
	@FXML
	private Button nextButton;
	
	
	@FXML
	private Spinner <Integer>ageSpinner;
	SpinnerValueFactory<Integer> svf=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1);
	
	@FXML
	private RadioButton ageBelow5;
	
	@FXML
	private RadioButton ageAbove5;
	
	@Override
	public void initialize(URL url,ResourceBundle rb) {
		
		parentDetailsPane.setVisible(false);
		ageSpinner.setValueFactory(svf);
		// When spinner change value.
        ageSpinner.valueProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
				// TODO Auto-generated method stub
				
				if(arg2<=5) {
					//ageBelow5.setSelected(true);
					//ageAbove5.setSelected(false);
				
					if(parentDetailsPane==null)
						System.out.println("null");
					parentDetailsPane.setVisible(true);
					
				}else {
					//ageBelow5.setSelected(false);
					//ageAbove5.setSelected(true);
					parentDetailsPane.setVisible(false);
					
				}
				
			}
		
        }); 
        
	}
	public void reloadFormData(User user) {	
			
			if(user!=null) {
				fnameTextField.setText(user.getFname());
				lnameTextField.setText(user.getLname());
				ageSpinner.getValueFactory().setValue(user.getAge());
				if(user.getAge()<=5) {
					pfnameTextField.setText(user.getPfname());
					plnameTextField.setText(user.getPlname());
				}
			}
		
		
	}
	
	
	@FXML
	private void nextButtonOnAction(ActionEvent event) {
	  User u = new User();
	  u.setFname(fnameTextField.getText());
	  u.setLname(lnameTextField.getText());
	  u.setAge(ageSpinner.getValue());
	  if(u.getAge()<=5) {
		  u.setPfname(pfnameTextField.getText());
		  u.setPlname(plnameTextField.getText());
	  }
	  // Step 2
	  Node node = (Node) event.getSource();
	  // Step 3
	  Stage stage = (Stage) node.getScene().getWindow();
	  stage.close();
	  try {
	    // Step 4
	    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/Screen2.fxml"));
	    // Step 5
	    stage.setUserData(u);
	    // Step 6
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    // Step 7
	    stage.show();
	  } catch (IOException e) {
	    System.err.println(String.format("Error: %s", e.getMessage()));
	  }
	}
	@FXML
	private void ageGroupOnAction(ActionEvent event) {
		int age=ageSpinner.getValue();
		if(age<=5) {
			ageBelow5.setSelected(true);
			ageAbove5.setSelected(false);
		}else {
			ageBelow5.setSelected(false);
			ageAbove5.setSelected(true);
		}
	}
	

}
