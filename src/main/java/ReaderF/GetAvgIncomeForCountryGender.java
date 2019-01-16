package ReaderF;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component("getAvgIncomeForCountryGender")
class GetAvgIncomeForCountryGender {
    Map<String, String> mapAvgIncome = new TreeMap<>();

    Map<String,String> getAvgIncomeForCountryGender(Map<String, String> mapEachCountryGender) {

        mapEachCountryGender.forEach((s, s2) -> {
            Double averageForEach = 0d;
            String splitValue[] = s2.split(",");
            for (String currency : splitValue) {
                Double average = Double.parseDouble(currency);
                if (averageForEach == 0) {
                    averageForEach = average;
                } else {

                    averageForEach = (average + averageForEach) / 2;
                }
            }

            String value = averageForEach.toString();
            mapAvgIncome.put(s, value);
        });


        return mapAvgIncome;
    }
}
