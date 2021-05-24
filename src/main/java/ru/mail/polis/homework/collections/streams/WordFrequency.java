package ru.mail.polis.homework.collections.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

/**
 * �������� ���������, ������� �� ������ (����� �����), ���������� 10 ����� ���������� ���� (� ������� �������� �������).
 * ������ ��������� ������������������ �������� �� ���� � ���� �� ������� �� ������� ��� ����� ���������� (.,!:-?;).
 * (���������� ����������� ������ � ������ Character)
 * <p>
 * � �������� ������ ������ - ��� ������ �� �����, ������� ����� ��������� � ���� ����� ����.
 * <p>
 * ���� ���� � ������ ������ 10, �� ������� ��� �����. ���� ����� ����� ���������� ���������� ����������, �� ��������
 * � ������������������ ��������.
 * ����� ���� ���������� ��� ����� ��������.
 * 3 �����
 */
public class WordFrequency {

    private static final String SEPARATORS_REGEX = "[ .,!:\\-?;]+";
    /**
     * ������ ����� ������ ��� ������� ��������� ���������, ������ � ������� �������.
     */
    public static List<String> wordFrequency(Stream<String> lines) {
        return lines
                .map(String::toLowerCase)
                .flatMap(s -> Arrays.stream(s.split(SEPARATORS_REGEX)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()
                        .thenComparing(comparingByKey()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
