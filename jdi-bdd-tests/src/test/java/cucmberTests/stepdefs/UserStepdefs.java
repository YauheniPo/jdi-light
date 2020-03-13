package cucmberTests.stepdefs;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.elements.common.FileInput;
import cucumber.api.java.en.*;
import org.openqa.selenium.*;

import static com.epam.jdi.bdd.BDDUtils.*;
import static com.epam.jdi.bdd.stepdefs.CheckListSteps.*;
import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.*;
import static com.epam.jdi.tools.PathUtils.*;
import static io.github.com.StaticSite.*;
import static io.github.com.entities.Users.*;
import static io.github.com.pages.Header.*;
import static java.util.Arrays.*;
import static org.testng.Assert.*;

public class UserStepdefs {

    @Then("^the \"([^\"]*)\" is basically valid$")
    public void baseValidation(String name) {
        UIElement el = core(name);
        assertTrue(el.isEnabled());
        assertTrue(el.isDisplayed());
        assertFalse(el.isDisabled());
        assertFalse(el.isHidden());
        Point location = el.getLocation();
        assertTrue(location.x > 0 && location.y > 0, "Location: " + location);
        Dimension size = el.getSize();
        assertTrue(size.height > 0 && size.width > 0, "Size: " + location);
        el.setAttribute("test-jdi", "test-value");
        assertEquals(el.getAttribute("test-jdi"), "test-value");
        el.highlight("blue");
        el.highlight();
        el.show();
    }
    @Given("^I should be logged in$")
    public void iShouldBeLogin() {
        String url = WebPage.getUrl();
        if (!url.contains("https://jdi-testing.github.io/jdi-light/")
                || url.contains("issue")) {
            homePage.open();
        }
        if (userName.isHidden()) {
            if (loginForm.isHidden()) {
                userIcon.click();
            }
            loginForm.submit(DEFAULT_USER);
        }
    }

    @When("^I try to upload file \"([^\"]*)\" by \"([^\"]*)\" file input element$")
    public void iTryToUploadFileByFileInputElement(String pathToFile, String elementName) {
        FileInput fileInput = getUI(elementName, FileInput.class);
        try {
            fileInput.uploadFile(mergePath(PROJECT_PATH, pathToFile));
            fail("Can't upload file in disabled FileInput");
        } catch (Exception ex) {
            assertTrue(ex.getLocalizedMessage().contains("FileInput 'Disabled File Input' is disabled. Can't upload file"));
        }
    }
    @When("^I select \"([^\"]*)\" disabled option \"([^\"]*)\"")
    public void iSelectDisabled(String name, String option) {
        try {
            multiSelect(name, asList(option));
            fail("Select disabled should throw exception");
        } catch (Exception ignore) {}
    }
}