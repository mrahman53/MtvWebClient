package menu;

import base.CommonAPI;
import base.TestLogger;
import home.page.ShowMenuPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MenuTest extends CommonAPI{

    @Test
    public void menu(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        ShowMenuPage menuPage = PageFactory.initElements(driver, ShowMenuPage.class);
        menuPage.getLatestEpisodeTitleOnSelectedTvShow();
    }
}
