package app.project.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAliExpress extends SetUpPage {
    private final String OUT_OF_STOCK = "0 pieces available"; //Se asume que este es el label cuando un producto no tiene stock
    private WebDriverWait wait;
    private By search_box = By.id("search-key");
    private By submit_btn = By.xpath("//*[@id=\"form-searchbar\"]/div[1]/input");
    private By second_page = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div[3]/div/div[1]/div/button[2]");

    public SearchAliExpress(WebDriver driver){
        super(driver);
    }

    public void searchBoxItem(){
        String search_txt = "Iphone";
        wait = new WebDriverWait(getDriver(), 15);
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(search_box));

        if (isDisplay(box)){
            type(search_txt,search_box);
            click(submit_btn);
            System.out.println("The item "+ search_txt +" was successfully searched.\n");
        } else {
            throw new IllegalArgumentException("Search box was not found.");
        }
    }

    public boolean goToPage(){
        boolean isOtherPage = false;
        scrollPage(second_page);
        wait = new WebDriverWait(getDriver(), 20);
        WebElement sp = wait.until(ExpectedConditions.visibilityOfElementLocated(second_page));

        if(isDisplay(sp)){
            click(second_page);
            System.out.println("The page was successfully accessed.\n");
            isOtherPage = true;
        } else {
            throw new IllegalArgumentException("The page was not found.\n");
        }
        return isOtherPage;
    }

}




