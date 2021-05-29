package com.AWT;

import java.awt.print.*;
import javax.print.*;
import java.io.*;

public class PostScript {
    public static void main(String[] args) throws FileNotFoundException, PrintException {
        DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        String mimeType = "application/postscript";
        StreamPrintServiceFactory[] factories = StreamPrintServiceFactory.lookupStreamPrintServiceFactories(flavor, mimeType);
        OutputStream outputStream = new FileOutputStream("PostService.odd");
        StreamPrintService streamPrintService = factories[0].getPrintService(outputStream);

        InputStream inputStream = new FileInputStream("1.jpg");
        DocPrintJob job = streamPrintService.createPrintJob();
        Doc doc = new SimpleDoc(inputStream, DocFlavor.INPUT_STREAM.JPEG, null);
        job.print(doc, null);
    }
}
