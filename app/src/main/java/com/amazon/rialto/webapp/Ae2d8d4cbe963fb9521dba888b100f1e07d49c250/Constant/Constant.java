package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant;

import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.DbHelper.DbHelper;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelFavourite;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelMaster;

import java.util.ArrayList;

public class Constant {

 public static final String BaseURL = "https://www.googleapis.com/youtube/v3/";
 public static final String channelId = "UCQhBGEYrCGNOJ27HWiJcb_g";
 public static String YoutubeApiKey = "AIzaSyDfx7Yut-pazd3HaAuY0Xl1b1JFYqku4-0";


 public static final int dbVersion = 1;
 public static final String dbName = "Favourite.db";
 public static final String dbTableName = "Favourite";
 public static DbHelper dbHelper;
 public static ArrayList<ModelFavourite> arrayListFavourite;


 public static ArrayList<ModelMaster> arrayListMaster;
 public static Boolean isFirstTime = true;
 public static Boolean showCategory = true;

}