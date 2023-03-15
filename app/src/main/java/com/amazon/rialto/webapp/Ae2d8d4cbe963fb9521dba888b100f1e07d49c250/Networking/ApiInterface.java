package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Networking;

// created by Milan Vadgama  :)

import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelDashBoardPlaylist;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelDashBoardVideos;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelRelatedVideos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("playlistItems?part=snippet&maxResults=50")
    Call<ModelDashBoardVideos> getVideos(@Query("key") String ApiKey, @Query("channelId") String channelId, @Query("playlistId") String playlistId);

    @GET("playlists?part=snippet&maxResults=50")
    Call<ModelDashBoardPlaylist> getPlaylist(@Query("key") String ApiKey, @Query("channelId") String channelId);

    @GET("search?part=snippet&type=video&maxResults=50")
    Call<ModelRelatedVideos> getRelatedVideos(@Query("key") String ApiKey, @Query("channelId") String channelId);

}