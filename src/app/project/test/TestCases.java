package app.project.test;

import app.project.classes.DRIVERS;
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

    public void openAliExpress(){
        driver = searchPage.CreateMyDriver(DRIVERS.CHROME); // Se puede cambiar a cualquier navegator que exista en la clase Enum
        searchPage.visitTo(baseURL);

        expectedResult = "AliExpress - Online Shopping for Popular Electronics, Fashion, Home & Garden, Toys & Sports, Automobiles and More products - AliExpress";
        actualResult = searchPage.getTitlePage();
        if(actualResult.equalsIgnoreCase(expectedResult)) {
            System.out.println(TEST_PASSED);
        } else{
            System.out.println(TEST_FAILED);
        }
    }

    public void searchItem(){
        System.out.println("------------------TEST 1------------------\n");
        searchPage.searchBoxItem();

        expectedResult = "Iphone - Buy Iphone with free shipping on AliExpress";
        actualResult = searchPage.getTitlePage();
        if(actualResult.equalsIgnoreCase(expectedResult)){
            System.out.println(TEST_PASSED);
        } else{
            System.out.println(TEST_FAILED);
        }
    }

}
