package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class PlaywrightTest {

    @Test
    public void testGoogleSearch() {
        
        try (Playwright playwright = Playwright.create()) {
            
            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
            );
            
            Page page = browser.newPage();
            
            page.navigate("https://www.google.com");
            
            System.out.println("Title: " + page.title());
            
            page.fill("textarea[name='q']", "IBS Software Kochi");
            
            page.keyboard().press("Enter");
            
            page.waitForTimeout(3000);
            
            System.out.println("Search done!");
            
            browser.close();
        }
    }
}