import com.codeborne.selenide.Configuration;

public class BaseTest {
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
    }
}
