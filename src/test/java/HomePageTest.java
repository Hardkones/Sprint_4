import PageObjects.HomePageScooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HomePageTest {
    private WebDriver driver;
    private HomePageScooter objHomePage;
    @Before
    public void testCheckAnswers() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        objHomePage = new HomePageScooter(driver);
        driver.findElement(By.id("rcc-confirm-button")).click();
    }
    @Test
    public void HomePageScooterFirstQuestionMatchesFirstAnswer() {
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual = objHomePage.priceSearch();
        assertEquals(expected, actual);
    }
    @Test
    public void HomePageScooterSecondQuestionMatchesSecondAnswer() {
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actual = objHomePage.takeFewScooters();
        assertEquals(expected, actual);
    }
    @Test
    public void HomePageScooterThirdQuestionMatchesThirdAnswer() {
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actual = objHomePage.checkRentalTime();
        assertEquals(expected, actual);
    }
    @Test
    public void HomePageScooterFourthQuestionMatchesFourthAnswer() {
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actual = objHomePage.canBeOrderedToday();
        assertEquals(expected, actual);
    }
    @Test
    public void HomePageScooterFifthQuestionMatchesFifthAnswer() {
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actual = objHomePage.whenTimeIsUp();
        assertEquals(expected, actual);
    }
    @Test
    public void HomePageScooterSixthQuestionMatchesSixthAnswer() {
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actual = objHomePage.willThereBeCharger();
        assertEquals(expected, actual);
    }
    @Test
    public void HomePageScooterSeventhQuestionMatchesSeventhAnswer() {
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actual = objHomePage.orderCancellation();
        assertEquals(expected, actual);
    }
    @Test
    public void HomePageScooterEighthQuestionMatchesEighthAnswer() {
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actual = objHomePage.bringOutsideMkad();
        assertEquals(expected, actual);
    }
    @After
    public void teardown() {

        driver.quit();
    }
}
