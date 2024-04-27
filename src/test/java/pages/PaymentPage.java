package pages;

import com.codeborne.selenide.SelenideElement;
import data.Card;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    private final SelenideElement headingCredit = $$("h3").find(exactText("Кредит по данным карты"));

    public final SelenideElement creditButton = $$(".button").findBy(text("Купить в кредит"));
    private final SelenideElement heading = $$("h2").findBy(text("Путешествие дня"));
    private final SelenideElement buyButton = $$(".button").findBy(text("Купить"));
    public final SelenideElement approvedOperationNotification = $$(".notification__content").findBy((text("Операция одобрена Банком.")));
    public final SelenideElement failedOperationNotification = $$(".notification__content").findBy((text("Ошибка! Банк отказал в проведении операции.")));
    private static final SelenideElement successNotificationTitle = $$(".notification__title").findBy((text("Успешно")));
    private static final SelenideElement failedNotificationTitle = $$(".notification__title").findBy((text("Ошибка")));
    private final SelenideElement headingOrdinary = $$("h3").find(exactText("Оплата по карте"));
    private final SelenideElement cardNumberField = $(byText("Номер карты")).parent().$("[class=\"input__control\"]");
    private final SelenideElement monthField = $(byText("Месяц")).parent().$("[class=\"input__control\"]");
    private final SelenideElement yearField = $(byText("Год")).parent().$("[class=\"input__control\"]");
    private final SelenideElement cardHolderField = $(byText("Владелец")).parent().$("[class=\"input__control\"]");
    private final SelenideElement cvvField = $(byText("CVC/CVV")).parent().$("[class=\"input__control\"]");
    private final SelenideElement wrongFormatErrorNotification = $(byText("Неверный формат"));
    private final SelenideElement cardExpirationDateError = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement cardExpiredDateError = $(byText("Истёк срок действия карты"));
    private final SelenideElement requiredFieldError = $(byText("Поле обязательно для заполнения"));

    private final SelenideElement cancelField = $$("[class=\"icon-button__text\"]").first();
    private final SelenideElement continueButton = $$("button").find(exactText("Продолжить"));

    public PaymentPage() {
        heading.shouldBe(visible);
    }

    public void inputData(Card card) {
        cardNumberField.setValue(card.getCardNumber());
        monthField.setValue(card.getMonth());
        yearField.setValue(card.getYear());
        cardHolderField.setValue(card.getCardHolder());
        cvvField.setValue(card.getCvv());
        continueButton.click();
    }

    public void getApprovedOperationNotification() {
        successNotificationTitle
                .shouldBe(visible, Duration.ofSeconds(14))
                .shouldHave(exactText("Успешно"));
        approvedOperationNotification
                .shouldHave(exactText("Операция одобрена Банком."));
        cancelField.click();
    }

    public void getFailedNotification() {
        failedNotificationTitle
                .shouldBe(visible, Duration.ofSeconds(14))
                .shouldHave(exactText("Ошибка"));
        failedOperationNotification
                .shouldHave(exactText("Ошибка! Банк отказал в проведении операции."));
        cancelField.click();
    }


    public void getNotificationWrongFormat() {
        wrongFormatErrorNotification.shouldBe(visible);
    }

    public void getNotificationExpirationDateError() {
        cardExpirationDateError.shouldBe(visible);
    }

    public void getNotificationExpiredError() {
        cardExpiredDateError.shouldBe(visible);
    }

    public void getNotificationRequiredFieldError() {
        requiredFieldError.shouldBe(visible);
    }
    public void  goToBuyPage() {
        buyButton.click();
        headingOrdinary.shouldBe(visible);
    }

    public void  goToCreditPage() {
        creditButton.click();
        headingCredit.shouldBe(visible);
    }

}