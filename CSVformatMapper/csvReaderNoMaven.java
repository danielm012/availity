import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class csvReader {
	
	private static class Patient
	{
		private int Id;
		private String First;
		private String Last;
		private int Version;
		private String Insurance;
		
		private Patient()
		{
			// empty constructor to not allow empty classes
		}
		
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
		
		
	}
	
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
	
	public static LinkedList<Patient> createPatientList(Scanner patientsCSV, int sizeEachRecord)
	{
		int count = 0;
		LinkedList<Patient> patients = new LinkedList<>();
		String[] data = new String[sizeEachRecord];

		for(int i = 1; i < sizeEachRecord; i++)
		{
			patientsCSV.next();
		}
		
		while(patientsCSV.hasNext())
		{
			String[] currentPatient = patientsCSV.next().split(",");
			System.out.println(Arrays.toString(currentPatient));
			
			int id = currentPatient[0].equals("") ? (Integer.parseInt(currentPatient[0])) : 0;
			int version = currentPatient[0].equals("") ? (Integer.parseInt(currentPatient[0])) : 0;
			
			patients.add(new Patient(id,
					currentPatient[1],
					currentPatient[2],
					version,
					currentPatient[4]));
		}
		
		return patients;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Patient> patients = null;
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

		System.out.print(patients.peekLast().First);
	}

}
