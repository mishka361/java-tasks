package ru.mail.polis.homework.analyzer;

public class NegativeTextFilter implements TextAnalyzer {
    private static final String[] BAD_EMOTIONS = {"=(", ":(", ":|"};

    @Override
    public FilterType getFilterType() {
        return FilterType.NEGATIVE_TEXT;
    }

    @Override
    public boolean analysis(String text) {
        return textContain(text, BAD_EMOTIONS);
    }

    protected boolean textContain(String text, String[] checklist) {
        for (String element : checklist) {
            if (text.contains(element)) {
                return true;
            }
        }
        return false;
    }
}