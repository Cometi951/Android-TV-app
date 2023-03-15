package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Activity.ActivityDetail;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Activity.ActivityVideoPlayer;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelFavourite;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelMaster;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelRelatedVideos;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Networking.Api;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.R;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Utility.SpacesItemDecoration;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant.YoutubeApiKey;
import static com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant.arrayListFavourite;
import static com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant.channelId;
import static com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant.dbHelper;

public class AdapterDetailMaster extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ModelMaster.playList.Videos Videos;
    OnFocusChange onFocusChange;
    private final int VIEW_TYPE_HEADER = 0;
    private final int VIEW_TYPE_Master = 1;
    Boolean isFavourite = false;

    public AdapterDetailMaster(Context context, ModelMaster.playList.Videos Videos, OnFocusChange onFocusChange) {
        this.context = context;
        this.Videos = Videos;
        this.onFocusChange = onFocusChange;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        if (position == VIEW_TYPE_HEADER) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_detail_header, null);
            return new HeaderHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_playlist, null);
            return new MasterHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderHolder) {
            HeaderHolder headerHolder = (HeaderHolder) holder;
            //if (position == 0) {
           /* new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {*/
                    //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    //layoutParams.setMargins(Utility.dpToPx(50, context), Utility.dpToPx(150, context), Utility.dpToPx(50, context), 0);
                    //headerHolder.Linear_item_detail_header.setPadding(Utility.dpToPx(50, context), Utility.dpToPx(150, context), Utility.dpToPx(50, context), 0);
               /* }
            }, 100);*/
            //}
            Picasso.with(context).load(Videos.getVideoImage()).into(headerHolder.img_detail_header_video);
            headerHolder.text_detail_header_name.setText(Videos.getVideoTitle());
            headerHolder.text_detail_header_detail.setText(Videos.getVideoDetail());
            headerHolder.btn_detail_header_watch_now.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent youtube = new Intent(context, ActivityVideoPlayer.class);
                    youtube.putExtra("videoId", Videos.getVideoId());
                    youtube.putExtra("videoImage", Videos.getVideoImage());
                    youtube.putExtra("videoTitle", Videos.getVideoTitle());
                    context.startActivity(youtube);
                }
            });
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < arrayListFavourite.size(); i++) {
                        if (arrayListFavourite.get(i).getId().equals(Videos.getVideoId())) {
                            isFavourite = true;
                            headerHolder.btn_detail_header_watch_list.setText("Remove\nWATCHLIST");
                            break;
                        }
                    }
                }
            }, 200);


            headerHolder.btn_detail_header_watch_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isFavourite) {
                        dbHelper.DeleteFavourite(Videos.getVideoId());
                        isFavourite = false;
                        headerHolder.btn_detail_header_watch_list.setText("Add to\nWATCHLIST");
                        Toast.makeText(context, "Removed favourite Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        ModelFavourite modelFavourite = new ModelFavourite();
                        modelFavourite.setId(Videos.getVideoId());
                        modelFavourite.setName(Videos.getVideoTitle());
                        modelFavourite.setDetail(Videos.getVideoDetail());
                        modelFavourite.setImage(Videos.getVideoImage());
                        dbHelper.SaveFavourite(modelFavourite);
                        isFavourite = true;
                        headerHolder.btn_detail_header_watch_list.setText("Remove\nWATCHLIST");
                        Toast.makeText(context, "Add favourite Successful", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        } else {
            MasterHolder masterHolder = (MasterHolder) holder;
            masterHolder.text_playlist_name.setText("Related Videos");
            /*new Handler().post(new Runnable() {
                @Override
                public void run() {*/
                    //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    //layoutParams.setMargins(0, Utility.dpToPx(70, context), 0, Utility.dpToPx(100, context));
                    //masterHolder.itemView.setLayoutParams(layoutParams);
                /*}
            });*/
            getVideoApiCall(masterHolder);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static class HeaderHolder extends RecyclerView.ViewHolder {

        ImageView img_detail_header_video;
        TextView text_detail_header_name, text_detail_header_detail;
        Button btn_detail_header_watch_now, btn_detail_header_watch_list;
        LinearLayout Linear_item_detail_header;

        public HeaderHolder(@NonNull View v) {
            super(v);
            text_detail_header_name = itemView.findViewById(R.id.text_detail_header_name);
            text_detail_header_detail = itemView.findViewById(R.id.text_detail_header_detail);
            img_detail_header_video = itemView.findViewById(R.id.img_detail_header_video);
            btn_detail_header_watch_now = itemView.findViewById(R.id.btn_detail_header_watch_now);
            btn_detail_header_watch_list = itemView.findViewById(R.id.btn_detail_header_watch_list);
            Linear_item_detail_header = itemView.findViewById(R.id.Linear_item_detail_header);

        }
    }

    public static class MasterHolder extends RecyclerView.ViewHolder {
        HorizontalGridView rvChild;
        TextView text_playlist_name;

        public MasterHolder(@NonNull View v) {
            super(v);
            text_playlist_name = itemView.findViewById(R.id.text_playlist_name);
            rvChild = itemView.findViewById(R.id.rvChild);
            rvChild.setHasFixedSize(true);
        }
    }

    public interface OnFocusChange {
        void FocusListener(ModelMaster.playList.Videos videoData);
    }

    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_HEADER;
        } else {
            return VIEW_TYPE_Master;
        }
    }

    private void getVideoApiCall(final MasterHolder masterHolder) {
        Call<ModelRelatedVideos> callModelDashboard = Api.CreateApi(context).getRelatedVideos(YoutubeApiKey, channelId);
        callModelDashboard.enqueue(new Callback<ModelRelatedVideos>() {
            @Override
            public void onResponse(Call<ModelRelatedVideos> call, Response<ModelRelatedVideos> response) {
                //ModelMaster modelMaster = new ModelMaster();
                //ModelMaster.playList playList = new ModelMaster.playList();
                //ArrayList<ModelMaster.playList> arrayListPlayList = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null && response.errorBody() == null) {
                    ArrayList<ModelMaster.playList.Videos> arrayListPlayListVideos = new ArrayList<>();
                    generateRandomString(1);
                    if (response.body().getItems() != null)
                        for (int i = 0; i < response.body().getItems().size(); i++) {
                            ModelMaster.playList.Videos videos = new ModelMaster.playList.Videos();
                            videos.setVideoId(response.body().getItems().get(i).getId().getVideoId());
                            if (response.body().getItems().get(i).getSnippet().getThumbnails().getHigh() != null)
                                videos.setVideoImage(response.body().getItems().get(i).getSnippet().getThumbnails().getHigh().getUrl());
                            videos.setVideoTitle(response.body().getItems().get(i).getSnippet().getTitle());
                            videos.setVideoDetail(response.body().getItems().get(i).getSnippet().getDescription());
                            arrayListPlayListVideos.add(videos);
                        }
                    //playList.setPlayListId(playListId);
                    //playList.setPlayListTile(playListTitle);
                    //playList.setVideos(arrayListPlayListVideos);
                    //arrayListPlayList.add(playList);
                    //modelMaster.setPlayLists(arrayListPlayList);
                    //arrayListMaster.add(modelMaster);
                    //adapterOnDemandMaster.notifyItemInserted(arrayListMaster.size() - 1);
                    //adapterOnDemandMaster.notifyDataSetChanged();
                    AdapterDashBoardVideo adapterDashBoardVideo = new AdapterDashBoardVideo(context, -1, arrayListPlayListVideos, new AdapterDashBoardVideo.FocusChangeListerChild() {
                        @Override
                        public void onFocusChanged(ModelMaster.playList.Videos videoData) {
                            //onFocusChange.FocusListener(videoData);
                        }

                        @Override
                        public void Clicked(ModelMaster.playList.Videos videoData) {
                            Intent intent = new Intent(context, ActivityDetail.class);
                            Bundle b = new Bundle();
                            b.putSerializable("video", videoData);
                            intent.putExtras(b);
                            context.startActivity(intent);
                        }
                    });
                    masterHolder.rvChild.setAdapter(adapterDashBoardVideo);
                    int space = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics());
                    masterHolder.rvChild.addItemDecoration(new SpacesItemDecoration(space));
                }
            }

            @Override
            public void onFailure(Call<ModelRelatedVideos> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private static String generateRandomString(int sizeOfRandomString) {
        String ALLOWED_CHARACTERS = "123456789";

        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i = 0; i < sizeOfRandomString; ++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }

}