import io.qameta.allure.Owner;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    private MainPage mainPage;
    private int pageNumber = 2;
    private String url = "http://qa-web-test-task.s3-website.eu-central-1.amazonaws.com/";

    @Before
    public void start(){
        mainPage = new MainPage();
        open(url+"1.html");
    }

    @Test
    @Owner(value = "Абушаева Александра")
    public void checkPage(){
        if (!mainPage.endTest()) {
            for (int i = 1; i < pageNumber; i++) {
                mainPage.checkLink(pageNumber,url);
                ++pageNumber;
                if(mainPage.endTest()) {
                    System.out.println("Finish");break;}
            }
        }
    }
    


}
