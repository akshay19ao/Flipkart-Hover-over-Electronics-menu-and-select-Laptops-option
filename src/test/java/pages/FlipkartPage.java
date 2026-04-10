package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartPage {

    WebDriver driver;
    Actions actions;

    public FlipkartPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    // Locators
    private By closeLoginPopup = By.xpath("//span[@role='button']");
    private By electronicsMenu = By.xpath("//div[contains(text(),'Electronics')]");
    private By laptopsOption = By.xpath("//div[contains(text(),'Laptops')]");

    // Methods

    public void closeLoginPopupIfPresent() {
    	 try {
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	        WebElement closeBtn = wait.until(
    	                ExpectedConditions.elementToBeClickable(By.xpath("//span[@role='button']"))
    	        );

    	        closeBtn.click();
    	        System.out.println("Popup closed successfully");

    	    } catch (Exception e) {
    	        System.out.println("Popup not displayed");
    	    }
    }

    public void hoverOnElectronics() {
        WebElement menu = driver.findElement(electronicsMenu);
        actions.moveToElement(menu).perform();
        menu.click();
    }

    public void clickLaptops() {
        WebElement laptop = driver.findElement(laptopsOption);
        laptop.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}