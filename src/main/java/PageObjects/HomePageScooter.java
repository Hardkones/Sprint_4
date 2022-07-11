package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageScooter {
    private WebDriver driver;

    public HomePageScooter(WebDriver driver) {

        this.driver = driver;
    }

    private final By howMuch = By.id("accordion__heading-0");
    private final By howMuchAnswer = By.id("accordion__panel-0");
    private final By severalScooters = By.id("accordion__heading-1");
    private final By severalScootersAnswer = By.id("accordion__panel-1");
    private final By rentTime = By.id("accordion__heading-2");
    private final By rentTimeAnswer = By.id("accordion__panel-2");
    private final By isAvaliableToday = By.id("accordion__heading-3");
    private final By isAvaliableTodayAnswer = By.id("accordion__panel-3");
    private final By timeOut = By.id("accordion__heading-4");
    private final By timeOutAnswer = By.id("accordion__panel-4");
    private final By charge = By.id("accordion__heading-5");
    private final By chargeAnswer = By.id("accordion__panel-5");
    private final By cancel = By.id("accordion__heading-6");
    private final By cancelAnswer = By.id("accordion__panel-6");
    private final By distance = By.id("accordion__heading-7");
    private final By distanceAnswer = By.id("accordion__panel-7");

    public String priceSearch() {
        driver.findElement(howMuch).click();
        return driver.findElement(howMuchAnswer).getText();
    }

    public String takeFewScooters() {
        driver.findElement(severalScooters).click();
        return driver.findElement(severalScootersAnswer).getText();
    }

    public String checkRentalTime() {
        driver.findElement(rentTime).click();
        return driver.findElement(rentTimeAnswer).getText();
    }

    public String canBeOrderedToday() {
        driver.findElement(isAvaliableToday).click();
        return driver.findElement(isAvaliableTodayAnswer).getText();
    }

    public String whenTimeIsUp() {
        driver.findElement(timeOut).click();
        return driver.findElement(timeOutAnswer).getText();
    }

    public String willThereBeCharger() {
        driver.findElement(charge).click();
        return driver.findElement(chargeAnswer).getText();
    }

    public String orderCancellation() {
        driver.findElement(cancel).click();
        return driver.findElement(cancelAnswer).getText();
    }

    public String bringOutsideMkad() {
        driver.findElement(distance).click();
        return driver.findElement(distanceAnswer).getText();
    }
}