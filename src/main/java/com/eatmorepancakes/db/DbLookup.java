package com.eatmorepancakes.db;

import com.eatmorepancakes.Word;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbLookup {

    // TODO
    // - Refactor to single method if feasible

    public static List<Word> searchEN(String word, boolean exact) {
        final String exactSQL = "SELECT * FROM en_et WHERE word_en=? COLLATE NOCASE ORDER BY word_en";
        final String partialSQL = "SELECT * FROM en_et" +
                " WHERE word_en LIKE ? COLLATE NOCASE" +
                " EXCEPT" +
                " SELECT * FROM en_et" +
                " WHERE word_en=? COLLATE NOCASE" +
                " ORDER BY word_en";

        String SQL = exact ? exactSQL : partialSQL;
        String searchWord = exact ? word : '%' + word + '%';
        Connection connection;
        List<Word> result = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:nastik.db");

            PreparedStatement pstmt = connection.prepareStatement(SQL);
            if (!exact) {
                pstmt.setString(1, searchWord);
                pstmt.setString(2, word);
            } else {
                pstmt.setString(1, searchWord);
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String en = rs.getString("word_en");
                String et = rs.getString("word_et");
                result.add(new Word(id, en, et));
            }

            rs.close();
            pstmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return result;
    }

    public static List<Word> searchET(String word, boolean exact) {
        final String exactSQL = "SELECT * FROM et_en WHERE word_et=? COLLATE NOCASE ORDER BY word_et";
        final String partialSQL = "SELECT * FROM et_en" +
                " WHERE word_et LIKE ? COLLATE NOCASE" +
                " EXCEPT" +
                " SELECT * FROM et_en" +
                " WHERE word_et=? COLLATE NOCASE" +
                " ORDER BY word_et";

        String SQL = exact ? exactSQL : partialSQL;
        String searchWord = exact ? word : '%' + word + '%';
        Connection connection;
        List<Word> result = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:nastik.db");

            PreparedStatement pstmt = connection.prepareStatement(SQL);
            if (!exact) {
                pstmt.setString(1, searchWord);
                pstmt.setString(2, word);
            } else {
                pstmt.setString(1, searchWord);
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String en = rs.getString("word_en");
                String et = rs.getString("word_et");
                result.add(new Word(id, en, et));
            }

            rs.close();
            pstmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return result;
    }
}
