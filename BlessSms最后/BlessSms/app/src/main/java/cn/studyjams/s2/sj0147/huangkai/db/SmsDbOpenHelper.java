package cn.studyjams.s2.sj0147.huangkai.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.service.carrier.CarrierMessagingService;




public class SmsDbOpenHelper extends SQLiteOpenHelper {

    private  SmsDbOpenHelper(Context context) {
      //把名字版本号写死  不需要 名字版本号的构造函数了
        super(context.getApplicationContext(), "sms.db", null , 1);
    }
    //单例
    private static  SmsDbOpenHelper mHelper;
    public  static  SmsDbOpenHelper getInstance (Context context) {
        if (mHelper == null) {
            synchronized (SmsDbOpenHelper.class) {
                if (mHelper == null) {
                    mHelper = new SmsDbOpenHelper(context);
                }

            }

        }
        return mHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String sql = "create table"+ SendeMsg.TABLE_NAME+"("+
//                "_id integer primary key autoincrement ，"+
//                SendeMsg.COLUMU_DATE+"integer,"+
//                SendeMsg.COLUMU_FESTIVALNAME+"text,"+
//                SendeMsg.COLUMU_MSG+"text,"+
//                SendeMsg.COLUMU_NAMES+"text,"+
//                SendeMsg.COLUMU_NUMBERS+"text"+
//               ")";
        String CREATE_table = "create table tb_snded_msg ("
                + "_id integer primary key autoincrement, "
                + "date integer, "
                + "festivalName text, "
                + "msg text, "
                + "names text, "
                + "numbers text)";

    db.execSQL(CREATE_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
