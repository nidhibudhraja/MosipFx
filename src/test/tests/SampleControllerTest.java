package  tests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import javafx.scene.control.Button;

import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;


import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;

import com.opencsv.CSVReader;

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
	//@ParameterizedTest(name = "{index} => nextLine[0]={0}, nextLine[1]={1}, nextLine[2]={2},nextLine[3]={3}, nextLine[4]={4}")
	//@CsvFileSource(resources = "/testcases.csv")
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
			//fillform(robot,nextLine);
			fillform(robot);
		
		
	}
	
	
//	void fillform(FxRobot robot,String nextLine[]) {
	void fillform(FxRobot robot) {
				CSVReader csvReader;
		        String[] nextLine; 
		        String[] header;
		        
		        
		        //System.out.println(new File(".").getCanonicalPath());
		        // we are going to read data line by line 
		        try {
		        	csvReader = new CSVReader(new FileReader(new File("").getAbsolutePath()+"/src/test/tests/testcases.csv"));
		        	header=csvReader.readNext();
		        	String headerId[]=new String[header.length];
		        	
		        	for(int i=0;i<header.length;i++) {
		        		headerId[i]=getId(header[i]);
		        	}
					while ((nextLine = csvReader.readNext()) != null && !nextLine[2].equals("")) { 
//					if(nextLine[2].equals("") ){
//						//System.out.println("breaking");
//						break;
//					}
					//System.out.println(nextLine[0]+"1="+nextLine[1]+"2="+nextLine[2]);
					robot.clickOn(headerId[0]);
					robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
					//robot.write("alisha");
					robot.write(nextLine[0]);
					robot.clickOn(headerId[1]);
					robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
					//robot.write("shourya");
					robot.write(nextLine[1]);
					Spinner<Integer>ageSpinner=robot.lookup(headerId[2]).queryAs(Spinner.class);
					ageSpinner.getValueFactory().setValue(1);
					ageSpinner.getValueFactory().increment(Integer.parseInt(nextLine[2])-1);
					//ageSpinner.getValueFactory().increment(2);
					if(nextLine[10].equals("TRUE"))
						robot.clickOn(headerId[10]);
					else
						robot.clickOn(headerId[11]);
					if(checkParentPane(robot,headerId)) {
						//System.out.println("4"+headerId[4]);
						robot.clickOn(headerId[4]);
						robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
						//robot.write("alka");						
						robot.write(nextLine[4]);
						robot.clickOn(headerId[5]);
						robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
						//robot.write("sharma");
						robot.write(nextLine[5]);
						
					}
					Button btnNext=robot.lookup(headerId[6]).queryAs(Button.class);
					assertNotNull(btnNext);
					robot.clickOn(btnNext);
					TextField idimgTextField=robot.lookup(headerId[7]).queryAs(TextField.class);
//				Platform.runLater(
//						  () -> {
//						    // Update UI here.
//							  idimgLabel.setText(nextLine[5]);
//						  }
//						);
					idimgTextField.setText(nextLine[7]);
					//idimgTextField.setText("/home/nidhi/Pictures/a.jpeg");
					Button btnSubmit=robot.lookup(headerId[8]).queryAs(Button.class);
					assertNotNull(btnSubmit);
					robot.clickOn(btnSubmit);
					Button btnPrev=robot.lookup(headerId[9]).queryAs(Button.class);
					assertNotNull(btnPrev);
					robot.clickOn(btnPrev);
					//putImage(robot);
					}
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	boolean checkParentPane(FxRobot robot,String headerId[]) {
		Spinner<Integer>ageSpinner=robot.lookup(headerId[2]).queryAs(Spinner.class);
		int age=ageSpinner.getValue();
		AnchorPane parentPane=robot.lookup(headerId[3]).queryAs(AnchorPane.class);
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
	String getId(String header) {
		String s[]=header.split("#",-2);
		System.out.println("#"+s[1]);
		return "#"+s[1];
	}


}



