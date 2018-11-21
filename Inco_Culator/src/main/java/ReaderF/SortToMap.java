package ReaderF;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@Component("getAvgByList")
class GetAvgByList {
    Map<String, String> mapEachCountryGender = new TreeMap<>();

    void sortToMap(ArrayList<Personal> personalList, ApplicationContext context) {

        personalList.forEach(personal -> {
            String key = personal.country + " - " + personal.gender;

            if (mapEachCountryGender.containsKey(key)) {
                mapEachCountryGender.put(key, mapEachCountryGender.get(key) + "," + personal.currencyType.getUSDConverted(personal.avgIncome));

            } else {
                mapEachCountryGender.put(key, personal.currencyType.getUSDConverted(personal.avgIncome).toString());
            }
        });

        context.getBean(GetAvgIncomeForCountryGender.class).getAvgIncomeForCountryGender(mapEachCountryGender,context);

    }
}