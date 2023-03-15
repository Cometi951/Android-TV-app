package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Activity;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static android.view.ViewGroup.FOCUS_BLOCK_DESCENDANTS;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Adapter.AdapterOnDemandMaster;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Adapter.The_Slide_items_Pager_Adapter;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.DbHelper.DbHelper;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelDashBoardPlaylist;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelDashBoardVideos;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelMaster;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Networking.Api;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.R;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Utility.Utility;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.databinding.ActivityDashboardBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityDashBoard extends AppCompatActivity {

    ImageView image_favourite, img_dashboard;
    CustomVerticalGrid verticalGrid_dashboard;
    View item_detail_banner_view, slider_view, header_row_card;
    LinearLayout homepage_without_slider;
    TextView text_dashboard_title, text_dashboard_detail, text_no_data;
    AdapterOnDemandMaster adapterOnDemandMaster;
    ValueAnimator anim;
    int heightForDetailsViewAnimation;
    int heightForRow =-999;
    ArrayList<Integer> listItems = new ArrayList<>();
    DisplayMetrics displayMetrics = new DisplayMetrics();
    Button btn1;
    private ViewPager page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.databinding.ActivityDashboardBinding binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        text_no_data = findViewById(R.id.text_no_data);
        if (Utility.NetworkAvailable(this)) {
            SharedPreferences sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

            long CheckMilli = Calendar.getInstance().getTimeInMillis() - sSharedPreferences.getLong("MilliSec", 0);
            if (true) {
                FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
                firebaseRemoteConfig.fetch(100).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        firebaseRemoteConfig.activateFetched();
                        if (!firebaseRemoteConfig.getBoolean("AffinityEnable")) {
                            text_no_data.setVisibility(View.VISIBLE);
                        } else {
                            SharedPreferences.Editor sPrefEdit = sSharedPreferences.edit();
                            sPrefEdit.putString("ApiKey", firebaseRemoteConfig.getString("ApiKey"));
                            long MilliSec = Calendar.getInstance().getTimeInMillis();
                            sPrefEdit.putLong("MilliSec", MilliSec + 60 * 60 * 1000);
                            sPrefEdit.apply();
                            Constant.YoutubeApiKey = firebaseRemoteConfig.getString("ApiKey");
                            Constant.dbHelper = new DbHelper(ActivityDashBoard.this);
                            Constant.arrayListMaster = new ArrayList<>();
                            image_favourite = findViewById(R.id.image_favourite);
                            text_dashboard_title = findViewById(R.id.text_dashboard_title);
                            text_dashboard_detail = findViewById(R.id.text_dashboard_detail);
                            img_dashboard = findViewById(R.id.img_dashboard);
                            getPlaylistApiCall();


                            verticalGrid_dashboard = findViewById(R.id.verticalGrid_dashboard);
                            item_detail_banner_view = findViewById(R.id.item_full_view);
                            homepage_without_slider = findViewById(R.id.homepage_without_slider);
                            header_row_card = findViewById(R.id.header_row_card);
                            slider_view = findViewById(R.id.slider_view);
                            page = findViewById(R.id.my_pager);
                            TabLayout tabLayout = findViewById(R.id.tabDots);
                            heightForDetailsViewAnimation = slider_view.getMeasuredHeight();

                            listItems.add(R.drawable.cruiseship);
                            listItems.add(R.drawable.cruiseship);
                            listItems.add(R.drawable.cruiseship);
                            listItems.add(R.drawable.cruiseship);
                            listItems.add(R.drawable.cruiseship);
                            page.setAdapter(new The_Slide_items_Pager_Adapter(this, listItems));

                            java.util.Timer timer = new java.util.Timer();
                            timer.scheduleAtFixedRate(new The_slide_timer(), 2000, 3000);
                            tabLayout.setupWithViewPager(page, true);
                            tabLayout.setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);

                            page.setNextFocusDownId(R.id.image_inspiration);
                            page.setOnFocusChangeListener((v, hasFocus) -> {

                                if (anim != null) anim.end();
                                if (hasFocus) {
                                    anim = ValueAnimator.ofInt(heightForDetailsViewAnimation, displayMetrics.heightPixels);
                                    anim.addUpdateListener(valueAnimator -> {
                                        int val = (Integer) valueAnimator.getAnimatedValue();

                                        ViewGroup.LayoutParams layoutParams = slider_view.getLayoutParams();
                                        layoutParams.height = val;
                                        slider_view.setLayoutParams(layoutParams);

                                    });
                                    anim.setDuration(300);
                                    anim.start();
                                } else {

                                    anim = ValueAnimator.ofInt(displayMetrics.heightPixels, heightForDetailsViewAnimation);
                                    anim.addUpdateListener(valueAnimator -> {
                                        int val = (Integer) valueAnimator.getAnimatedValue();

                                        ViewGroup.LayoutParams layoutParams = slider_view.getLayoutParams();
                                        layoutParams.height = val;
                                        slider_view.setLayoutParams(layoutParams);

                                    });
                                }

                            });

                            btn1 = findViewById(R.id.image_inspiration);
                            Button btn2 = findViewById(R.id.image_podcasts);
                            Button btn3 = findViewById(R.id.image_TvShows);
                            Button btn4 = findViewById(R.id.image_fav);

                            btn1.setOnFocusChangeListener((v, hasFocus) -> {
                                if (hasFocus) {
                                    hideDetailBanner();
                                }
                            });
                            btn2.setOnFocusChangeListener((v, hasFocus) -> {
                                if (hasFocus) {
                                    hideDetailBanner();
                                }
                            });
                            btn3.setOnFocusChangeListener((v, hasFocus) -> {
                                if (hasFocus) {
                                    hideDetailBanner();
                                }
                            });
                            btn4.setOnFocusChangeListener((v, hasFocus) -> {
                                System.out.print(hasFocus);
                                if (hasFocus) {
                                    hideDetailBanner();
                                }
                            });
                            image_favourite.setOnClickListener(v -> startActivity(new Intent(ActivityDashBoard.this, ActivityFavourite.class)));
                            adapterOnDemandMaster = new AdapterOnDemandMaster(ActivityDashBoard.this, Constant.arrayListMaster, new AdapterOnDemandMaster.OnFocusChange() {
                                @Override
                                public void FocusListener(ModelMaster.playList.Videos videoData) {
                                    Picasso.with(ActivityDashBoard.this).load(videoData.getVideoImage()).into(img_dashboard);
                                    text_dashboard_title.setText(videoData.getVideoTitle());
                                    text_dashboard_detail.setText(videoData.getVideoDetail());
                                    showDetailBanner();
                                }

                                @Override
                                public void Clicked(ModelMaster.playList.Videos videoData) {
                                    Intent intent = new Intent(ActivityDashBoard.this, ActivityDetail.class);
                                    Bundle b = new Bundle();
                                    b.putSerializable("video", videoData);
                                    intent.putExtras(b);
                                    startActivity(intent);
                                }
                            });
                            verticalGrid_dashboard.setAdapter(adapterOnDemandMaster);
                            verticalGrid_dashboard.setWindowAlignmentOffsetPercent(32);
                            verticalGrid_dashboard.setOnChildViewHolderSelectedListener(new OnChildViewHolderSelectedListener() {

                                @Override
                                public void onChildViewHolderSelected(RecyclerView parent, RecyclerView.ViewHolder child, int position, int subposition) {
                                    if (child != null && child.itemView.hasFocus()) {
                                        if (parent.getChildAdapterPosition(child.itemView) == 0) {
                                            header_row_card.setVisibility(VISIBLE);
                                            verticalGrid_dashboard.setWindowAlignmentOffsetPercent(32);
                                        } else if (parent.getChildAdapterPosition(child.itemView) == 1) {
                                            header_row_card.setVisibility(View.GONE);
                                            verticalGrid_dashboard.setWindowAlignmentOffsetPercent(27);
                                        }
                                    }
                                    super.onChildViewHolderSelected(parent, child, position, subposition);
                                }

                                @Override
                                public void onChildViewHolderSelectedAndPositioned(RecyclerView parent, RecyclerView.ViewHolder child, int position, int subposition) {
                                    if (child != null) {
                                        if (heightForRow == -999) {
                                            heightForRow =child.itemView.findViewById(R.id.rvChild).getLayoutParams().height;
                                        }
                                        if (child.itemView.hasFocus()) {
                                            if (child.itemView.findViewById(R.id.text_playlist_name).getVisibility() == GONE) {
                                                for (int i = 0; i < parent.getChildCount(); i++) {
                                                    View view = parent.getChildAt(i);
                                                    view.findViewById(R.id.text_playlist_name).setVisibility(View.VISIBLE);
                                                    view.findViewById(R.id.rvChild).setPadding(0, 11, 0, 22);
                                                    ViewGroup.LayoutParams l = view.findViewById(R.id.rvChild).getLayoutParams();
                                                    l.height = heightForRow + 30;
                                                    view.findViewById(R.id.rvChild).setLayoutParams(l);
                                                }
                                                System.out.println("plus");
                                            }

                                        } else {
                                            if (child.itemView.findViewById(R.id.text_playlist_name).getVisibility() == VISIBLE) {
                                                for (int i = 0; i < parent.getChildCount(); i++) {
                                                    View view = parent.getChildAt(i);
                                                    view.findViewById(R.id.text_playlist_name).setVisibility(View.GONE);
                                                    view.findViewById(R.id.rvChild).setPadding(0, 0, 0, 5);
                                                    ViewGroup.LayoutParams l = view.findViewById(R.id.rvChild).getLayoutParams();
                                                    l.height = heightForRow;
                                                    view.findViewById(R.id.rvChild).setLayoutParams(l);
                                                }
                                                System.out.println("minus");
                                            }

                                        }
                                    }
                                    super.onChildViewHolderSelectedAndPositioned(parent, child, position, subposition);
                                }
                            });


                            image_favourite.setOnFocusChangeListener((v, hasFocus) -> {
                                if (hasFocus) Utility.focusIn(v);
                                else Utility.focusOut(v);
                            });
                            new Handler().postDelayed(() -> Constant.arrayListFavourite = Constant.dbHelper.GetFavourites(), 500);

                        }


                    } else {
                        Toast.makeText(ActivityDashBoard.this, task.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Constant.YoutubeApiKey = sSharedPreferences.getString("ApiKey", Constant.YoutubeApiKey);
                Constant.dbHelper = new DbHelper(ActivityDashBoard.this);
                Constant.arrayListMaster = new ArrayList<>();
                getPlaylistApiCall();
                verticalGrid_dashboard = findViewById(R.id.verticalGrid_dashboard);
                image_favourite = findViewById(R.id.image_favourite);
                text_dashboard_title = findViewById(R.id.text_dashboard_title);
                text_dashboard_detail = findViewById(R.id.text_dashboard_detail);
                img_dashboard = findViewById(R.id.img_dashboard);
                image_favourite.setOnClickListener(v -> startActivity(new Intent(ActivityDashBoard.this, ActivityFavourite.class)));
                adapterOnDemandMaster = new AdapterOnDemandMaster(ActivityDashBoard.this, Constant.arrayListMaster, new AdapterOnDemandMaster.OnFocusChange() {
                    @Override
                    public void FocusListener(ModelMaster.playList.Videos videoData) {
                        Picasso.with(ActivityDashBoard.this).load(videoData.getVideoImage()).into(img_dashboard);
                        text_dashboard_title.setText(videoData.getVideoTitle());
                        text_dashboard_detail.setText(videoData.getVideoDetail());
                    }

                    @Override
                    public void Clicked(ModelMaster.playList.Videos videoData) {
                        Intent intent = new Intent(ActivityDashBoard.this, ActivityDetail.class);
                        Bundle b = new Bundle();
                        b.putSerializable("video", videoData);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });
                verticalGrid_dashboard.setAdapter(adapterOnDemandMaster);
                image_favourite.setOnFocusChangeListener((v, hasFocus) -> {
                    if (hasFocus) Utility.focusIn(v);
                    else Utility.focusOut(v);
                });
                new Handler().postDelayed(() -> Constant.arrayListFavourite = Constant.dbHelper.GetFavourites(), 500);
            }

        } else {
            Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
        }
//        int space = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics());
//        verticalGrid_dashboard.addItemDecoration(new SpacesItemDecoration(space));
    }

    private void hideDetailBanner() {
        if (item_detail_banner_view.getVisibility() == View.GONE) return;
        header_row_card.setBackgroundColor(Color.TRANSPARENT);
        homepage_without_slider.setBackgroundColor(getResources().getColor(R.color.transparentBackground));

        if (anim != null) anim.end();
        anim = ValueAnimator.ofInt(heightForDetailsViewAnimation, 0);
        anim.addUpdateListener(valueAnimator -> {
            int val = (Integer) valueAnimator.getAnimatedValue();
            slider_view.setVisibility(View.VISIBLE);

            ViewGroup.LayoutParams layoutParams = item_detail_banner_view.getLayoutParams();
            layoutParams.height = val;
            item_detail_banner_view.setLayoutParams(layoutParams);

            ViewGroup.LayoutParams layoutParams2 = slider_view.getLayoutParams();
            layoutParams2.height = heightForDetailsViewAnimation - val;
            slider_view.setLayoutParams(layoutParams2);
        });
        anim.setDuration(300);
        anim.start();
        verticalGrid_dashboard.requestLayout();

        item_detail_banner_view.postDelayed(() -> {
            item_detail_banner_view.setVisibility(View.GONE);
        }, 300);
    }


    private void showDetailBanner() {
        if (item_detail_banner_view.getVisibility() == View.VISIBLE) return;

        header_row_card.setBackgroundColor(getResources().getColor(R.color.transparentBackground));
        homepage_without_slider.setBackgroundColor(getResources().getColor(R.color.colorTransparent));
        item_detail_banner_view.setVisibility(View.VISIBLE);

        if (anim != null) anim.end();
        anim = ValueAnimator.ofInt(0, heightForDetailsViewAnimation);
        anim.addUpdateListener(valueAnimator -> {
            int val = ((Integer) valueAnimator.getAnimatedValue());
            ViewGroup.LayoutParams layoutParams = item_detail_banner_view.getLayoutParams();
            layoutParams.height = val;
            item_detail_banner_view.setLayoutParams(layoutParams);

            ViewGroup.LayoutParams layoutParams2 = slider_view.getLayoutParams();
            layoutParams2.height = heightForDetailsViewAnimation - val;
            slider_view.setLayoutParams(layoutParams2);
        });
        anim.setDuration(300);
        anim.start();
        verticalGrid_dashboard.requestLayout();

        slider_view.postDelayed(() -> {
            slider_view.setVisibility(View.GONE);
        }, 300);

    }

    private void getPlaylistApiCall() {
        Call<ModelDashBoardPlaylist> callModelDashboard = Api.CreateApi(this).getPlaylist(Constant.YoutubeApiKey, Constant.channelId);
        callModelDashboard.enqueue(new Callback<ModelDashBoardPlaylist>() {
            @Override
            public void onResponse(Call<ModelDashBoardPlaylist> call, Response<ModelDashBoardPlaylist> response) {
                if (response.isSuccessful() && response.body() != null && response.errorBody() == null) {
                    for (int i = 0; i < response.body().getItems().size(); i++)
                        if (response.body().getItems() != null && response.body().getItems().get(i) != null)
                            getVideoApiCall(response.body().getItems().get(i).getId(), response.body().getItems().get(i).getSnippet().getTitle());
                } else {
                    Toast.makeText(ActivityDashBoard.this, response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ModelDashBoardPlaylist> call, Throwable t) {
                Toast.makeText(ActivityDashBoard.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getVideoApiCall(final String playListId, final String playListTitle) {
        Call<ModelDashBoardVideos> callModelDashboard = Api.CreateApi(ActivityDashBoard.this).getVideos(Constant.YoutubeApiKey, Constant.channelId, playListId);
        callModelDashboard.enqueue(new Callback<ModelDashBoardVideos>() {
            @Override
            public void onResponse(Call<ModelDashBoardVideos> call, Response<ModelDashBoardVideos> response) {
                ModelMaster modelMaster = new ModelMaster();
                ModelMaster.playList playList = new ModelMaster.playList();
                ArrayList<ModelMaster.playList> arrayListPlayList = new ArrayList<>();
                ArrayList<ModelMaster.playList.Videos> arrayListPlayListVideos = new ArrayList<>();
                for (int i = 0; i < response.body().getItems().size(); i++) {
                    ModelMaster.playList.Videos videos = new ModelMaster.playList.Videos();
                    videos.setVideoId(response.body().getItems().get(i).getSnippet().getResourceId().getVideoId());
                    if (response.body().getItems().get(i).getSnippet().getThumbnails().getMaxres() != null)
                        videos.setVideoImage(response.body().getItems().get(i).getSnippet().getThumbnails().getMaxres().getUrl());
                    else if (response.body().getItems().get(i).getSnippet().getThumbnails().getHigh() != null)
                        videos.setVideoImage(response.body().getItems().get(i).getSnippet().getThumbnails().getHigh().getUrl());
                    videos.setVideoTitle(response.body().getItems().get(i).getSnippet().getTitle());
                    videos.setVideoDetail(response.body().getItems().get(i).getSnippet().getDescription());
                    arrayListPlayListVideos.add(videos);
                }
                playList.setPlayListId(playListId);
                playList.setPlayListTile(playListTitle);
                playList.setVideos(arrayListPlayListVideos);
                arrayListPlayList.add(playList);
                modelMaster.setPlayLists(arrayListPlayList);
                Constant.arrayListMaster.add(modelMaster);

                adapterOnDemandMaster.notifyItemInserted(Constant.arrayListMaster.size() - 1);

                //adapterOnDemandMaster.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ModelDashBoardVideos> call, Throwable t) {
                Toast.makeText(ActivityDashBoard.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Constant.isFirstTime = true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN && page != null && page.hasFocus()) {
            anim = ValueAnimator.ofInt(displayMetrics.heightPixels, heightForDetailsViewAnimation);
            anim.addUpdateListener(valueAnimator -> {
                int val = (Integer) valueAnimator.getAnimatedValue();

                ViewGroup.LayoutParams layoutParams = slider_view.getLayoutParams();
                layoutParams.height = val;
                slider_view.setLayoutParams(layoutParams);

            });
            anim.setDuration(300);
            anim.start();
            btn1.postDelayed(() -> {
                btn1.requestFocus();
            }, 300);
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            ActivityDashBoard.this.runOnUiThread(() -> {
                if (slider_view.getHeight() == displayMetrics.heightPixels) return;
                if (page.getCurrentItem() < listItems.size() - 1) {
                    page.setCurrentItem(page.getCurrentItem() + 1);
                } else page.setCurrentItem(0);
            });
        }
    }

}