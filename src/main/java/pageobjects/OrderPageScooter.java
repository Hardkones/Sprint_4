package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageScooter {
    private WebDriver driver;
    public OrderPageScooter(WebDriver driver) {

        this.driver = driver;
    }
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By adress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By station = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By inputStation = By.xpath(".//div[@class='select-search__select']/ul/li[1]");
    private final By telephone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");
    private final By orderButton = By.className("Button_Button__ra12g");
    private final By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By dateNumber = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--022']");
    private final By rentPeriod = By.xpath(".//div[text()='* Срок аренды']");
    private final By rentPeriodList = By.xpath(".//div[text()='двое суток']");
    public OrderPageScooter clickOrderButton() {

        driver.findElement(orderButton).click();
        return this;
    }
    public OrderPageScooter setName(String nameClient) {
        driver.findElement(name).sendKeys(nameClient);
        return this;
    }
    public OrderPageScooter setSurname(String surnameClient) {

        driver.findElement(surname).sendKeys(surnameClient);
        return this;
    }
    public OrderPageScooter setAdress(String adressClient) {

        driver.findElement(adress).sendKeys(adressClient);
        return this;
    }
    public OrderPageScooter setMetroStation(String metro) {
        driver.findElement(station).sendKeys(metro);
        driver.findElement(inputStation).click();
        return this;
    }
    public OrderPageScooter setOtherMetroStation(String secondMetro) {
        driver.findElement(station).sendKeys(secondMetro);
        driver.findElement(inputStation).click();
        return this;
    }
    public OrderPageScooter setTelephone(String telephoneNumber) {

        driver.findElement(telephone).sendKeys(telephoneNumber);
        return this;
    }
    public OrderPageScooter clickNextButton() {

        driver.findElement(nextButton).click();
        return this;
    }
    public OrderPageScooter setDate() {
        driver.findElement(date).click();
        driver.findElement(dateNumber).click();
        return this;
    }
    public OrderPageScooter setOtherDate() {
        driver.findElement(date).click();
        driver.findElement(By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--029']")).click();
        return this;
    }
    public OrderPageScooter setRentPeriod() {
        driver.findElement(rentPeriod).click();
        driver.findElement(rentPeriodList).click();
        return this;
    }
    public OrderPageScooter setOtherRentPeriod() {
        driver.findElement(rentPeriod).click();
        driver.findElement(By.xpath(".//div[text()='сутки']")).click();
        return this;
    }
    public OrderPageScooter chooseColor() {
        driver.findElement(By.id("black")).click();
        return this;
    }
    public OrderPageScooter chooseOtherColor() {
        driver.findElement(By.id("grey")).click();
        return this;
    }
    public OrderPageScooter writeComment(String comment) {
        driver.findElement(By.xpath(".//input[@placeholder='Комментарий для курьера']")).sendKeys(comment);
        return this;
    }
    public OrderPageScooter clickFinalOrderButton() {
        driver.findElement(By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']")).click();
        return this;
    }
    public OrderPageScooter clickAgreeButton() {
        driver.findElement(By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']")).click();
        return this;
    }
    public boolean isOrderSuccessfullyCreatedIsDisplayed() {
        return driver.findElement(By.className("Order_Modal__YZ-d3")).isDisplayed();
    }
    public OrderPageScooter orderPlacement(String nameClient, String surnameClient, String adressClient, String metro, String telephoneNumber, String comment) {
        clickOrderButton();
        setName(nameClient);
        setSurname(surnameClient);
        setAdress(adressClient);
        setMetroStation(metro);
        setTelephone(telephoneNumber);
        clickNextButton();
        setDate();
        setRentPeriod();
        chooseColor();
        writeComment(comment);
        clickFinalOrderButton();
        clickAgreeButton();
        isOrderSuccessfullyCreatedIsDisplayed();
        return this;
    }
    public OrderPageScooter orderPlacementWithOtherData(String nameClient, String surnameClient, String adressClient, String secondMetro, String telephoneNumber) {
        clickOrderButton();
        setName(nameClient);
        setSurname(surnameClient);
        setAdress(adressClient);
        setOtherMetroStation(secondMetro);
        setTelephone(telephoneNumber);
        clickNextButton();
        setOtherDate();
        setOtherRentPeriod();
        chooseOtherColor();
        clickFinalOrderButton();
        clickAgreeButton();
        isOrderSuccessfullyCreatedIsDisplayed();
        return this;
    }
}
