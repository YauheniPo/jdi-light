package io.github.com.custom;

import com.epam.jdi.mobile.elements.composite.Section;
import com.epam.jdi.mobile.elements.interfaces.base.HasValue;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.mobile.ui.html.elements.common.Checkbox;
import com.epam.jdi.mobile.ui.html.elements.common.Image;
import com.epam.jdi.mobile.ui.html.elements.common.Text;

public class Avatar extends Section implements HasValue {
    @UI("img") public Image image;
    @UI(".user-descr>span")public Text description;
    @UI("input[type=checkbox]")public Checkbox vip;

    @Override
    public String getValue() {
        return description.getText() + ":" +
            (vip.isSelected() ? "VIP" : "Dude");
    }
}
