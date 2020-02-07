package applitools.hackathon.custom;

import com.epam.jdi.mobile.elements.composite.Section;
import com.epam.jdi.mobile.elements.interfaces.base.HasValue;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.mobile.ui.html.elements.common.Text;

import static java.lang.String.format;

public class DateCell extends Section implements HasValue {
    @UI("//span[1]") Text day;
    @UI("//span[2]") Text time;
    public String getValue() {
        return format("day=%s;time=%s", day.getText(), time.getText());
    }
}
