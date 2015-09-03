package com.ea.test;

public class StringComparator implements java.util.Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }
}