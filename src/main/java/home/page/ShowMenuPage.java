package home.page;

import base.CommonAPI;
import base.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sun.applet.Main;
import sun.jvm.hotspot.debugger.Page;

import java.util.ArrayList;
import java.util.List;

public class ShowMenuPage extends CommonAPI{

    @FindBy(how = How.CSS, using = ".column a[href*='shows']")
    public static WebElement showsAToZWebElement;

    @FindBy(how = How.CSS, using = ".L001_line_list li:nth-child(2) .s_fonts_lineListHeader")
    public static WebElement selectTvShowWebElement;

    @FindBy(how = How.CSS, using = ".S001_line_list_item .s_fonts_lineListHeader")
    public static WebElement tvShowNameWebElement;

    @FindBy(how = How.CSS, using = "#tier_5 .L001_line_list li:nth-child(1) .s_fonts_lineListHeader")
    public static WebElement clipTitleWebElement;

    public WebElement getSelectTvShowWebElement() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        return selectTvShowWebElement;
    }

    public WebElement getClipTitleWebElement() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        return clipTitleWebElement;
    }

    public WebElement getShowsAToZWebElement() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        return showsAToZWebElement;
    }

    public void clickOnDesiredShowFromMultipleSeries(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        getSelectTvShowWebElement().click();
    }
    public String getClipTitle(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String title = getClipTitleWebElement().getText();
        return title;
    }
    public void getLatestEpisodeTitleOnSelectedTvShow(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        MainMenuPage mainMenuPage = PageFactory.initElements(driver, MainMenuPage.class);
        if(isFramePresent("#leaderboard-ad-container")) {
            //driver.switchTo().frame(driver.findElement(By.cssSelector("#component-9b2aca04-60c9-433f-8210-c201d0579442-panel")));
            try{
                clickOnCss(".specless-ad-close-button");
            }catch(Exception ex) {
                try{
                    clickOnCss("#speclessShim");
                }catch(Exception ex2){
                    //driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id, 'component')]")));
                    driver.findElement(By.xpath("//*[contains(@id,'container'and @type='hidden') and contains(@class,'specless-ad-close-button')]"));
                    //driver.switchTo().defaultContent();
                }
            }
            driver.navigate().refresh();
        }
        mainMenuPage.mouseHoverOnSHowMenu();
        getShowsAToZWebElement().click();
        if(isFramePresent("#leaderboard-ad-container")){
            driver.navigate().refresh();
        }
        List<WebElement> elementList = driver.findElements(By.cssSelector(".L001_line_list li"));
        for(int i = 0; i<elementList.size(); i++){
            String st = elementList.get(i).findElement(By.cssSelector(".S001_line_list_item .s_fonts_lineListHeader")).getText();
            if(st.equalsIgnoreCase("Catfish: The TV Show")){
                clickOnDesiredShowFromMultipleSeries();
                scrollDown();
                System.out.println("Latest Video Clip Title: " + getClipTitle());
                break;
            }
        }

    }

}
