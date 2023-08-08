import java.util.List;
import java.util.Map;

public class Main {
	final static String  csvFileResponse = "Response_data_v2.csv";
	final static String  csvFileStudent = "Student_dummy_data.csv";
	
	public static void main (String[] args) {
		DataMatching dm = new DataMatching();
		
		Map<String, List<String>> dataMap = dm.matching(csvFileResponse);
		for (Map.Entry<String, List<String>> entry : dataMap.entrySet()) {
		    List<String> value = entry.getValue();
			recordGenerate(value);
		}

		System.out.println("Successfully generated selt score(s)");
		

	}
	
	public static void recordGenerate (List<String> value) {
		CsvToData src = new CsvToData();
		Calculation cal = new Calculation();
		WriteToFile wf = new WriteToFile();
		
		int [] rating = src.csvToResponseCount(value);
		double selt = cal.seltScore(rating);
		String[] detail = src.csvToDetail(value);
		int studentCount = src.countRecords(csvFileStudent,1); // 1 is header row length
		int responseCount = src.countRecords(value); // 3 is header row length
		double responseRate = cal.responseRate(studentCount, responseCount);
//		System.out.println(detail[0] + " " +detail[1] + " " +detail[2] + " " +detail[3] + " " +detail[4] + " " +selt + " " + rating[0] + " " +rating[1] + " " +rating[2] + " " +rating[3] + " " +rating[4] + " " + studentCount + " " + responseCount + " "+responseRate);
		wf.writeToFile(detail, selt, rating,responseRate);		
		
	}

}