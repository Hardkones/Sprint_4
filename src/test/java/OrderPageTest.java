import pageobjects.OrderPageScooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class OrderPageTest {
    private WebDriver driver;
    private OrderPageScooter objOrderPage;

    @Before
    public void testCreateOrder() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objOrderPage = new OrderPageScooter(driver);
    }

    @Test
    public void OrderPageScooterOrderPlacementWithSuccessfullyCreatedField() {
        objOrderPage.orderPlacement(
                "Есения",
                "Кадочкина",
                "Электродная 2",
                "шоссе энтузиастов",
                "+79029521945",
                "хочу кататься!!!");
        assertTrue("Window order successfully created is not displayed", objOrderPage.isOrderSuccessfullyCreatedIsDisplayed());
    }
    @Test
    public void OrderPageScooterOrderPlacementWithSuccessfullyCreatedField2() {
        objOrderPage.orderPlacementWithOtherData(
                "сеня",
                "софт",
                "федеративный проспект 39",
                "новогиреево",
                "89832824710");
        assertTrue("Window order successfully created is not displayed", objOrderPage.isOrderSuccessfullyCreatedIsDisplayed());
    }

    @After
    public void teardown() {

        driver.quit();
    }
}