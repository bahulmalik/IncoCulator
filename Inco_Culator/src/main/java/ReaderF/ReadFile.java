package ReaderF;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import static ReaderF.GetAvgByList.sortToMap;

public class ReadFile {
    static final String ind="IND";
    static final String  sin="Singapore";
    static final String  sl="SL";
    static final String  uk="UK";

    public static void main(String[] args) {
        final String fileName = "C:\\Users\\bahul.malik\\Downloads\\project\\Sample_Input1.csv";

        ArrayList<Personal> personalList = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {


            stream
                    .map(i -> i.trim())
                    .filter(i -> !i.isEmpty())
                    .skip(1)
                    .forEach(s -> {
                        String split[] = s.split(",");
                        String country = split[0];
                        String city = split[1];
                        char gender = split[2].charAt(0);
                        CurrencyType currencyType = CurrencyType.valueOf(split[3]);
                        Double avgIncome = Double.parseDouble(split[4]);

                        personalList.add(new Personal(country, city, gender, currencyType, avgIncome));
                    });

            sortToMap(personalList);


        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }


    }


}






