package co.com.segVidaDigital.screenplay.helpers;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Date {
    private Date() {
    }

    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());
    static int yearRamdon;


    public static int obtenerYearAleatorio() {
        LocalDate current_date = LocalDate.now();
        yearRamdon = faker.number().numberBetween(Constant.YEAR_INICIAL, current_date.getYear());
        return yearRamdon;
    }

    public static int obtenerYearPersonaAdulta() {
        int yearActualMenos19 = yearRamdon - Constant.YEAR_A_RESTAR;
        return yearActualMenos19;
    }


}
