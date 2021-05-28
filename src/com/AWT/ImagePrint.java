package com.AWT;

import javax.print.*;
import java.awt.print.PrinterException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ImagePrint {

    public static void main(String[] args) throws PrinterException, FileNotFoundException, PrintException {
        DocFlavor flavor = DocFlavor.INPUT_STREAM.JPEG; //формат входящего потока

        // Сервисы для печяти, в каком формате и атрибуты(кол-во копий, настройки печати, качество)
        PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);

        // файл, который мы будем печятать
        InputStream inputStream = new FileInputStream("1.jpg");

        //настройки, (файл, формат, атрибуты)
        Doc doc = new SimpleDoc(inputStream, flavor, null);
        if (services.length>0){
            DocPrintJob job = services[0].createPrintJob(); // добавляем работу печяти
            job.print(doc, null); // распечятка документа
        }
    }
}
