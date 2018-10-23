package ReaderF;

import java.util.Map;
import java.util.TreeMap;

import static ReaderF.GetFileOutput.getFileOutput;

class GetAvgIncomeForCountryGender {
  static  Map<String,String> mapAvgIncome=new TreeMap<>();
    static void getAvgIncomeForCountryGender(Map<String, String> mapEachCountryGender) {

        mapEachCountryGender.forEach((s, s2) -> {
            Double averageForEach = 0d;
            String splitValue[] = s2.split(",");
            for (String currency : splitValue) {
                Double average = Double.parseDouble(currency);
                if(averageForEach==0)
                {
                    averageForEach=average;
                }
                else {

                    averageForEach = (average + averageForEach) / 2;
                }
            }

            String value = averageForEach.toString();
            mapAvgIncome.put(s, value);
        });
        //  System.out.println(mapAvgIncome);

       getFileOutput(mapAvgIncome);
    }
}
