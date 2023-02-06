import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class LoginTest {
    /**
     * осуществление первоначальной настройки
     */
    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();

        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickEnterBtn();
    }

    @Test
    public void passwordLengthTest(){
        loginPage.clickRegisterButton();
        loginPage.clickSixteenOverButton();
        loginPage.inputDayOfBirthdayButton("12");
        loginPage.inputMonthOfBirthdayButton("09");
        loginPage.inputYearOfBirthday("1986");
        loginPage.clickEnterBtn();
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        loginPage.inputPassword("1234567");
        Assert.assertTrue(loginPage.errorMessageGetText().equals("Извините, этот пароль слишком короткий"));
    }
}
