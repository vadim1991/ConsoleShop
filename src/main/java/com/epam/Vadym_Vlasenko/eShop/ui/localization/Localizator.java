package com.epam.Vadym_Vlasenko.eShop.ui.localization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Vadym_Vlasenko on 26.03.2015.
 */
public class Localizator {

    private Locale locale;
    private ResourceBundle resourceBundle;

    private static final String RESOURCE_NAME = "resource";
    private static final String DEFAULT_LOCALE = "EN";

    public Localizator() {
        locale = new Locale(DEFAULT_LOCALE);
        this.resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME, locale);
    }
    public Localizator(String language) {
        this.locale = new Locale(language);
        this.resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME, locale);
    }

    public Locale getLocale() {
        return locale;
    }

    public void setup(String language) {
        this.locale = new Locale(language);
        this.resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME, locale);
    }

    /**
     * Method that returns the localized value
     * @param key String value
     * @return {@String}
     */
    public String getValue(String key) {
        return (String) resourceBundle.getString(key);
    }

}
