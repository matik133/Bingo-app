package pl.kwiateksoft.pilkarskiebingo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final String database_name = "Baza tekstów";
    public static final String table_name = "Teksty";

    public Database(Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + table_name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, AUTOR TEXT, SENTENCE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }

    public boolean instertData (String autor, String tekst){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("AUTOR", autor);
        cv.put("SENTENCE", tekst);
        if (db.insert(table_name, null, cv)==-1){
            return false;
        }
        else return true;
    }

    public SQLiteCursor getData (){
        SQLiteDatabase db = this.getReadableDatabase();
        SQLiteCursor kursor = (SQLiteCursor) db.rawQuery("SELECT * FROM " + table_name, null);
        return kursor;
    }
}
