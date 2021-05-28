package com.AWT;

import javax.print.*;
import java.awt.print.PrinterException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ImagePrint {

    public static void main(String[] args) throws PrinterException, FileNotFoundException, PrintException {
        DocFlavor flavor = DocFlavor.INPUT_STREAM.JPEG;
        PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
        InputStream inputStream = new FileInputStream("1.jpg");
        Doc doc = new SimpleDoc(inputStream, flavor, null);
        if (services.length>0){
            DocPrintJob job = services[0].createPrintJob();
            job.print(doc, null);
        }
    }
}
