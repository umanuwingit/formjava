import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvToData {
	
	

    public int[] csvToResponseCount(List<String> value) {	       
        String csvSplitBy = ",";       
        int[] rating = {0,0,0,0,0};
        
          for (int i=0;i<value.size();i++) {
                String[] data = value.get(i).split(csvSplitBy);
               
                // get rating values
                String ratingA = data[18];
                String ratingB = data[19];
//                System.out.println(ratingA + " " + ratingB);
                // count ratings
                if (ratingA.equals("Strong Agree") || ratingB.equals("Strong Agree")) {
                    rating[0]++;
                } else if (ratingA.equals("Agree") || ratingB.equals("Agree")) {
                	rating[1]++;
                } else if (ratingA.equals("Neutral") || ratingB.equals("Neutral")) {
                	rating[2]++;
                } else if (ratingA.equals("Disagree") || ratingB.equals("Disagree")) {
                	rating[3]++;
                } else if (ratingA.equals("Strong Disagree") || ratingB.equals("Strong Disagree")) {
                	rating[4]++;
                } 
            
        }       
		return rating;
    }
    public String[] csvToDetail(List<String> value) {	
        String csvSplitBy = ",";       
        String[] detail = new String[5];
        


            for (int i=0;i<value.size();i++) {
                String[] data = value.get(i).split(csvSplitBy);
               
                // get detail values
                detail[0] = data[27]; //ProfID
                detail[1] = data[25]; //ProfDept
                detail[2] = data[29]; //Block
                detail[3] = data[23]; //Year
                detail[4] = data[28]; //Type
                
//                System.out.println(detail[0] + " " +detail[1] + " " +detail[2] + " " +detail[3] + " " +detail[4] + " " );
            }
         return detail;
        }      
		
    // for count records, loading CSV version
    public static int countRecords(String path, int offset) { 
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        	String line = "";
            while ((line = br.readLine()) != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count-offset; // to avoid counting header
    }
    // overload for counting without loading CSV
    public static int countRecords(List<String> value) { 
        int count = value.size();
        return count; 
    }
   
}

