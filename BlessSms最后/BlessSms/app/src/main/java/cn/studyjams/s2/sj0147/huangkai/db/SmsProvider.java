package cn.studyjams.s2.sj0147.huangkai.db;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Switch;

import java.util.IllegalFormatCodePointException;
import java.util.IllegalFormatException;

import cn.studyjams.s2.sj0147.huangkai.bean.SendeMsg;

import static android.R.attr.breadCrumbShortTitle;
import static android.R.attr.id;


////提供数据（内容）的就叫Provider，Resovler提供接口对这个内容进行解读
public class SmsProvider extends ContentProvider {
    private static  final  String AUTHORITY  = "cn.studyjams.s2.sj0147.huangkai.provider";
    public static final Uri URI_SMS_ALL = Uri.parse("content://"+AUTHORITY+"/tb_snded_msg/");

    private static UriMatcher matcher;
    private static  final  int SMS_ALL=0;
    private static  final  int SMS_ONE=1;


    static {
        //匹配Uri路径全部给注册上,初始化：
        matcher = new UriMatcher(UriMatcher.NO_MATCH);

        matcher.addURI(AUTHORITY,"tb_snded_msg",SMS_ALL);;//添加需要匹配uri，如果匹配就会返回匹配码  查tb_snded_msg表中全部数据
        matcher.addURI(AUTHORITY,"tb_snded_msg/#",SMS_ONE);;//#号为通配符,查单条数据
    }
    private SmsDbOpenHelper mHelper;
    private SQLiteDatabase mDb;
    @Override
    public boolean onCreate() {
       mHelper = SmsDbOpenHelper.getInstance(getContext());
     return true;
    }
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        //使用uriMatcher.match(uri)方法对输入的Uri进行匹配，如果匹配就返回匹配码，  看到操作哪一张表
        int match = matcher.match(uri);
        Uri noteUri = null;
        mDb = mHelper.getWritableDatabase();
        switch (match) {
            case  SMS_ALL: {
                long rowId = mDb.insert(SendeMsg.TABLE_NAME, null, values);//给每个数据创造个id
                 noteUri = ContentUris.withAppendedId(uri, rowId);//组成新的uri
//            Uri noteUri = Uri.parse("content://" + AUTHORITY + "/tb_snded_msg/" +
//                    rowId);
                break;
            }
        }
        getContext().getContentResolver().notifyChange(URI_SMS_ALL,null);
        
        
                return noteUri;
        }


    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int match = matcher.match(uri);
        Cursor c=null;
        switch (match){

//            case  SMS_ALL: {
//
////                c = mDb.query(SendeMsg.TABLE_NAME, projection, selection, selectionArgs,
////                        null, null, sortOrder);
//                break;
//            }
//             case  SMS_ONE: {
//                long id = ContentUris.parseId(uri);//这个方法负责把content URI /后边的id解析出来
//               //String Id = uri.getPathSegments().get(1);
//               selection = "_id = ?";
//               selectionArgs = new String[]{String.valueOf(id)};
//           //随时观察数据是否有变动
//                break;
//           }
//             mDb = mHelper.getReadableDatabase();
//             c = mDb.query(SendeMsg.TABLE_NAME, projection, selection, selectionArgs,
//                     null, null, sortOrder);
//             c.setNotificationUri(getContext().getContentResolver(),URI_SMS_ALL);



            case  SMS_ALL: {

                mDb = mHelper.getReadableDatabase();
                c = mDb.query(SendeMsg.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(getContext().getContentResolver(),URI_SMS_ALL);
                break;
            }
//            case  SMS_ONE: {
//                long id = ContentUris.parseId(uri);//这个方法负责把content URI /后边的id解析出来
//                //String Id = uri.getPathSegments().get(1);
//                selection = "_id = ?";
//                selectionArgs = new String[]{String.valueOf(id)};
//                //随时观察数据是否有变动
//                break;
//            }
            default:
                break;

        }





        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable


    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        mDb = mHelper.getWritableDatabase();
        int deletedRows = 0;
        int match = matcher.match(uri);
       switch(match) {
           case SMS_ALL:
               deletedRows = mDb.delete(SendeMsg.TABLE_NAME, selection,
                       selectionArgs);
               break;
           case SMS_ONE:
               String Id = uri.getPathSegments().get(1);
               deletedRows = mDb.delete(SendeMsg.TABLE_NAME, "_id = ?", new String[] {Id});
               break;
           default:
               break;
       }

        getContext().getContentResolver().notifyChange(URI_SMS_ALL, null);
        return deletedRows;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
