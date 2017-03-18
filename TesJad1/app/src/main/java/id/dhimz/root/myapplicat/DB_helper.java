package id.dhimz.root.myapplicat;

/**
 * Created by root on 13/12/16.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB_helper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DBtugas.db";
    private static final int DATABASE_VERSION = 2;

    public DB_helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table tugas (no integer primary key, nama_tugas text null, tgl date null, matkul text null, deadline date null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO tugas (no, nama_tugas, tgl, matkul, deadline) VALUES ('1001', 'Fathur', '1994-02-03', 'ARP', '1994-09-03');";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}