import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class AddRemoveElementTest extends BaseTest{

    private final String PAGE_URL = "https://the-internet.herokuapp.com/add_remove_elements/";

    private SelenideElement addElementButton = $(byText("Add Element"));

    private SelenideElement deleteElementButton = $(byText("Delete"));

    @Test
    void checkAddingNewElement() {
        open(PAGE_URL);
        deleteElementButton.should(Condition.disappear);
        addElementButton.click();
        deleteElementButton.should(Condition.visible);
    }

    @Test
    void checkRemovingElement() {
        open(PAGE_URL);
        addElementButton.click();
        deleteElementButton.click();
        deleteElementButton.should(Condition.disappear);
    }
}
