package edu.school21;

import javax.swing.*;

public class RenderErrImpl implements Render {
    private PreProcessor preProcessor;

    public RenderErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void printText(String text) {
        System.err.println(preProcessor.preProcess(text));
    }
}
