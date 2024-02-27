package dev.enhance.springdemo;

public class EnhanceSsrWasmResponse {
    private String document;
    private String body;
    private String styles;

    public EnhanceSsrWasmResponse(String document, String body, String styles) {
        super();
        this.document = document;
        this.body = body;
        this.styles = styles;
     }
     public String getDocument() {
        return document;
     }
     public void setDocument(String document) {
        this.document = document;
     }
     public String getBody() {
        return body;
     }
     public void setBody(String body) {
        this.body = body;
     }
     public String getStyles() {
        return styles;
     }
     public void setStyles(String styles) {
        this.styles = styles;
     }
}
