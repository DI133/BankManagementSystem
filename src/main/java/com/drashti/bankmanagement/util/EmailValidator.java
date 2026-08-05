package com.drashti.bankmanagement.util;

import java.util.regex.Pattern;

public class EmailValidator {

    public static boolean patternMatches(String emailAddress) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        return Pattern.compile(emailRegex)
                .matcher(emailAddress)
                .matches();
    }
}
