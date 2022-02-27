import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;


public class PatientRecordSystem {

	String file_name="",record="";

	public void addMeasurementObservationType(String code, String name,
			String unit) {
		// TODO Auto-generated method stub
		file_name  = "PRS-MeasurementObservationTypes.txt";
		record =code+";"+name+";"+unit;
		saveData(file_name, record);

	}

	public void addCategoryObservationType(String code, String name,
			String[] categories) {
		file_name  = "PRS-CategoryObservationTypes.txt";

		String categoriesItems="";
		for (String element: categories) {
			
			categoriesItems+=element+",";

		}
		record =code+";"+name+";"+categoriesItems.substring(0, categoriesItems.length() - 1);
		saveData(file_name, record);

	}

	public void addPatient(String patientId, String name) {
		// TODO Auto-generated method stub
		file_name  = "PRS-Patients.txt";
		record =patientId+";"+name;
		saveData(file_name, record);

	}

	public void addMeasurementObservation(String patientId, String code, double value) {
		// TODO Auto-generated method stub
		file_name  = "PRS-MeasurementObservations.txt";
		record =patientId+";"+code+";"+value;
		saveData(file_name, record);

	}

	public void addCategoryObservation(String patientId, String code,
			String value) {
		// TODO Auto-generated method stub
		file_name  = "PRS-CategoryObservations.txt";
		record =patientId+";"+code+";"+value;
		saveData(file_name, record);

	}

	public void saveData(String fileName,String data) {



		String FilePath="F:/RecordedFiles/"+fileName;
		File file = new File(FilePath);

		if(!file.exists()) {
			try {
				file.createNewFile();
				file.setReadable(true);
				file.setWritable(true);
				file.setExecutable(true);

				try{    

					FileWriter fw=new FileWriter(FilePath,true);    
					BufferedWriter out = new BufferedWriter(fw);
					out.write(data+"\n");
					out.close();
					fw.close();    
				}catch(Exception e){e.printStackTrace();} 

			} catch (Exception e) {
				e.printStackTrace();
			}        
		}else {
			try{    
				FileWriter fw=new FileWriter(FilePath,true);    
				BufferedWriter out = new BufferedWriter(fw);
				out.write(data+"\n");
				out.close();
				fw.close();      
			}catch(Exception e){e.printStackTrace();} 

		}





	}

	public void loadData() {
		// TODO Auto-generated method stub
		String result="";
		String filename="PRS-MeasurementObservationTypes.txt";
		result=readFile(filename);
		saveData(filename, result);
		 filename="PRS-CategoryObservationTypes.txt";
		result=readFile(filename);
		saveData(filename, result);
		 filename="PRS-Patients.txt";
		result=readFile(filename);
		saveData(filename, result);
		 filename="PRS-MeasurementObservations.txt";
		result=readFile(filename);
		saveData(filename, result);
		 filename="PRS-CategoryObservations.txt";
		result=readFile(filename);
		saveData(filename, result);
		
	}

	
	public String readFile(String fileName) {
		String result="";
		try {
		      File myObj = new File("F:/RecordedFiles/"+fileName);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        result+="\n"+data;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		//System.out.println(fileName+">>result>>>"+result);
		return result;
	}

}
