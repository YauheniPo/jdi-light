package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDIGridList {

  @MarkupLocator String gridList() default ".MuiGridListTile-tile";
  @MarkupLocator String gridTitle() default ".MuiGridListTileBar-title";
  @MarkupLocator String gridSubtitle() default ".MuiGridListTileBar-subtitle span";
  @MarkupLocator String gridActionButton() default "";

}
