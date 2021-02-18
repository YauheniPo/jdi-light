package io.github.com;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.popover.HoverOverPop;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.tools.DataClass;
import io.github.com.pages.displaydata.IconFrame;
import io.github.com.pages.displaydata.InsetDividerFrame;
import io.github.com.pages.displaydata.VerticalDividerFrame;
import io.github.com.pages.inputs.ButtonFrame;
import io.github.com.pages.inputs.SwitchFrame;
import io.github.com.pages.inputs.TextFieldFrame;
import io.github.com.pages.popOver.PopOverFrame;
import io.github.com.pages.surfaces.AccordionFrame;
import io.github.com.pages.surfaces.PaperFrame;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class StaticSite {

    // inputs
    // switch
    @Frame("storybook-preview-iframe")
    public static SwitchFrame switchFrame;

    @Url("/material-ui-switch--default")
    public static WebPage inputSwitchDefaultPage;

    @Url("/material-ui-switch--disabled")
    public static WebPage inputSwitchDisabledPage;

    @Url("/material-ui-switch--disabled-and-checked")
    public static WebPage inputSwitchDisabledAndCheckedPage;

    // button
    @Frame("storybook-preview-iframe")
    public static ButtonFrame buttonFrame;

    @Url("/material-ui-button--default")
    public static WebPage inputButtonDefaultPage;

    @Url("/material-ui-button--disabled")
    public static WebPage inputButtonDisabledPage;

    // text field
    @Frame("storybook-preview-iframe")
    public static TextFieldFrame textFieldFrame;

    @Url("/material-ui-textfield--standard")
    public static WebPage inputTextFieldStandardPage;

    @Url("/material-ui-textfield--field-with-default")
    public static WebPage inputTextFieldFilledWithDefaultPage;

    @Url("/material-ui-textfield--filled")
    public static WebPage inputTextFieldFilledPage;

    @Url("/material-ui-textfield--disabled")
    public static WebPage inputTextFieldDisabledPage;

    @Url("/material-ui-textfield--time")
    public static WebPage inputTextFieldTimePage;

    // surfaces
    // accordion
    @Frame("storybook-preview-iframe")
    public static AccordionFrame accordionFrame;

    @Url("/material-ui-surfaces-accordion--default")
    public static WebPage surfaceAccordionPage;

    @Url("/material-ui-surfaces-accordion--disabled")
    public static WebPage surfaceAccordionDisabledPage;

    // paper
    @Frame("storybook-preview-iframe")
    public static PaperFrame paperFrame;

    @Url("/material-ui-surfaces-paper--default")
    public static WebPage surfacePaperDefaultPage;

    // inputs
    // switch
    @Frame("storybook-preview-iframe")
    public static InsetDividerFrame insetDividerFrame;

    @Url("/material-ui-data-display-dividers--inset-dividers-view")
    public static WebPage dataDisplayInsetDividerPage;

    @Frame("storybook-preview-iframe")
    public static VerticalDividerFrame verticalDividerFrame;

    @Url("/material-ui-data-display-dividers--vertical-dividers-view")
    public static WebPage dataDisplayVerticalDividerPage;

    // Display data
    // material icon
    @Frame("storybook-preview-iframe")
    public static IconFrame iconFrame;

    @Url("/material-ui-data-display-icon--default")
    public static WebPage displayDataDefaultMaterialIconPage;

    @Url("/material-ui-data-display-icon--secondary")
    public static WebPage displayDataLargeMaterialIconPage;

    @Frame("storybook-preview-iframe")
    public static PopOverFrame popOverFrame;

    @Url("/story/material-ui-utils-popover--click")
    public static WebPage popOverPage;

    @Frame("storybook-preview-iframe")
    public static HoverOverPop hoverOverPop;

    @Url("/story/material-ui-utils-popover--hover")
    public static WebPage hoverOverPopPage;
  
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
