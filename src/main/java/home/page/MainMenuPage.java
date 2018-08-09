package home.page;

import base.CommonAPI;
import base.TestLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainMenuPage extends CommonAPI{
    @FindBy(how = How.CSS, using = "ul.main_nav li:nth-child(1)")
    public static WebElement showsWebElement;

    public WebElement getShowsWebElement() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        return showsWebElement;
    }

    public void mouseHoverOnSHowMenu(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        mouseHoverByCSS(getShowsWebElement());
    }
}
