package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class CSV implements Report {
    private PrintWriter pw ;
    private StringBuilder sb = new StringBuilder();
    @Override
    public void generateReport(String title,String author) {
        String filepath = "D:\\Facultate\\An 3\\An 3\\Semestrul 2\\PS\\workspace\\bookStore\\src\\Books.csv";
        try {
            pw = new PrintWriter(new File(filepath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
      

        sb.append("Title:");
        sb.append(',');
        sb.append(title);
        sb.append('\n');

        sb.append("Author:");
        sb.append(',');
        sb.append(author);
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
    }
}
