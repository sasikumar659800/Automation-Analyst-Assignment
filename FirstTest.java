package basicscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class FirstTest {

    public static void main(String[] args) {
        
        // Instantiate ChromeDriver to launch the Chrome browser
        ChromeDriver driver = new ChromeDriver();

        // Navigate to the Fitpeo website
        driver.get("https://fitpeo.com");
        driver.manage().window().maximize(); // Maximize the browser window

        // Set an implicit wait to handle element loading delays
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Locate and click the "Revenue Calculator" link
        WebElement revenueCalculatorLink = driver.findElement(By.linkText("Revenue Calculator"));
        revenueCalculatorLink.click();

        // Locate the slider section and scroll it into view using JavaScript
        WebElement sliderSection = driver.findElement(By.xpath("//div[@class='MuiBox-root css-rfiegf']"));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sliderSection);

        // Locate the slider element and drag it to the desired position
        WebElement slider = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb MuiSlider-thumbSizeMedium')]"));
        Actions action = new Actions(driver);
        action.clickAndHold(slider).moveByOffset(94, 0).release().perform(); // Adjust offset as needed for accuracy

        // Define CPT codes to work with
        String[] cptCodes = {"CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474"};

        // Loop through the CPT codes and ensure corresponding checkboxes are selected
        for (String code : cptCodes) {
            WebElement cptCheckbox = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])"));
            if (!cptCheckbox.isSelected()) { // Check if the checkbox is not already selected
                cptCheckbox.click(); // Select the checkbox
            }
        }

        // Repeat similar loops for other sets of checkboxes (as needed)
        for (String code : cptCodes) {
            WebElement cptCheckbox = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]"));
            if (!cptCheckbox.isSelected()) {
                cptCheckbox.click();
            }
        }

        for (String code : cptCodes) {
            WebElement cptCheckbox = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]"));
            if (!cptCheckbox.isSelected()) {
                cptCheckbox.click();
            }
        }

        for (String code : cptCodes) {
            WebElement cptCheckbox = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]"));
            if (!cptCheckbox.isSelected()) {
                cptCheckbox.click();
            }
        }

        // Close the browser after execution
        driver.quit();
    }
}
