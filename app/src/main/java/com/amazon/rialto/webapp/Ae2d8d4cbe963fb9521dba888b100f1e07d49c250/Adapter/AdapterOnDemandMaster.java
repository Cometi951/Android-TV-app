package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.recyclerview.widget.RecyclerView;

import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelMaster;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.R;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Utility.SpacesItemDecoration;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Utility.Utility;

import java.util.ArrayList;


public class AdapterOnDemandMaster extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<ModelMaster> arrayListMaster;
    OnFocusChange onFocusChange;


    public AdapterOnDemandMaster(Context context, ArrayList<ModelMaster> arrayListMaster, OnFocusChange onFocusChange) {
        this.context = context;
        this.arrayListMaster = arrayListMaster;
        this.onFocusChange = onFocusChange;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_playlist, null);
        return new MasterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (arrayListMaster.size() > 3 && position == arrayListMaster.size() - 1) {
            Utility.setMarginBottom(holder.itemView, 50, context);
        } else {
            Utility.setMarginBottom(holder.itemView, 0, context);
        }


        MasterHolder masterHolder = (MasterHolder) holder;
        masterHolder.text_playlist_name.setText(arrayListMaster.get(position).getPlayLists().get(0).getPlayListTile());
        AdapterDashBoardVideo adapterDashBoardVideo = new AdapterDashBoardVideo(context, position, arrayListMaster.get(position).getPlayLists().get(0).getVideos(), new AdapterDashBoardVideo.FocusChangeListerChild() {
            @Override
            public void onFocusChanged(ModelMaster.playList.Videos videoData) {
                onFocusChange.FocusListener(videoData);
                Constant.showCategory = true;
            }

            @Override
            public void Clicked(ModelMaster.playList.Videos videoData) {
                onFocusChange.Clicked(videoData);
            }
        });
        masterHolder.rvChild.setAdapter(adapterDashBoardVideo);
    }

    @Override
    public int getItemCount() {
        return arrayListMaster != null ? arrayListMaster.size() : 0;
    }

    public interface OnFocusChange {
        void FocusListener(ModelMaster.playList.Videos videoData);

        void Clicked(ModelMaster.playList.Videos videoData);
    }

    public static class MasterHolder extends RecyclerView.ViewHolder {
        HorizontalGridView rvChild;
        TextView text_playlist_name;


        public MasterHolder(@NonNull View v) {
            super(v);
            text_playlist_name = itemView.findViewById(R.id.text_playlist_name);
            rvChild = itemView.findViewById(R.id.rvChild);
            rvChild.setHasFixedSize(true);

            int space = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, v.getContext().getResources().getDisplayMetrics());
            rvChild.addItemDecoration(new SpacesItemDecoration(space));
            rvChild.setWindowAlignment(1);
            rvChild.setWindowAlignmentOffsetPercent(18);
        }
    }

}