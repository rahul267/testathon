package Enums;

public enum Browser {
    NONE("none"),
    CHROME("chrome"),
    FIREFOX("firefox"),
    INTERNET_EXPLORER("ie"),
    EDGE("edge"),
    SAFARI("safari"),
    HTMLUNIT("htmlunit"),
    PHANTOMJS("phantomjs");

    String type;

    Browser(String type) {
        this.type = type;
    }
}
