package ru.mail.polis.homework.analyzer;

public class TooLongFilter implements TextAnalyzer {
    private final long maxLength;

    public TooLongFilter(long maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public FilterType getFilterType() {
        return FilterType.TOO_LONG;
    }

    @Override
    public boolean analysis(String text) {
        return text.length() > maxLength;
    }
}
