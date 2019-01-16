package ReaderF;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Map;

public class EntryPoint {
    final String fileName = "Sample_Input1.csv";

    public static void main(String[] args) {
        EntryPoint entryPoint = new EntryPoint();
        entryPoint.execute();

    }

    private void execute() {
        ApplicationContext context = new AnnotationConfigApplicationContext(IncomeObject.class);
        ReadFiler readFiler = context.getBean(ReadFiler.class);
        ArrayList<Personal> personalList = readFiler.readFile(fileName);
        Map<String, String> mapEachCountryGender = context.getBean(GetAvgByList.class).sortToMap(personalList);
        Map<String, String> mapAvgIncome = context.getBean(GetAvgIncomeForCountryGender.class).getAvgIncomeForCountryGender(mapEachCountryGender);
        boolean finalResult = context.getBean(GetFileOutput.class).getFileOutput(mapAvgIncome);
        if (finalResult) {
            System.out.println("Successfully Finished Execution");
        } else {
            System.out.println("Failure");
        }

    }
}
