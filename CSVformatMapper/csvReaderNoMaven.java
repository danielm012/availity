import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class csvReaderNoMaven {
	
	private static class Patient
	{
		private int Id;
		private String First;
		private String Last;
		private int Version;
		private String Insurance;
		
		public Patient(int id, String first, String last, int version, String insurance)
		{
			Id = id;
			First = first;
			Last = last;
			Version = version;
			Insurance = insurance;
		}
		
		public int getId() {
			return Id;
		}

		public String getFirst() {
			return First;
		}

		public String getLast() {
			return Last;
		}


		public int getVersion() {
			return Version;
		}


		public String getInsurance() {
			return Insurance;
		}
		
		
		public static class SortByName implements Comparator<Patient>
		{
			@Override
			public int compare(csvReaderNoMaven.Patient o1, csvReaderNoMaven.Patient o2) {
				// TODO Auto-generated method stub
				int comparison = o1.First.compareTo(o2.First);
				if(comparison != 0)
					return comparison;
				else
					return o1.Last.compareTo(o2.Last);
			}
			
		}
		
	}

	/* Code which should handle most static function from below
	 * class to keep patient list organized and functioning properly.
	private class store
	{
		LinkedList<Patient> patients = new LinkedList<>();
		
		public store() {}

		public store(LinkedList<Patient> patient)
		{
			patients = patient;
		}
		
		public void addPatient(Patient patient)
		{
			patients.add(patient);
		}
		
		
		public int size()
		{
			return patients.size();
		}
	}
	*/
	public static LinkedList<Patient> createPatientList(Scanner patientsCSV, int sizeEachRecord)
	{
		LinkedList<Patient> patients = new LinkedList<>();

		patientsCSV.next();
			
		while(patientsCSV.hasNext())
		{
			String[] currentPatient = patientsCSV.next().split(",");
			System.out.println(Arrays.toString(currentPatient));
			
			int id = !currentPatient[0].equals("") ? (Integer.parseInt(currentPatient[0])) : 0;
			int version = !currentPatient[3].equals("") ? (Integer.parseInt(currentPatient[3])) : 0;
			
			
			patients.add(new Patient(id,
					currentPatient[1],
					currentPatient[2],
					version,
					currentPatient[4].replaceAll("\r", "")));
		}
		
		return patients;
	}
	
	public static Map<String, LinkedList<Patient>> createListByInsurance(LinkedList<Patient> patients)
	{
		Map<String, LinkedList<Patient>> insuranceList = new HashMap<>();
		for(Patient currentPatient : patients)
		{
			String insurance = currentPatient.getInsurance().replaceAll("\r", "");
			if(insurance.equals(""))
				insurance = "blank";
			if(!insuranceList.containsKey(insurance))
			{
				insuranceList.put(insurance, new LinkedList<>());
			}
			insuranceList.get(insurance).add(currentPatient);
		}
		
		return insuranceList;
	}
	
	public static void createCsvFiles(Map<String, LinkedList<Patient>> patientsMap) throws IOException
	{
		for(String key : patientsMap.keySet())
		{		
			// opens or create the file in the hard drive....
			File file = null;
			try
			{
				file = new File(key + ".csv");
				if (file.createNewFile()) 
				{
			        System.out.println("File created: " + file.getName());
			    } 
				else 
				{
			        file.delete();
			        file.createNewFile();
				}
			}
			catch(Exception err)
			{
				System.err.println(err);
			}
			
			Collections.sort(patientsMap.get(key), new Patient.SortByName());
			
			// write the information to a CSV file
			Patient previous = null;
			
			FileWriter writer = new FileWriter(file);
			writer.write("Id,First,Last,Version,Insurance\n");
			for(Patient patient : patientsMap.get(key))
			{
				
			    if(previous == null || patient.First.equals(previous.First) && 
						patient.Last.equals(previous.Last) &&
								patient.Version > previous.Version)
				{
					previous = patient;
				}
				else if( !patient.First.equals(previous.First) ||
						!patient.Last.equals(previous.Last))
				{
					writer.write(previous.Id + "," + previous.First + "," + previous.Last + "," + previous.Version + "," + previous.Insurance + "\n");
					previous = patient;
				}
			}
			// guaranteed to write the last record on the file.
			writer.write(previous.Id + "," + previous.First + "," + previous.Last + "," + previous.Version + "," + previous.Insurance + "\n");
			
			writer.close();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Patient> patients = null;
		Map<String, LinkedList<Patient>> insuranceList = null;
		File file = new File("C:\\Users\\danie\\OneDrive\\Documents\\interview\\Availity\\CSVformatMapper\\enrollmentTest.csv");
		Scanner scanner = null;
		
		try
		{
			scanner = new Scanner(file);
			scanner.useDelimiter("\n");
		}
		catch(Exception err)
		{
			System.out.println(err);
		}
		
		patients = createPatientList(scanner, 5);
		insuranceList = createListByInsurance(patients);
		
		// will try to create the files locally
		try 
		{
			createCsvFiles(insuranceList);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
