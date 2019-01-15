package ReaderF;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

@Component("readFiler")
class ReadFiler {
    ArrayList<Personal> readFile(String fileName) {


        ArrayList<Personal> personalList = new ArrayList<>();

        try {

            Stream<String> stream = new BufferedReader(new InputStreamReader(ClassLoader
                                                                                .getSystemResourceAsStream(fileName)))
                                                                                    .lines();
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

                        personalList.add(new Personal.PersonalBuilder()
                                .country(country)
                                .city(city)
                                .gender(gender)
                                .avgIncome(avgIncome)
                                .currencyType(currencyType)
                                .build());
                    });

            return personalList;


        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        return personalList;
    }


}






