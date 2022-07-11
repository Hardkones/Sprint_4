import PageObjects.OrderPageScooter;
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
        objOrderPage.clickOrderButton();
        objOrderPage.setName("Есения");
        objOrderPage.setSurname("Кадочкина");
        objOrderPage.setAdress("Электродная 2");
        objOrderPage.setMetroStation("шоссе энтузиастов");
        objOrderPage.setTelephone("+79029521945");
        objOrderPage.clickNextButton();
        objOrderPage.setDate();//"22.09.2022"
        objOrderPage.setRentPeriod();
        objOrderPage.chooseColor();
        objOrderPage.writeComment("Хочу кататься!!!");
        objOrderPage.clickFinalOrderButton();
        objOrderPage.clickAgreeButton();
        objOrderPage.isOrderSuccessfullyCreatedIsDisplayed();

        assertTrue("Window order successfully created is not displayed", objOrderPage.isOrderSuccessfullyCreatedIsDisplayed());
    }
    @Test
    public void OrderPageScooterOrderPlacementWithSuccessfullyCreatedField2() {
        objOrderPage.clickOrderButton();
        objOrderPage.setName("сеня");
        objOrderPage.setSurname("софт");
        objOrderPage.setAdress("федеративный проспект 39");
        objOrderPage.setOtherMetroStation("новогиреево");
        objOrderPage.setTelephone("89832824710");
        objOrderPage.clickNextButton();
        objOrderPage.setOtherDate();//"29.07.2021"
        objOrderPage.setOtherRentPeriod();
        objOrderPage.chooseOtherColor();
        objOrderPage.clickFinalOrderButton();
        objOrderPage.clickAgreeButton();
        objOrderPage.isOrderSuccessfullyCreatedIsDisplayed();

        assertTrue("Window order successfully created is not displayed", objOrderPage.isOrderSuccessfullyCreatedIsDisplayed());
    }

    @After
    public void teardown() {

        driver.quit();
    }
}