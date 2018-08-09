package content;

import base.CommonAPI;
import reporting.TestLogger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.mtv.pagemodel.*;

public class TvShowSelection extends CommonAPI{

    @Test
    public void selectingContent(){
        TestLogger.log("Browser is Launched");
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        ShowMenuPage showMenuPage = PageFactory.initElements(driver, ShowMenuPage.class);
        showMenuPage.getLatestEpisodeTitleOnSelectedTvShow();
    }
}
