package edu.school21;

import edu.school21.Printer;

import javax.swing.*;

public class PrinterWithPrefixImpl implements Printer {
    private Render renderer;
    private String prefix;

    public PrinterWithPrefixImpl(Render renderer) {
        this.renderer = renderer;
        this.prefix = "Default";
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void print(String text) {
        renderer.printText(prefix + text);
    }
}
