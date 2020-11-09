package com.eatmorepancakes.logging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogToFile {

    public static void logToDisk(LogEntry log) {
        String separator = "\t";
        String newline = "\n";
        StringBuilder line = new StringBuilder();

        line.append(log.getTime().toString()).append(separator);
        line.append(log.getLanguage()).append(separator);
        line.append(log.getWord()).append(separator);
        line.append(log.isFound()).append(newline);
        try {
            Files.write(
                    Paths.get("nastik_log.tsv"),
                    line.toString().getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
