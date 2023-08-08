
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public String[][] data (String path) {
        String csvFile = path;
        String line = "";
        String csvSplitBy = ",";

        List<String[]> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(csvSplitBy);
                rows.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[][] array = new String[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            array[i] = rows.get(i);
        }
        
        return array;
        // Now you have an array of rows from your CSV file
    }
}