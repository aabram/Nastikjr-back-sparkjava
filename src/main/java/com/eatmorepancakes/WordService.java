package com.eatmorepancakes;

import com.eatmorepancakes.db.DbLookup;
import com.eatmorepancakes.logging.LogEntry;

import java.sql.Timestamp;
import java.util.List;

import static com.eatmorepancakes.logging.LogToFile.logToDisk;

public class WordService {

    public static List<Word> getExactWordEN(String en) {
        var result = DbLookup.searchEN(en.strip().toLowerCase(), true);
        boolean found = result.size() > 0;
        LogEntry log = new LogEntry ("EN", en, found);
        logToDisk(log);
        System.out.println(en + "-> EN exact -> " + result.size());
        return result;
    }

    public static List<Word> getWordEN(String en) {
        var result = DbLookup.searchEN(en.strip().toLowerCase(), false);
        System.out.println(en + " -> EN partial -> " + result.size());
        return result;
    }

    public static List<Word> getExactWordET(String et) {
        var result = DbLookup.searchET(et.strip().toLowerCase(), true);
        boolean found = result.size() > 0;
        LogEntry log = new LogEntry("ET", et, found);
        logToDisk(log);
        System.out.println(et + " -> ET exact -> " + result.size());
        return result;
    }

    public static List<Word> getWordET(String et) {
        var result = DbLookup.searchET(et.strip().toLowerCase(), false);
        System.out.println(et + " -> ET partial -> " + result.size());
        return result;
    }

}
