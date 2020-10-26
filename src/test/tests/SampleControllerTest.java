package  tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.scene.control.Button;

import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;


import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



@ExtendWith(ApplicationExtension.class)

class SampleControllerTest  {
	
	@Start
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../application/Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	void loginTest(FxRobot robot) {
		
			Button btnlogin=robot.lookup("#loginButton").queryAs(Button.class);
			assertNotNull(btnlogin);
			robot.clickOn("#usernameTextField");
			robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
			robot.write("a");
			robot.clickOn("#passwordField");
			robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
			robot.write("1");
			robot.clickOn(btnlogin);
			assertEquals("Login", btnlogin.getText());	
			fillform(robot);
		
		
		
	}
	
	
	void fillform(FxRobot robot) {
	
				robot.clickOn("#fnameTextField");
				robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
				robot.write("alok");
				//robot.write(nextLine[0]);
				robot.clickOn("#lnameTextField");
				robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
				robot.write("sharma");
				//robot.write(nextLine[1]);
				Spinner<Integer>ageSpinner=robot.lookup("#ageSpinner").queryAs(Spinner.class);
				//ageSpinner.getValueFactory().increment(Integer.parseInt(nextLine[2])-1);
				ageSpinner.getValueFactory().increment(8);
				if(checkParentPane(robot)) {
					robot.clickOn("#pfnameTextField");
					robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
					robot.write("alka");
					
					//robot.write(nextLine[3]);
					robot.clickOn("#plnameTextField");
					robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
					robot.write("sharma");
					//robot.write(nextLine[4]);
					
				}
				Button btnNext=robot.lookup("#nextButton").queryAs(Button.class);
				assertNotNull(btnNext);
				robot.clickOn(btnNext);
				TextField idimgTextField=robot.lookup("#imgTextField").queryAs(TextField.class);
//				Platform.runLater(
//						  () -> {
//						    // Update UI here.
//							  idimgLabel.setText(nextLine[5]);
//						  }
//						);
				//idimgTextField.setText(nextLine[5]);
				idimgTextField.setText("/home/nidhi/Pictures/a.jpeg");
				Button btnSubmit=robot.lookup("#submitButton").queryAs(Button.class);
				assertNotNull(btnSubmit);
				robot.clickOn(btnSubmit);
//				Button btnPrev=robot.lookup("#prevButton").queryAs(Button.class);
//				assertNotNull(btnPrev);
//				robot.clickOn(btnPrev);
				//putImage(robot);
		
	}
	boolean checkParentPane(FxRobot robot) {
		Spinner<Integer>ageSpinner=robot.lookup("#ageSpinner").queryAs(Spinner.class);
		int age=ageSpinner.getValue();
		AnchorPane parentPane=robot.lookup("#parentDetailsPane").queryAs(AnchorPane.class);
		if(age<=5) {
			assertTrue(parentPane.visibleProperty().getValue()==true);
			return true;
		}else {
			assertFalse(parentPane.visibleProperty().getValue()==true);
			return false;
		}
		
	}
	void putImage(FxRobot robot) {
		Button btnUpload=robot.lookup("#uploadButton").queryAs(Button.class);
		robot.clickOn(btnUpload);
		
	}


}



//@ParameterizedTest(name = "{index} => nextLine[0]={0}, nextLine[1]={1}, nextLine[2]={2},nextLine[3]={3}, nextLine[4]={4}")
//@CsvFileSource(resources = "testdata/testcases.csv")