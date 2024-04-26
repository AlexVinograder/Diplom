package data;

import lombok.Getter;

public class Card {

    @Getter
    private String cardNumber;
    @Getter
    private String month;
    @Getter
    private String year;
    @Getter
    private String cardHolder;
    @Getter
    private String cvv;


    public Card(String cardNumber, String month, String year, String cardHolder, String cvv) {
        this.cardNumber = cardNumber;
        this.month = month;
        this.year = year;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
    }
}