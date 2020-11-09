package com.eatmorepancakes;

public class Word {
    private final int id;
    private final String en;
    private final String et;

    public Word(int id, String en, String et) {
        this.id = id;
        this.en = en;
        this.et = et;
    }

    public int getId() {
        return id;
    }

    public String getEn() {
        return en;
    }

    public String getEt() {
        return et;
    }
/*
    Currently comparison is not used at all
    Duplicates are weeded out with SQL query already
    Functions below are not needed at this time
    */

/*    // We don't want to compare ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Word word = (Word) o;

        if (en != null
                ? !en.equals(word.en)
                : word.en != null)
            return false;

        return et != null
                ? et.equals(word.et)
                : word.et == null;
    }

    @Override
    public int hashCode() {
        int result = en != null ? en.hashCode() : 0;
        result = 31 * result + (et != null ? et.hashCode() : 0);
        return result;
    }*/
}
