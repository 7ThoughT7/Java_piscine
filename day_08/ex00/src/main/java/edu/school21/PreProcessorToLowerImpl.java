package edu.school21;

import edu.school21.PreProcessor;

public class PreProcessorToLowerImpl implements PreProcessor {
    @Override
    public String preProcess(String text) {
        return text.toLowerCase();
    }
}
