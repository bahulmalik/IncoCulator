package ReaderF;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

@Component("readFiler")
public class ReadFiler {
    public void readFile(String fileName, ApplicationContext context) {


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

            context.getBean(GetAvgByList.class).sortToMap(personalList,context);


        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }


    }


}






