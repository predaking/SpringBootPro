package com.example.demo;

public class Test {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int len1 = a.length();
        int len2 = b.length();
        int len = Math.max(len1, len2);
        int plus = 0;
        int delta = Math.abs(len1 - len2);
        String padding = "0".repeat(delta);

        if (len1 > len2) {
            b = padding + b;
        } else {
            a = padding + a;
        }

        for (int i = len - 1; i >= 0; --i) {
            int _a = a.charAt(i) - '0';
            int _b = b.charAt(i) - '0';

            if (_a + _b > 1) {
                str.insert(0, plus == 1 ? '1' : '0');
                plus = 1;
            } else {
                if (_a + _b + plus > 1) {
                    str.insert(0, plus == 1 ? '0' : '1');
                    plus = 1;
                } else {
                    str.insert(0, _a + _b + plus);
                    plus = 0;
                }
            }
        }

        if (plus == 1) {
            str.insert(0, 1);
        }

        return str.toString();
    }
}
