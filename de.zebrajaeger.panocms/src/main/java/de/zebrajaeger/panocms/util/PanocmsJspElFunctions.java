package de.zebrajaeger.panocms.util;

import java.util.Locale;

/**
 * @author Lars Brandt on 17.01.2017
 */
public class PanocmsJspElFunctions {

    private PanocmsJspElFunctions() {
    }

    public static String getLocaleDisplayName(String locale) {
        Locale loc = Locale.forLanguageTag(locale);
        return loc.getDisplayName(loc);
    }
}
