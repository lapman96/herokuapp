import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

class ContextMenuTest extends BaseTest{
    private final String PAGE_URL = "https://the-internet.herokuapp.com/context_menu";

    private SelenideElement hotSpot = $(By.id("hot-spot"));

    @Test
    void checkTheAbilityToOpenContextMenu() {
        open(PAGE_URL);
        hotSpot.contextClick();
        String alertText = Selenide.switchTo().alert().getText();
        Assertions.assertThat(alertText).isEqualTo("You selected a context menu");
    }
}
