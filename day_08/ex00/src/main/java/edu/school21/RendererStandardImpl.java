package edu.school21;

import edu.school21.Render;

public class RendererStandardImpl implements Render {

    private PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void printText(String text) {
        System.out.println(preProcessor.preProcess(text));
    }
}
