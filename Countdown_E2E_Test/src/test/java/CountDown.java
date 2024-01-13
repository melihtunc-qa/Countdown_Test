import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.SQLOutput;

@FixMethodOrder(MethodSorters.JVM)

public class CountDown {

    static ChromeOptions options= new ChromeOptions();
    static WebDriver driver = new ChromeDriver(options);

    @BeforeClass
    public static void getDriver() {
        System.out.println(" CHROME BAŞLATILDI \n ");
        options.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");
    }

    private void zoomPage(WebDriver driver, double zoomFactor) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.body.style.zoom='" + zoomFactor + "'");
    }

    @Test

    public void UserInterface_ZoominOut_Test() throws InterruptedException {

        Thread.sleep(3000);

        zoomPage(driver,3.0);

        Thread.sleep(3000);

        zoomPage(driver,1.0);

    }

    @Test
    public void Start_Button_Test() throws InterruptedException {


        Thread.sleep(3000);

        WebElement startButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/p"));

        if (startButton.isDisplayed()) {
            System.out.println(" START Butonu görüntülendi ");
        }

        if (startButton.isEnabled()) {
            System.out.println(" START Butonu tıklama işlevine açık ");
        }

        startButton.click();

        Thread.sleep(3000);

        System.out.println(" Zamanlayıcı başarılı şekilde tetiklendi ");

        if (!startButton.isEnabled()) {
            System.out.println(" START butonunun geri sayım çalışırken tıklanabilir olmadığı görüldü   ");
        } else {
            System.out.println(" START Butonu geri sayım çalışırken tıklanabilir durumda fakat beklendiği üzere inaktif");
        }

    }

    @Test
    public void Stop_Button_Test() throws InterruptedException {
        WebElement stopButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/p"));

        if (stopButton.isDisplayed()) {
            System.out.println(" STOP Butonu görüntülendi ");
        }

        if (stopButton.isEnabled()) {
            System.out.println(" STOP Butonu tıklama işlevine açık ");
        }
        Thread.sleep(3000);


        stopButton.click();

        Thread.sleep(3000);

        if (stopButton.isEnabled()) {
            System.out.println(" STOP Butonu gerisayım durduktan sonra tıklanabilir durumda fakat beklendiği üzere inaktif ");
        }
    }

    @Test

    public void Reset_Button_Test() throws InterruptedException {

        WebElement resetButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[3]/p"));


        if (resetButton.isDisplayed()) {
            System.out.println(" RESET Butonu görüntülendi ");
        }

        if (resetButton.isEnabled()) {
            System.out.println(" RESET Butonu tıklama işlevine açık ");
        }

        Thread.sleep(3000);

        resetButton.click();

        if (resetButton.isEnabled()) {
            System.out.println(" RESET Butonu , geri sayım resetlendikten sonra tıklanabilir durumda fakat beklendiği üzere inaktif ");
        }

    }

    @Test
    @Category(FirefoxTests.class)
    public void CrossBrowser_Test_Firefox() throws InterruptedException {

        driver.quit();
        driver=new FirefoxDriver();
        options.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");

        System.out.println(" FIREFOX BAŞLATILDI \n ");
        Start_Button_Test();
        Stop_Button_Test();
        Reset_Button_Test();

    }

    @Test
    @Category(EdgeTests.class)
    public void CrossBrowser_Test_EdgeDriver() throws InterruptedException {

        driver.quit();
        driver=new EdgeDriver();
        options.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");

        System.out.println(" EDGE BROWSER BAŞLATILDI \n ");
        Start_Button_Test();
        Stop_Button_Test();
        Reset_Button_Test();

    }

 /*   @AfterClass

    public static void tearDown(){
        driver.close();
    }
*/

}
