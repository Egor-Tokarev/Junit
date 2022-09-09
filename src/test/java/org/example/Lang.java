package org.example;

public enum Lang {
   // English, Русский, Українська
    ENG("English"),  RU("Русский"),  UA("Українська");

    private final String desc;

    Lang(String desc) {
        this.desc = desc;
    }
    public  String getDesc() {
        return desc;
    }
    }