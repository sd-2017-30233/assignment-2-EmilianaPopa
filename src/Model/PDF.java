package Model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class PDF implements Report {
     public static Document document = new Document(PageSize.A4, 50, 50, 50, 50);
     private  String filepath = "D:\\Facultate\\An 3\\An 3\\Semestrul 2\\PS\\workspace\\bookStore\\src\\Books.pdf";
     private  PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filepath));

    public PDF() throws FileNotFoundException, DocumentException {
    }

    @Override
    public void generateReport(String title,String author) {
        Anchor anchorTarget = new Anchor("Books out of stock:");
        anchorTarget.setName("BackToTop");
        document.open();
        Paragraph paragraph1 = new Paragraph();

        paragraph1.setSpacingBefore(50);

        paragraph1.add(anchorTarget);
        try {
            document.add(paragraph1);
            document.add(new Paragraph("\nThe book:"+title+" written by " +author+" is out of stock!\n",
                FontFactory.getFont(FontFactory.COURIER, 14, Font.ITALIC, new CMYKColor(0, 255, 255, 0))));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
       // document.close();
    }
}
