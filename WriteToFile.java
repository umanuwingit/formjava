import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile{
    public void writeToFile(String[] detail, double selt, int[] rating, double responseRate) {
        
        String csvFile = "data_into_sql.csv";
        String text = toCsv(detail, selt, rating, responseRate);
        try {
            File file = new File(csvFile);
            if (!file.exists() == true) {
            	FileWriter writer = new FileWriter(csvFile);
            	writer.append(text);           
//            	System.out.println("new file");
                writer.flush();
                writer.close();
            } else {
                BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true));
                writer.newLine();
                writer.write(text);
//            	System.out.println("appending");
                writer.flush();
                writer.close();
            }
            	


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String toCsv(String[] detail, double selt, int[] rating, double responseRate) {
    	String out="";
    	out = ("NULL" + "," + detail[0] + "," + detail[1] + "," + detail[3] + "," + detail[2] + "," + detail[4] + "," + responseRate + "," + selt + "," + rating[0] + "," + rating[1] + "," + rating[2] + "," + rating[3] + "," + rating[4]);
    	return out;
    	
    }
}
