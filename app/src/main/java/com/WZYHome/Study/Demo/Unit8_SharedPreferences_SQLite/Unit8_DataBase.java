package com.WZYHome.Study.Demo.Unit8_SharedPreferences_SQLite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit8_SharedPreferences_SQLite.Unit8_DataBase">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit8_DataBase extends Activity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit14_database);
    /*    String path=getFilesDir().getAbsolutePath()+"/database5.db";
        db=SQLiteDatabase.openOrCreateDatabase(path,null);*/
    //采用SQLiteOpenHelper类创建数据库
        MyOpenHelper MyOpenHelper=new MyOpenHelper(getApplicationContext(),"database.db",null,2);
        db=MyOpenHelper.getWritableDatabase();
        Button Select_btn= (Button) findViewById(R.id.select_btn);
        Button update_btn= (Button) findViewById(R.id.update_btn);
        findViewById(R.id.delete_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteData(db);
            }
        });
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateData(db);
            }
        });
        Select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    selectData(db);
                }
                catch(SQLiteException se){
                    /*createData(db);*/
                    selectData(db);
                }

            }
        });
       Button btn_insert= (Button) findViewById(R.id.btn_insert);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    insertData(db,"c++","wangzhiyong","computer");
                }
                catch(SQLiteException se){
                  /*  createData(db);*/
                    insertData(db,"java","wangzhiyong","computer");
                }


            }
        });
    }
    private  void DeleteData(SQLiteDatabase db){
        int id=6;
        String[] whereArgs={""+id};
        db.delete("books","id=?",whereArgs);
    }
    private  void  UpdateData(SQLiteDatabase db){
        int id=6;
        ContentValues contentValues=new ContentValues();
        contentValues.put("bookName","android");
        String[] whereArgs={""+id};
         db.update("books",contentValues,"id=?",whereArgs);
    }
    private  void selectData(SQLiteDatabase db){
        /*Cursor cursor=db.rawQuery("select *from books;",null);*/
        int id=6;//这个id可以设计成用户自己填写需要查找的列;
        String[] col={"id","bookName","author","category"};
        String[] TongPeiFu={""+id};//把后面的TongPeiFu数组填到前面的通配符里面
        Cursor cursor=db.query("books",col,"id=?",TongPeiFu,null,null,null);
        StringBuffer ret=new StringBuffer();
        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
              int count=cursor.getColumnCount();
            for(int i=0;i<count;i++){
                ret.append(cursor.getString(i)+": ");
            }
            ret.append("\n");
        }
        TextView textView39= (TextView) findViewById(R.id.textView39);
        textView39.setText(ret);

    }

    private void insertData(SQLiteDatabase db,String bookName,String author,String category){
        //SQLLiteDataBase命令行插入数据
        /*final String INSERT_CMD="insert into books values(null,?, ?, ?);";//引用占位符;
        Object[] bindArgs={bookName,author,category};
        db.execSQL(INSERT_CMD,bindArgs);*/
        ContentValues values=new ContentValues();
        values.put("bookName",bookName);
        values.put("author",author);
        values.put("category",category);
        db.insert("books",null,values);
    }
    /* private  void createData(SQLiteDatabase db){

         db.execSQL("create table books(id integer primary key,bookName string,author string,category string);");

     }*/
     class MyOpenHelper extends SQLiteOpenHelper {
         public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
             super(context, name, factory, version);
         }

         public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
             super(context, name, factory, version, errorHandler);
         }

         @Override
         public void onCreate(SQLiteDatabase db) {
             db.execSQL("create table books(id integer primary key,bookName string,author string,category string);");
             Toast.makeText(getApplicationContext(),"if isn't exsit database ,then create dababase",Toast.LENGTH_LONG).show();
         }

         @Override
         public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
             Toast.makeText(getApplicationContext(),"upgrade old v:"+oldVersion+"new v:"+newVersion,Toast.LENGTH_LONG).show();

         }
     }

}
