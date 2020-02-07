package org.mytests.uiobjects.example.knection;

import com.epam.jdi.mobile.elements.composite.Section;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Title;
import com.epam.jdi.mobile.ui.html.elements.common.Link;
import com.epam.jdi.mobile.ui.html.elements.common.Text;

public class ProjectRow extends Section {
    @Title
    public Link name;
    public Text projectCode, apiId, lastUpdated;
    public Link actions;
}
