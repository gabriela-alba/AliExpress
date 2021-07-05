package app.project.test;

import app.project.classes.SearchAliExpress;
import org.openqa.selenium.WebDriver;

public class TestCases {
    private final String TEST_PASSED = "Test: PASSED";
    private final String TEST_FAILED = "Test: FAILED";
    private WebDriver driver;
    private String expectedResult = null;
    private String actualResult = null;
    private String baseURL = "https://www.aliexpress.com/";
    SearchAliExpress searchPage = new SearchAliExpress(driver);

}
