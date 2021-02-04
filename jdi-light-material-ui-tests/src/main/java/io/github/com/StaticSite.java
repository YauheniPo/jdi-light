package io.github.com;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.tools.DataClass;
import io.github.com.pages.MaterialPage;

@JSite("https://jdi-testing.github.io/jdi-light")
public class StaticSite {

    @Url("/material-ui-surfaces-accordion--default")
    public static WebPage surfaceAccordionPage;

    @Url("/material-ui-surfaces-accordion--disabled")
    public static WebPage surfaceAccordionDisabledPage;

    @Url("/story/material-ui-inputs-checkbox--primary")
    public static WebPage primaryCheckBoxPage;

    @Frame("storybook-preview-iframe")
    public static MaterialPage materialPageFrame;

    @UI("#login-form")
    public static Form<User> loginForm;

    @Css(".logout")
    public static Button logout;
    public static Button userIcon;
    public static Text userName;

    public static class User extends DataClass<User> {
        public String name = "Roman";
        public String password = "Jdi1234";
    }
}
