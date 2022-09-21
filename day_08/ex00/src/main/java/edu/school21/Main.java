package edu.school21;

import edu.school21.PreProcessor;
import edu.school21.PreProcessorToUpperImpl;
import edu.school21.PrinterWithPrefixImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        PreProcessor preProcessor = new PreProcessorToUpperImpl();
        Render renderer = new RenderErrImpl(preProcessor);
        PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
        printer.setPrefix ("Prefix ");
        printer.print ("Hello!");

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer printer1 = context.getBean("printerWithPrefix", Printer.class);
        printer1.print ("Hello!") ;

        PreProcessor preProcessor1 = new PreProcessorToLowerImpl();
        Render renderer1 = new RenderErrImpl(preProcessor1);
        PrinterWithPrefixImpl printer2 = new PrinterWithPrefixImpl(renderer1);
        printer2.setPrefix("Prefix ");
        printer2.print("HI!");

        ApplicationContext context1 = new ClassPathXmlApplicationContext("context.xml");
        Printer printer3 = context.getBean("printerWithPrefix1", Printer.class);
        printer3.print ("HI!") ;

    }
}
