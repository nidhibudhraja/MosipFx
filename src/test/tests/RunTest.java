//package tests;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Collection;
//import java.util.List;
//
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.testfx.framework.junit5.ApplicationExtension;
//
//
//import com.opencsv.CSVReader;
//
//
//
//@ExtendWith(ApplicationExtension.class)
//@RunWith(Parameterized.class)
//public class RunTest {
//	private String fname;
//	private String lname;
//	private String pfname;
//	private String plname;
//	private int age;
//	private SampleControllerTest sampleControllerTest;
//	
//	public RunTest(String a, String b, String c, String d, int ag) {
//		super();
//		fname=a;
//		lname=b;
//		pfname=c;
//		plname=d;
//		age=ag;
//		
//	}
//	
//	public static Collection input() {
//		Collection csvBody=null;
//		try {
//			CSVReader reader = new CSVReader(new FileReader("testdata/testcases.csv"));
//			 csvBody = reader.readAll();
//			 
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return csvBody;
//	}
//	
//	@Before
//	public void initialize() {
//		sampleControllerTest= new SampleControllerTest();
//	}
//	
////	@Test
////	void runtests() {
////		SampleControllerTest sampleControllerTest;
////		CSVReader reader;
////
////		try {
////			reader = new CSVReader(new FileReader("testdata/testcases.csv"));
////			String [] nextLine; 
////			while ((nextLine = reader.readNext()) != null) {
////				sampleControllerTest=new SampleControllerTest();
////				sampleControllerTest.loginTest(robot, nextLine);
////				
////			}
////		} catch (NumberFormatException | IOException  e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
//	
//}
