package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.*;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.complex.enums.Colors.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class RadioTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        colors.select(text);
    }
    String text = "Blue";

    @Test
    public void getValueTest() {
        assertEquals(colors.getValue(), text);
    }

    @Test
    public void selectTest() {
        colors.select("Green");
        assertEquals(colors.getValue(), "Green");
        colorsNoLocator.select("Blue");
        colorsNoLocator.is().selected("Blue");
    }

    @Test
    public void selectEnumTest() {
        colors.select(Blue);
        assertEquals(colors.getValue(), "Blue");
        colorsNoLocator.select(Red);
        colorsNoLocator.is().selected(Red);
    }
    @Test
    public void selectNumTest() {
        colors.select(1);
        assertEquals(colors.getValue(), "Red");
    }
    @Test
    public void selectedTest() {
        assertEquals(colors.selected(), text);
    }
    @Test
    public void valuesTest() {
        assertEquals(colors.values(), asList("Red", "Green", "Blue", "Yellow"));
    }

    @Test
    public void isValidationTest() {
        colors.is().selected("Blue");
        colors.is().selected(Blue);
        colors.is().values(hasItem("Yellow"));
        colors.is().disabled(hasItem("Yellow"));
        colors.is().enabled(not(hasItem("Yellow")));
        colors.is().enabled(hasItems("Green", "Blue"));

        colorsNoLocator.is().selected("Blue");
        colorsNoLocator.is().selected(Blue);
    }

    @Test
    public void assertValidationTest() {
        colors.assertThat().values(contains("Red", "Green", "Blue", "Yellow"));
    }

}
