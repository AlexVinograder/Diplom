
package data;

import com.github.javafaker.Faker;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataHelper {


    public static Card getApprovedCard() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "04", "25", faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getDeclinedCard() {
        Faker faker = new Faker();
        return new Card("4444444444444442", "04", "26", faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardNumberFieldEmpty() {
        Faker faker = new Faker();
        return new Card(" ", "04", "24", faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardNumberLessThan16Symbols() {
        Faker faker = new Faker();
        return new Card(faker.number().digits(15), "04", "24", faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardHolderInCyrillic() {
        Faker faker = new Faker(new Locale("ru"));
        return new Card("4444444444444441", "04", "24", faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardHolderInOneWord() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "05", "26", faker.name().firstName() + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardHolderWithSpecialSymbols() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "04", "25", faker.name().firstName() + faker.name().lastName() + "^", faker.number().digits(3));
    }

    public static Card getCardHolderEmptyField() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "10", "24", " ", faker.number().digits(3));
    }

    public static Card getCardMonthLessThan2Figures() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "1", "25", faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardMonthEqual00() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "00", "24", faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardMonthMoreThan12() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "13", "24", faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardMonthEmptyField() {
        Faker faker = new Faker();
        return new Card("4444444444444441", " ", "24", faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardCurrentMonthAndYearPlus5Years() {
        Faker faker = new Faker();
        return new Card("4444444444444441", LocalDate.now().plusYears(5).format(DateTimeFormatter.ofPattern("MM")), LocalDate.now().plusYears(5).format(DateTimeFormatter.ofPattern("YY")), faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardCurrentMonthAndYearMinus1Month() {
        Faker faker = new Faker();
        return new Card("4444444444444441", LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM")), LocalDate.now().format(DateTimeFormatter.ofPattern("YY")), faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardCurrentMonthAndYearPlus6Years() {
        Faker faker = new Faker();
        return new Card("4444444444444441", LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("MM")), LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("YY")), faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardYearEmptyField() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "09", " ", faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardYearOnlyOneFigure() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "10", "4", faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardCvv000() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "08", "25", faker.name().firstName() + " " + faker.name().lastName(), "000");
    }

    public static Card getCardCvvLessThanThreeFigures() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "11", "24", faker.name().firstName() + " " + faker.name().lastName(), "77");
    }

    public static Card getCardYearCvvEmptyField() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "10", "26", faker.name().firstName() + " " + faker.name().lastName(), " ");
    }
}