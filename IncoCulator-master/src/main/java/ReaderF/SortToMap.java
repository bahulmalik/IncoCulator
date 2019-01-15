package ReaderF;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@Component("getAvgByList")
class GetAvgByList {
    Map<String, String> mapEachCountryGender = new TreeMap<>();

    Map<String,String> sortToMap(ArrayList<Personal> personalList) {

        personalList.forEach(personal -> {
            String key = personal.getCountry() + " - " + personal.getGender();

            if (mapEachCountryGender.containsKey(key)) {
                mapEachCountryGender.put(key, mapEachCountryGender.get(key) + "," + personal.getCurrencyType().getUSDConverted(personal.getAvgIncome()));

            } else {
                mapEachCountryGender.put(key, personal.getCurrencyType().getUSDConverted(personal.getAvgIncome()).toString());
            }
        });


return mapEachCountryGender;
    }
}