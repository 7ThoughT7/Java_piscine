package edu.school21;

import edu.school21.Printer;

import javax.swing.*;
import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {

    private Render renderer;

    public PrinterWithDateTimeImpl(Render renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String text) {
        renderer.printText(LocalDateTime.now() + " " + text);
    }
}
