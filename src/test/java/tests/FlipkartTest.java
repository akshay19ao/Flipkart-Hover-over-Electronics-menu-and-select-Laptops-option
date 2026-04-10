package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlipkartPage;

public class FlipkartTest extends BaseTest {

    @Test
    public void verifyLaptopsNavigation() {

        FlipkartPage page = new FlipkartPage(driver);

        // Close popup
        page.closeLoginPopupIfPresent();

        // Hover Electronics
        page.hoverOnElectronics();

        // Click Laptops
        page.clickLaptops();

        // Validation
        String title = page.getPageTitle();
        System.out.println("Page Title: " + title);

        Assert.assertTrue(title.toLowerCase().contains("laptop"),
                "Title does not contain 'Laptop'");
    }
}