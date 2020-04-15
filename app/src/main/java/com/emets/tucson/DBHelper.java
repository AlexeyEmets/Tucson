package com.emets.tucson;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DBHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "tucsondb.db";
    private static final int DB_VERSION = 1;
    private static String DB_PATH = "";

    private static final String TABLE_PAGES = "pages";
    private static final String COLUMN_CHAPTER = "chapter";
    private static final String COLUMN_ITEM = "item";
    private static final String COLUMN_HTML = "html_text";

    private SQLiteDatabase db;
    private final Context context;
    private boolean needUpdate = false;


    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if (android.os.Build.VERSION.SDK_INT >= 17)
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.context = context;

        copyDataBase();

        this.getReadableDatabase();
    }

    public void updateDataBase() throws IOException {
        if (needUpdate) {
            File dbFile = new File(DB_PATH + DB_NAME);
            if (dbFile.exists())
                dbFile.delete();

            copyDataBase();

            needUpdate = false;
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDBFile() throws IOException {
        InputStream mInput = context.getAssets().open(DB_NAME);
        //InputStream mInput = mContext.getResources().openRawResource(R.raw.info);
        OutputStream mOutput = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

//    public boolean openDataBase() throws SQLException {
//        db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.CREATE_IF_NECESSARY);
//        return db != null;
//    }

    @Override
    public synchronized void close() {
        if (db != null)
            db.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String script = "CREATE TABLE " + TABLE_PAGES + "("
//                + COLUMN_CHAPTER + " INTEGER," + COLUMN_ITEM + " INTEGER,"
//                + COLUMN_HTML + " TEXT" + ")";
//        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int newVersion, int oldVersion) {
        if (newVersion > oldVersion)
            needUpdate = true;
    }

//    public void addPage() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_CHAPTER, 1);
//        values.put(COLUMN_ITEM, 0);
//        values.put(COLUMN_HTML, "сработало");
//        db.insert(TABLE_PAGES, null, values);
//        db.close();
//    }

    public String getPage(String chapter, int item) {
        String htmlString;
        db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PAGES,
                                 new String[] {COLUMN_HTML},
                        COLUMN_CHAPTER + "= ? AND " + COLUMN_ITEM + "=?",
                                 new String[]{chapter, String.valueOf(item)},
                        null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            htmlString = cursor.getString(cursor.getColumnIndex(COLUMN_HTML));
        } else {
            htmlString = "страница не найдена";
        }
        cursor.close();
        db.close();
        return htmlString;
    }
}
