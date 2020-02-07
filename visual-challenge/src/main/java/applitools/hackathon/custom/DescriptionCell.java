package applitools.hackathon.custom;

import com.epam.jdi.mobile.elements.composite.Section;
import com.epam.jdi.mobile.elements.interfaces.base.HasValue;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.mobile.ui.html.elements.common.Icon;
import com.epam.jdi.mobile.ui.html.elements.common.Text;

import static java.lang.String.format;

public class DescriptionCell extends Section implements HasValue {
    @UI("img") Icon icon;
    @UI("span") Text companyName;
    public String getValue() {
        return format("icon=%s;companyName=%s", icon.fileName(), companyName.getText());
    }
}
