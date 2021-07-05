package app.project.test;

import app.project.classes.DRIVERS;
import app.project.classes.SearchAliExpress;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class TestCases {
    private final String TEST_PASSED = "Test: PASSED";
    private final String TEST_FAILED = "Test: FAILED";
    private final String TITLE_PAGE_1 = "AliExpress - Online Shopping for Popular Electronics, Fashion, Home & Garden, Toys & Sports, Automobiles and More products - AliExpress";
    private final String TITLE_PAGE_2 = "Iphone - Buy Iphone with free shipping on AliExpress";
    private final String PAGE_ACCESSED = "The page was successfully accessed";
    private WebDriver driver;
    private String expectedResult = null;
    private String actualResult = null;
    private String baseURL = "https://www.aliexpress.com/";
    SearchAliExpress searchPage = new SearchAliExpress(driver);

    public void openAliExpress(){
        driver = searchPage.CreateMyDriver(DRIVERS.CHROME); // Se puede cambiar a cualquier navegator que exista en la clase Enum
        searchPage.visitTo(baseURL);

        expectedResult = TITLE_PAGE_1;
        actualResult = searchPage.getTitlePage();
        if(actualResult.equalsIgnoreCase(expectedResult)) {
            System.out.println(PAGE_ACCESSED);
            System.out.println(TEST_PASSED);
        } else{
            System.out.println(TEST_FAILED);
        }
    }

    public void searchItem(){
        System.out.println("------------------TEST 1------------------\n");
        searchPage.searchBoxItem();

        expectedResult = TITLE_PAGE_2;
        actualResult = searchPage.getTitlePage();
        if(actualResult.equalsIgnoreCase(expectedResult)){
            System.out.println(TEST_PASSED);
        } else{
            System.out.println(TEST_FAILED);
        }
    }

    public void navigateToPage(){
        System.out.println("------------------TEST 2------------------\n");
        boolean gotoPage = searchPage.goToPage();

        if(gotoPage){
            System.out.println(TEST_PASSED);
        } else{
            System.out.println(TEST_FAILED);
        }
    }

    public void stockProduct() throws InterruptedException, AWTException {
        System.out.println("------------------TEST 3------------------\n");
        boolean hasStock = searchPage.hasStock();

        if(hasStock){
            System.out.println(TEST_PASSED);
        } else{
            System.out.println(TEST_FAILED);
        }
    }

}
