package com.example.hussnain.islamicquotes.Database;

import android.provider.BaseColumns;

public class Tables {
    public static class Ayat implements BaseColumns{
        public static final String TABLE_NAME="ayat";
        public static final String COLUMN_TITLE="randomayat";
        public static final String COLUMN_TITLE1= "randomayyat";
    }
    public class NobleTable implements BaseColumns{

       public static final String TABLE_NAME="noble";
       public static final String COLUMN_QUOT="quot";
       public static final String COLUMN_WRITER="writer";

    }
    public class HadithTable implements BaseColumns{
        public static final String TABLE_NAME="hadith";
        public static final String COLUMN_HADITH="hadith";
        public static final String COLUMN_HWRITER="hadithwriter";
    }
}
