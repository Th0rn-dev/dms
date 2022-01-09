package dms;

import java.util.Map;

public class Document {

    private final Map<String, String> attributes;

    // пакетныЙ конструктор, т.е. создание данного типа доступно только в пакете dms
    Document(final Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(final String attributeName) {
        return attributes.get(attributeName);
    }
}
