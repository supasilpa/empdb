package com.sup.administrator.employeedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/29/2019.
 */
public class dbemp extends SQLiteOpenHelper {
    public static final String dbname="empdb.db";
    public static final String tablename="employee";
    public static final String col1="id";
    public static final String col2="employee";
    public static final String col3="name";
    public static final String col4="mobile";
    public static final String col5="email";
    public static final String col6="desig";
    public static final String col7="salary";
    public static final String col8="cn";

    public dbemp(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table "+tablename+"("+col1+ " integer primary key autoincrement, "+col2+ " text, "+col3+ " text, "+col4+ " text, "+col5+ " text, "+col6+ " text, "+col7+ " text, "+col8+ " text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
String query="drop table if exists "+tablename;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }
    public boolean insertemp(String code,String name,String mobile,String email,String des,String sal,String cn)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(col2,code);
        cv.put(col3,name);
        cv.put(col4,mobile);
        cv.put(col5,email);
        cv.put(col6,des);
        cv.put(col7,sal);
        cv.put(col8,cn);
        long status=sqLiteDatabase.insert(tablename,null,cv);
        if(status==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }
}
