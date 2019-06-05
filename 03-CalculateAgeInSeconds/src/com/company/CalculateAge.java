package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class CalculateAge {

    public static long inSeconds(String birthdateString) throws ParseException {
        SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = dates.parse(birthdateString);
        Date now = Date.from(Instant.now());
        return Math.abs(now.getTime() - birthDate.getTime()) / 1000;
    }

}
