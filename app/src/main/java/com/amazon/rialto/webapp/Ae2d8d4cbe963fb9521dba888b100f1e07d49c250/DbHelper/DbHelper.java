package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelFavourite;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

import static com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant.arrayListFavourite;
import static com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant.arrayListMaster;
import static com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant.dbName;
import static com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant.dbTableName;
import static com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant.dbVersion;

public class DbHelper extends SQLiteAssetHelper {

    public DbHelper(Context context) {
        super(context, dbName, null, null, dbVersion);
    }

    public void SaveFavourite(ModelFavourite modelFavourite) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", modelFavourite.getId());
        contentValues.put("name", modelFavourite.getName());
        contentValues.put("detail", modelFavourite.getDetail());
        contentValues.put("image", modelFavourite.getImage());
        database.insert(dbTableName, null, contentValues);
        database.close();
        arrayListFavourite.add(modelFavourite);
    }


    public ArrayList<ModelFavourite> GetFavourites() {
        SQLiteDatabase database = getReadableDatabase();
        String query = "select * from " + dbTableName;
        Cursor cursor = database.rawQuery(query, null);

        ArrayList<ModelFavourite> arrayList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                ModelFavourite modelFavourite = new ModelFavourite();
                modelFavourite.setId(cursor.getString(cursor.getColumnIndex("id")));
                modelFavourite.setName(cursor.getString(cursor.getColumnIndex("name")));
                modelFavourite.setDetail(cursor.getString(cursor.getColumnIndex("detail")));
                modelFavourite.setImage(cursor.getString(cursor.getColumnIndex("image")));
                arrayList.add(modelFavourite);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return arrayList;
    }


    public void DeleteFavourite(String FavouriteId) {
        SQLiteDatabase database = getWritableDatabase();
        database.delete(dbTableName, "id" + "= '" + FavouriteId + "';", null);
        database.close();
        for (int i = 0; i < arrayListMaster.size(); i++)
            if (arrayListFavourite.get(i).getId().equals(FavouriteId)){
                arrayListFavourite.remove(i);
                break;
            }
    }


}
