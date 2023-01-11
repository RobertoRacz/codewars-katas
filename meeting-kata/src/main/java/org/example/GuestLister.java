package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GuestLister {
    public String listGuests(String names) {
        String capitalizedNames = names.toUpperCase();
        String[] splitNames = capitalizedNames.split(";");
        List<String> turnedNames = turnNamesAround(splitNames);
        List<String> sortedNames = sortNames(turnedNames);
        return sortedNames.stream()
                .map(person -> person.replace(":", ","))
                .map(person -> "(" + person + ")")
                .collect(Collectors.joining());
    }


    private List<String> sortNames(List<String> turnedNames) {
        turnedNames.sort(Comparator
                .comparing(string -> string.substring(0, string.indexOf(":"))));
        return turnedNames;
    }

    private List<String> turnNamesAround(String[] splitNames) {
        List<String> turnedNames = new ArrayList<>();
        for (String name : splitNames) {
            int delimiterIndex = name.indexOf(":");
            String firstName = name.substring(0, delimiterIndex);
            String lastName = name.substring(delimiterIndex + 1);
            String fullName = lastName + ": " + firstName;
            turnedNames.add(fullName);
    }
        return turnedNames;
}}
