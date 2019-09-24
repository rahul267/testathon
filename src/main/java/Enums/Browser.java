package Enums;

public enum Browser {
    NONE("none"),
    CHROME("chrome"),
    CHROMEGRID("chrome"),
    FIREFOX("firefox"),
    INTERNET_EXPLORER("ie"),
    EDGE("edge"),
    SAFARI("safari"),
    HTMLUNIT("htmlunit"),
    PHANTOMJS("phantomjs"),
    MOBILECHROME("mobileChrome");

    String type;

    Browser(String type) {
        this.type = type;
    }
}
