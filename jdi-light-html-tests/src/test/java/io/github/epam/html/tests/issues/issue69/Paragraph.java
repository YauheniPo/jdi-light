package io.github.epam.html.tests.issues.issue69;

import com.epam.jdi.mobile.elements.composite.Section;
import com.epam.jdi.mobile.ui.html.elements.common.Button;

import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

public class Paragraph extends Section {
    public Button paragraph, paragraph2, paragraph3;

    @Override
    public String toString() {
        return print(asList(paragraph.getText(),
                paragraph2.getText(),
                paragraph3.getText()));
    }
}