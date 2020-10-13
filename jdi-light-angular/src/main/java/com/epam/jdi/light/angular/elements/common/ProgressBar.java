package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.ProgressBarAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.jdi.light.angular.elements.enums.ProgressBarModes.BUFFER;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarModes.DETERMINATE;
import static com.epam.jdi.light.ui.html.HtmlUtils.getDouble;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;

/**
 * To see an example of ProgressBar web element please visit https://material.angular.io/components/progress-bar/overview#buffer.
 */

public class ProgressBar extends UIBaseElement<ProgressBarAssert> {

    @JDIAction(value = "Get '{name}' max limit")
    public int max() {
        return getInt(uiElement.attr("aria-valuemax"));
    }


    @JDIAction(value = "Get '{name}' min limit")
    public int min() {
        return getInt(uiElement.attr("aria-valuemin"));
    }

    @JDIAction(value = "Get '{name}' mode value")
    public String mode() {
        return uiElement.attr("mode");
    }

    @JDIAction("Get '{name}' progress value")
    public int value() throws Exception {
        if (mode().equals(DETERMINATE.getMode()) || mode().equals(BUFFER.getMode())) {
            return getInt(uiElement.attr("aria-valuenow"));
        }
        throw new Exception("No exist 'value' attribute in this mode");
    }

    @JDIAction("Get '{name}' progress value")
    public String getValue() throws Exception {
        return value() + "";
    }

    @JDIAction("Get '{name}' progress buffer value ")
    public double bufferValue() throws Exception {
        UIElement bufferStyleClass = uiElement.find(".mat-progress-bar-buffer");
        String styleString = bufferStyleClass.attr("style");
        Pattern bufferValuePattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = bufferValuePattern.matcher(styleString);
        if (matcher.find()) {
            String bufferValue = matcher.group(1);
            return getDouble(bufferValue);
        }
        throw new Exception("No such expression in style string");
    }

    @Override
    public boolean isVisible() {
        if (isHidden())
            return false;
        Object isInView = uiElement.js().executeScript(
                "const rect = arguments[0].getBoundingClientRect();\n" +
                        "if (!rect) return false;\n" +
                        "const windowHeight = Math.min(window.innerHeight || document.documentElement.clientHeight);\n" +
                        "const windowWidth = Math.min(window.innerWidth || document.documentElement.clientWidth);\n" +
                        "const ratio = arguments[1];\n" +
                        "const reduceHeight = ratio*windowHeight;\n" +
                        "const reduceWidth = ratio*windowWidth\n" +
                        "if (rect.top < reduceHeight) return false;\n" +
                        "if (rect.left < reduceWidth) return false;\n" +
                        "if (rect.bottom > windowHeight-reduceHeight) return false;\n" +
                        "if (rect.right > windowWidth-reduceWidth) return false;\n" +
                        "return true;", uiElement.getWebElement(), 0.001);
        return (boolean) isInView;
    }

    @Override
    public ProgressBarAssert is() {
        return new ProgressBarAssert().set(this);
    }
}
