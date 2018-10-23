package ReaderF;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import static ReaderF.GetAvgIncomeForCountryGender.getAvgIncomeForCountryGender;


class GetAvgByList {
    static Map<String, String> mapEachCountryGender = new TreeMap<>();

    static void sortToMap(ArrayList<Personal> personalList) {

        personalList.forEach(personal -> {
            String key = personal.country + " - " + personal.gender;

            if (mapEachCountryGender.containsKey(key)) {
                mapEachCountryGender.put(key, mapEachCountryGender.get(key) + "," + personal.currencyType.getUSDConverted(personal.avgIncome));

            } else {
                mapEachCountryGender.put(key, personal.currencyType.getUSDConverted(personal.avgIncome).toString());
            }
        });

        getAvgIncomeForCountryGender(mapEachCountryGender);

    }
}