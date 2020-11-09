package com.eatmorepancakes.logging;

import java.sql.Timestamp;

public class LogEntry {
    private final Timestamp time;
    private final String language;
    private final String word;
    private final boolean found;

    public LogEntry(String language, String word, boolean found) {
        this.time = new Timestamp(System.currentTimeMillis());
        this.language = language;
        this.word = word;
        this.found = found;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getLanguage() {
        return language;
    }

    public String getWord() {
        return word;
    }

    public boolean isFound() {
        return found;
    }
}
