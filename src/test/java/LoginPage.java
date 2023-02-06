import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля ввода логина или почты
     */
    @FindBy(xpath = "//*[@id=user-identifier-input]")
    private WebElement loginField;

    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//*[@id=\"password-input\"]")
    private WebElement passwordField;

    /**
     * определение локатора кнопки ВХОД / Регистрации
     */
    @FindBy(xpath = "//*[@id=\"submit-button\"]") //*[@id="submit-button"]
    private WebElement enterBtn;

    /**
     * определение локатора кнопки Регистрации
     */
    @FindBy(xpath = "//*[contains(@class, 'sb-link sb-link--primary')][contains(@data-bbc-result, 'register')]")
    private WebElement registerButton;

    /**
     * определение локатора кнопки 16Over
     */
    @FindBy(xpath = "//*[contains(@class, 'sb-link-button')][contains(@data-bbc-result, '/register/details/age')]")
    private WebElement sixteenOverButton;

    /**
     * определение локатора кнопки день рождения
     */
    @FindBy(xpath = "//*[@id=\"day-input\"]")
    private WebElement dayOfBirthday;

    /**
     * определение локатора кнопки месяца рождения
     */
    @FindBy(xpath = "//*[@id=\"month-input\"]")
    private WebElement monthOfBirthday;

    /**
     * определение локатора кнопки года рождения
     */
    @FindBy(xpath = "//*[@id=\"year-input\"]")
    private WebElement yearOfBirthday;

    //*определение локатора сообщения об ошибке
    @FindBy(xpath = "//*[@id=\"form-message-password\"]/p/span/span[1]")
    private WebElement errorMessage;

    /**
     * метод для для ввода логина
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    /**
     * метод для для ввода пароля
     */
    public void inputPassword(String psswrd) {
        passwordField.sendKeys(psswrd);
    }

    /**
     * метод для нажатия кнопки вход
     */
    public void clickEnterBtn() {
        enterBtn.click();
    }

    /**
     * метод для нажатия кнопки регистрации
     */
    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickSixteenOverButton() {
        sixteenOverButton.click();
    }

    public void inputDayOfBirthdayButton(String day) {
        dayOfBirthday.sendKeys(day);
    }

    public void inputMonthOfBirthdayButton(String month) {
        monthOfBirthday.sendKeys(month);
    }

    public void inputYearOfBirthday(String year) {
        yearOfBirthday.sendKeys(year);
    }

    public String errorMessageGetText() {
        return errorMessage.getText();
    }


}
