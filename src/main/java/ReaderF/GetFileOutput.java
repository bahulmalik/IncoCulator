package ReaderF;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Component("getFileOutput")
 class GetFileOutput {
     Set<String> countrySet = new TreeSet<>();
     PrintWriter pw;

    static String getResourcePath() {
        try {
            URI resourcePathFile = System.class.getResource("/RESOURCE_PATH.properties").toURI();
            String resourcePath = Files.readAllLines(Paths.get(resourcePathFile)).get(0);
            URI rootURI = new File("").toURI();
            URI resourceURI = new File(resourcePath).toURI();
            URI relativeResourceURI = rootURI.relativize(resourceURI);
            return relativeResourceURI.getPath();
        } catch (Exception e) {
            return null;
        }
    }

     boolean getFileOutput(Map<String, String> mapStoreResult) {
        try {
            pw = new PrintWriter(new File(getResourcePath()+"/test2.csv"));

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

            pw.write(csvData.toString());
            pw.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }


}

