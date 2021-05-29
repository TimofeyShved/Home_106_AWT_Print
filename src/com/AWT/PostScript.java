package com.AWT;

import java.awt.print.*;
import javax.print.*;
import java.io.*;

public class PostScript {
    public static void main(String[] args) throws FileNotFoundException, PrintException {
        DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE; //формат входящего потока
        String mimeType = "application/postscript"; // тип жокумента
        // переработка потока в нужный тип
        StreamPrintServiceFactory[] factories = StreamPrintServiceFactory.lookupStreamPrintServiceFactories(flavor, mimeType);
        OutputStream outputStream = new FileOutputStream("PostService.odd"); // выходной поток
        StreamPrintService streamPrintService = factories[0].getPrintService(outputStream);  // переводим поток для вывода на печять

        // входящий поток картинки
        InputStream inputStream = new FileInputStream("1.jpg");
        DocPrintJob job = streamPrintService.createPrintJob();  // работа печяти
        Doc doc = new SimpleDoc(inputStream, DocFlavor.INPUT_STREAM.JPEG, null);//настройки, (файл, формат, атрибуты)
        job.print(doc, null); // печять
    }
}
