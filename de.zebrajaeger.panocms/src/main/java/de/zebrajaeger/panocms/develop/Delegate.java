package de.zebrajaeger.panocms.develop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lars Brandt, Silpion IT Solutions GmbH
 */
public class Delegate {

    public static final String REMOTE_CSS_PATH = "http://localhost:3000/assets/css/";
    public static final String REMOTE_JS_PATH = "http://localhost:3000/assets/js/";

    private static final Delegate INSTANCE = new Delegate();

    public static Delegate getInstance() {
        return INSTANCE;
    }

    private Map<String, String> delegates = new HashMap<>();

    private Delegate() {
        add("app.css", REMOTE_CSS_PATH);
        add("app.css.map", REMOTE_CSS_PATH);
        add("bower.css", REMOTE_CSS_PATH);
        add("vendor.css", REMOTE_CSS_PATH);
        add("app.css", REMOTE_CSS_PATH);
        add("vendor.css.map", REMOTE_CSS_PATH);

        add("app.js", REMOTE_JS_PATH);
        add("app.js", REMOTE_JS_PATH);

    }

    private void add(String fileName, String urlFolder) {
        delegates.put(fileName, urlFolder + fileName);
    }

    public String get(String fileName) {
        return delegates.get(fileName);
    }
}
