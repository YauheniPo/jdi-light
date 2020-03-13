package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.*;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.asserts.CheckboxAssert;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Checkbox extends UIBaseElement<CheckboxAssert>
    implements HasLabel, SetValue, HasClick, HasCheck, IsText {
    // region Actions
    public void check(String value) {
        if (value.equalsIgnoreCase("true") || value.equals("1"))
            check();
        else uncheck();
    }
    @JDIAction("Get '{name}' text") @Override
    public String getText() {
        return labelText();
    }
    @JDIAction("Check '{name}'")
    public void check() {
        if (!isSelected())
            click();
    }
    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if (isSelected())
            click();
    }
    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
        return uiElement.isSelected();
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        check(value);
    }
    public String getValue() {
        return isSelected()+"";
    }
    // endregion

    // region Extend assertions
    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
    // endregion
}
