import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DragAndDropTest extends BaseTest{
    private final String PAGE_URL = "https://the-internet.herokuapp.com/drag_and_drop";

    private SelenideElement headerA = $(byText("A"));
    private SelenideElement columnB = $(byId("column-b"));

    @Test
    void checkTheAbilityDragAndDropElement() {
        open(PAGE_URL);
        headerA.dragAndDrop(DragAndDropOptions.to(columnB));
        columnB.lastChild().should(Condition.exactText("A"));
    }
}
