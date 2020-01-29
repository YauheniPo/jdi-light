package com.epam.jdi.light.ui.bootstrap;

import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.common.Exceptions.exception;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class BootstrapUtils {

    public static Boolean isElementInViewPort(UIElement element) {
        String script = "var elem = arguments[0],                 " +
                "  box = elem.getBoundingClientRect(),    " +
                "  cx = box.left + box.width / 2,         " +
                "  cy = box.top + box.height / 2,         " +
                "  e = document.elementFromPoint(cx, cy); " +
                "for (; e; e = e.parentElement) {         " +
                "  if (e === elem)                        " +
                "    return true;                         " +
                "}                                        " +
                "return false;                            ";
        Boolean result = (Boolean) element.js().executeScript(script, element.getWebElement());
        return result;
    }
}
