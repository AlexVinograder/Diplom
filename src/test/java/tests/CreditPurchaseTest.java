package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import data.DataHelper;
import data.SQLHelper;
import pages.PaymentPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CreditPurchaseTest {
    public static String url = System.getProperty("sut.url");

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void openPage() {
        open(url);
    }

    @AfterEach
    public void cleanBase() {
        SQLHelper.clearDB();
    }

    @Test
    void shouldBuyCardApproved() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getApprovedCard());
        page.getApprovedOperationNotification();
        assertEquals("APPROVED", SQLHelper.getCreditRequestStatus());
    }


    @Test
    void shouldNotBuyDeclinedCard() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getDeclinedCard());
        page.getFailedNotification();
        assertEquals("DECLINED", SQLHelper.getCreditRequestStatus());
    }


    @Test
    void shouldNotBuyCardNumberFieldEmpty() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardNumberFieldEmpty());
        page.getNotificationWrongFormat();
        assertNull(SQLHelper.getCreditRequestStatus());
    }


    @Test
    void shouldNotBuyCardNumberLessThan16Symbols() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardNumberLessThan16Symbols());
        page.getNotificationWrongFormat();
        assertNull(SQLHelper.getCreditRequestStatus());
    }


    @Test
    void shouldNotBuyCardHolderInCyrillic() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardHolderInCyrillic());
        page.getNotificationWrongFormat();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyCardHolderInOneWord() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardHolderInOneWord());
        page.getNotificationWrongFormat();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyCardHolderWithSpecialSymbols() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardHolderWithSpecialSymbols());
        page.getNotificationWrongFormat();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyCardHolderEmptyField() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardHolderEmptyField());
        page.getNotificationRequiredFieldError();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyCardMonthLessThan2Figures() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardMonthLessThan2Figures());
        page.getNotificationWrongFormat();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyCardMonthEqual00() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardMonthEqual00());
        page.getNotificationExpirationDateError();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyCardMonthMoreThan12() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardMonthMoreThan12());
        page.getNotificationExpirationDateError();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyCardMonthEmptyField() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardMonthEmptyField());
        page.getNotificationWrongFormat();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldBuyCardCurrentMonthAndYearPlus5Years() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardCurrentMonthAndYearPlus5Years());
        page.getApprovedOperationNotification();
        assertEquals("APPROVED", SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyCardCurrentMonthAndYearMinus1Month() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardCurrentMonthAndYearMinus1Month());
        page.getNotificationExpirationDateError();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyNotCardCurrentMonthAndYearPlus6Years() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardCurrentMonthAndYearPlus6Years());
        page.getNotificationExpirationDateError();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyCardYearEmptyField() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardYearEmptyField());
        page.getNotificationWrongFormat();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyCardYearOnlyOneFigure() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardYearOnlyOneFigure());
        page.getNotificationWrongFormat();
        assertNull(SQLHelper.getCreditRequestStatus());

    }

    @Test
    void shouldNotBuyCardCvv000() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardCvv000());
        page.getNotificationWrongFormat();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyCardYearCvvEmptyField() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardYearCvvEmptyField());
        page.getNotificationRequiredFieldError();
        assertNull(SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotBuyCardCvvLessThanThreeFigures() {
        val page = new PaymentPage();
        page.goToCreditPage();
        page.inputData(DataHelper.getCardCvvLessThanThreeFigures());
        page.getNotificationWrongFormat();
        assertNull(SQLHelper.getCreditRequestStatus());
    }
}