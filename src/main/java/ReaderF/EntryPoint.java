package ReaderF;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EntryPoint {
    public static void main(String[] args) {
        EntryPoint entryPoint = new EntryPoint();
        entryPoint.execute();

    }

    private void execute() {
        final String fileName = "C:\\Users\\bahul.malik\\IdeaProjects\\Inco_Culator\\Resources\\Sample_Input1.csv";

        ApplicationContext context = new AnnotationConfigApplicationContext(IncomeObject.class);
        ReadFiler readFiler = context.getBean(ReadFiler.class);
        readFiler.readFile(fileName,context);
    }
}
