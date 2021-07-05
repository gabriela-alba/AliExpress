package app.project.test;

import java.awt.*;

public class Test {
    public static void main(String[] args) throws InterruptedException, AWTException {
        TestCases test = new TestCases();

        test.openAliExpress();

        test.searchItem();

        test.navigateToPage();

        test.stockProduct();

    }

}
