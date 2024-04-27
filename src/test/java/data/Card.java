package data;

import lombok.Value;

@Value
public class Card {

    private String cardNumber;
    private String month;
    private String year;
    private String cardHolder;
    private String cvv;
}