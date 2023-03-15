package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.widget.VerticalGridView;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ImageView;

import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Adapter.AdapterDetailMaster;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelMaster;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.R;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Utility.SpacesItemDecorationDetail;
import com.squareup.picasso.Picasso;

public class ActivityDetail extends AppCompatActivity {

    ImageView img_detail_background;
    VerticalGridView verticalGrid_detail;
    ModelMaster.playList.Videos video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        GetIntent();
        init();
        setAdapter();
    }

    private void GetIntent() {
        Bundle bundle = getIntent().getExtras();
        video = (ModelMaster.playList.Videos) bundle.getSerializable("video");
    }

    private void init() {
        img_detail_background = findViewById(R.id.img_detail_background);
        verticalGrid_detail = findViewById(R.id.verticalGrid_detail);
        Picasso.with(this).load(video.getVideoImage()).into(img_detail_background);

    }

    private void setAdapter() {
        AdapterDetailMaster adapterDetailMaster = new AdapterDetailMaster(ActivityDetail.this, video, new AdapterDetailMaster.OnFocusChange() {
            @Override
            public void FocusListener(ModelMaster.playList.Videos videoData) {

            }
        });
        verticalGrid_detail.setAdapter(adapterDetailMaster);
        int space = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
        verticalGrid_detail.addItemDecoration(new SpacesItemDecorationDetail(space));
    }

}