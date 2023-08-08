import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataMatching {
    public Map<String, List<String>> matching (String path) {
        String csvFile = path;
        String line = "";
        String csvSplitBy = ",";
        Map<String, List<String>> dataMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // skip header row
            br.readLine();
            br.readLine();
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] row = line.split(csvSplitBy);

                // extract relevant data
                String profId = row[27];
                String dept = row[25];
                String block = row[29];
                String year = row[23];
                String type = row[28];


                // create key for dataMap
                String key = profId + "_" + block + "_" + year + "_" + type + "_" + dept;

                // add row to dataMap
                if (!dataMap.containsKey(key)) {
                    dataMap.put(key, new ArrayList<>());
                }
                dataMap.get(key).add(line);
            }
/*
            // group data by key and print to console
            for (Map.Entry<String, List<String>> entry : dataMap.entrySet()) {
                String key = entry.getKey();
                List<String> dataList = entry.getValue();

                System.out.println("Key: " + key);
                System.out.println("Data:");
                for (String row : dataList) {
                    System.out.println(row);
                }
                System.out.println();
            }
*/
        } catch (IOException e) {
            e.printStackTrace();
        }
		return dataMap;
    }
}
