package com.epam.jdi.light.mobile.elements.init;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.elements.init.InitActions.JDI_ANNOTATIONS;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.elements.init.rules.AnnotationRule.aRule;
import static com.epam.jdi.light.mobile.elements.pageobjects.annotations.WebAnnotationsUtil.mobileFindByToBy;
import static com.epam.jdi.light.settings.WebSettings.TEST_GROUP;
import static com.epam.jdi.light.settings.WebSettings.init;
import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.pairs.Pair.$;

public class PageFactory {

    public static void initMobileSite(Class<?> site) {
        JDI_ANNOTATIONS.add($("MobileFindByUI", aRule(MobileFindBy.class, (e, a, f)-> {
            MobileFindBy[] jmfindbys = f.getAnnotationsByType(MobileFindBy.class);
            if (jmfindbys.length > 0 && any(jmfindbys, j -> j.group().equals("") || j.group().equals(TEST_GROUP)))
                e.setLocator(mobileFindByToBy(first(jmfindbys, j -> j.group().equals(TEST_GROUP))));
        })));
        init();
        initSite(site, DRIVER_NAME);
    }
}
