package net.unibave.objetivo_meta.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static net.unibave.objetivo_meta.model.DatabaseConstants.COLUMN_CREATED_AT;
import static net.unibave.objetivo_meta.model.DatabaseConstants.COLUMN_DATATAREFA;
import static net.unibave.objetivo_meta.model.DatabaseConstants.COLUMN_DONE;
import static net.unibave.objetivo_meta.model.DatabaseConstants.COLUMN_ID;
import static net.unibave.objetivo_meta.model.DatabaseConstants.COLUMN_NAME;
import static net.unibave.objetivo_meta.model.DatabaseConstants.DB_NAME;
import static net.unibave.objetivo_meta.model.DatabaseConstants.DB_VERSION;
import static net.unibave.objetivo_meta.model.DatabaseConstants.TABLE_TASK;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String createTableTask = "CREATE TABLE " + TABLE_TASK + " ( " +
                COLUMN_ID + " varchar PRIMARY KEY, " +
                COLUMN_CREATED_AT + " datetime DEFAULT CURRENT_TIMESTAMP, " +
                COLUMN_DATATAREFA + " datetime DEFAULT CURRENT_TIMESTAMP, " +
                COLUMN_NAME + " varchar, " +
                COLUMN_DONE + " integer)";

        db.execSQL(createTableTask);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        final String updateVersion2 = "";
        final String updateVersion3 = "";
        final String updateVersion4 = "";

        if (oldVersion == 1) {
            db.execSQL(updateVersion2);
            db.execSQL(updateVersion3);
            db.execSQL(updateVersion4);
        } else if (oldVersion == 2) {
            db.execSQL(updateVersion3);
            db.execSQL(updateVersion4);
        } else if (oldVersion == 3) {
            db.execSQL(updateVersion4);
        }

    }
}


