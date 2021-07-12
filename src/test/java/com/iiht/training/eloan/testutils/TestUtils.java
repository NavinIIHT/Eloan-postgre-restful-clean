package com.iiht.training.eloan.testutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// boiler-plate code
public class TestUtils {
		
		public static File businessTestFile;
		public static File boundaryTestFile;
		public static File exceptionTestFile;
		public static File xmlFile;
		static {
			//removeLineFromFile("../output_revised.txt", "post");
			//removeLineFromFile("../output_boundary_revised.txt", "post");
			//removeLineFromFile("../output_exception_revised.txt", "post");
			xmlFile = new File("./E-Loan-Boot-Postgre.xml");
			xmlFile.delete();
			
			businessTestFile = new File("./output_revised.txt");
			businessTestFile.delete();
			
			boundaryTestFile = new File("./output_boundary_revised.txt");
			boundaryTestFile.delete();
			
			exceptionTestFile = new File("./output_exception_revised.txt");
			exceptionTestFile.delete();
		}
		
		
		public static void yakshaAssert(String testName, Object result, File file) throws IOException {
			
			System.out.println("\n" + testName + "=" + result);
			FileWriter writer = new FileWriter(file,true);
			writer.append("\n" + testName + "=" + result);
			writer.flush();
			writer.close();
			
			// createXML(testName, file);
			
		}
				
		public static void createXML(String testName, File file) throws IOException {
			FileWriter writer = new FileWriter(xmlFile,true);
			if(file.getName().contains("output_revised")){
				
				writer.append("\r\n<cases xmlns:java=\"http://java.sun.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"java:com.assessment.data.TestCase\">\r\n" + 
						"		<test-case-type>Functional</test-case-type>\r\n" + 
						"		<expected-ouput>true</expected-ouput>\r\n" + 
						"		<name>" + testName + "</name>\r\n" + 
						"		<weight>8</weight>\r\n" + 
						"		<mandatory>true</mandatory>\r\n" + 
						"		<desc>" + testName + "</desc>\r\n" + 
						"	</cases>");
				writer.flush();
				writer.close();
			}
			if(file.getName().contains("boundary")){
				
				writer.append("\r\n<cases xmlns:java=\"http://java.sun.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"java:com.assessment.data.TestCase\">\r\n" + 
						"		<test-case-type>Boundary</test-case-type>\r\n" + 
						"		<expected-ouput>true</expected-ouput>\r\n" + 
						"		<name>" + testName + "</name>\r\n" + 
						"		<weight>3</weight>\r\n" + 
						"		<mandatory>true</mandatory>\r\n" + 
						"		<desc>" + testName + "</desc>\r\n" + 
						"	</cases>");
				writer.flush();
				writer.close();
			}
			if(file.getName().contains("exception")){
				
				writer.append("\r\n<cases xmlns:java=\"http://java.sun.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"java:com.assessment.data.TestCase\">\r\n" + 
						"		<test-case-type>Exception</test-case-type>\r\n" + 
						"		<expected-ouput>true</expected-ouput>\r\n" + 
						"		<name>" + testName + "</name>\r\n" + 
						"		<weight>5</weight>\r\n" + 
						"		<mandatory>true</mandatory>\r\n" + 
						"		<desc>" + testName + "</desc>\r\n" + 
						"	</cases>");
				writer.flush();
				writer.close();
			}
		}
		
		public static String currentTest() {
			return Thread.currentThread().getStackTrace()[2].getMethodName();
		}
		
		public static void removeLineFromFile(String file, String lineToRemove) {

		    try {

		      File inFile = new File(file);

		      if (!inFile.isFile()) {
		        System.out.println("Parameter is not an existing file");
		        return;
		      }

		      //Construct the new file that will later be renamed to the original filename.
		      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

		      BufferedReader br = new BufferedReader(new FileReader(file));
		      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		      String line = null;

		      //Read from the original file and write to the new
		      //unless content matches data to be removed.
		      while ((line = br.readLine()) != null) {
		    	
		        if (!line.trim().startsWith(lineToRemove)) {

		          pw.println(line);
		          pw.flush();
		        }
		    	
		      }
		      pw.close();
		      br.close();

		      //Delete the original file
		      if (!inFile.delete()) {
		        System.out.println("Could not delete file");
		        return;
		      }

		      //Rename the new file to the filename the original file had.
		      if (!tempFile.renameTo(inFile))
		        System.out.println("Could not rename file");

		    }
		    catch (FileNotFoundException ex) {
		      ex.printStackTrace();
		    }
		    catch (IOException ex) {
		      ex.printStackTrace();
		    }
		  }


		
}
