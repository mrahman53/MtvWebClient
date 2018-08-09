package com.mtv.pagemodel;

import base.CommonAPI;
import reporting.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
            try{
                clickOnCss(".specless-ad-close-button");
            }catch(Exception ex) {
                driver.navigate().refresh();
            }
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
