package com.AWT;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Main {

    public static void main(String[] args) throws PrinterException {
        Printable printable = new Printable() { // интерфейс Printable
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {  // получаем графику, параметры страницы и номер сраницы
                if (pageIndex==0){ // если не последняя страница, печятем
                    Graphics2D graphics2D =(Graphics2D)graphics; // графика
                    Line2D line2D = new Line2D.Double(0,0,100,100); // линия
                    graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());// перевести в координаты формата
                    graphics2D.draw(line2D); // отрисовать
                    return PAGE_EXISTS; // печятаем
                }
                return NO_SUCH_PAGE; // останавливаем печать
            }
        };

        PrinterJob Job = PrinterJob.getPrinterJob(); // то что будет печятать
        Job.setPrintable(printable); // засовываем туда нашу картинку
        if (Job.printDialog()){ // вызываем диалог
            Job.print(); // печятаем
        }

    }
}
