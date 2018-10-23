package ReaderF;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class GetFileOutput {
    static Set<String> countrySet = new TreeSet<>();
    static PrintWriter pw;

    static void getFileOutput(Map<String, String> mapStoreResult) {
        try {
            pw = new PrintWriter(new File("C:\\Users\\bahul.malik\\Downloads\\project\\test.csv"));

            StringBuffer csvHeader = new StringBuffer("");
            StringBuffer csvData = new StringBuffer("");
            csvHeader.append("Country/City ,Gender,AverageIncome(USD)\n");

            pw.write(csvHeader.toString());
            mapStoreResult.forEach((s, s2) -> {
                String splitKey[] = s.split("-");
                csvData.append(splitKey[0]);
                csvData.append(",");
                csvData.append(splitKey[1]);
                csvData.append(",");
                csvData.append(s2);
                csvData.append('\n');
            });

            System.out.println("Finished Excecution");


            pw.write(csvData.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}

