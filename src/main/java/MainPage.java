import com.codeborne.selenide.SelenideElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class MainPage {
    private SelenideElement link = $(byXpath("//a"));
    private SelenideElement endText = $(byXpath("//*[contains(text(),'последняя страница')]"));
    private String text;
    private Pattern pattern;
    private Matcher matcher;
    private int redirectPage;
    private String linkText;
    private String result;



    public MainPage checkLink(int pageNumber, String url) {

        if (!link.isDisplayed()) {
            text = url();
            System.out.println("Страница без ссылки: № " + regular(text));
            open(url + pageNumber + ".html");

        } else {
            linkText = link.getAttribute("href");
            redirectPage = Integer.parseInt(regular(linkText));
            if (redirectPage != pageNumber) {
                   System.out.println("Неверная ссылка на странице № " + regular(text));
                 }
                open(url + pageNumber + ".html");
            }

            return this;
        }


    public boolean endTest(){
        return endText.isDisplayed();
    }

    public String regular(String text) {
        pattern = Pattern.compile("(?<=\\/)\\d{1,4}");
        matcher = pattern.matcher(text);
        while (matcher.find()) {
           result =  text.substring(matcher.start(), matcher.end());
        }
        return result;
    }
    }






