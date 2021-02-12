package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Tooltip;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TooltipAssert extends UIAssert<TooltipAssert, Tooltip> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public TooltipAssert text(Matcher<String> condition) {
        jdiAssert(element().getValue(), condition);
        return this;
    }

    public TooltipAssert text(String text) {
        return text(Matchers.is(text));
    }

    @JDIAction("Assert that '{name}' text is visible")
    public TooltipAssert visible() {
        jdiAssert(element().isVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text is interactive")
    public TooltipAssert interactive() {
        jdiAssert(element().isInteractive(), Matchers.is(true));
        return this;
    }

}