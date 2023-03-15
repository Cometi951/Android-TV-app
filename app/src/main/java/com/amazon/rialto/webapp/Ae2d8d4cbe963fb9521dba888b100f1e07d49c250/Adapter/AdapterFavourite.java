package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Activity.ActivityDetail;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelFavourite;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelMaster;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.R;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Utility.Utility;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant.arrayListFavourite;

public class AdapterFavourite extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    FocusChangeListerChild focusChangeListerChild;

    public AdapterFavourite(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, null);
        return new ChildHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ChildHolder childHolder = (ChildHolder) holder;
        childHolder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Utility.focusIn(v);
                    v.findViewById(R.id.text_playlist_name).setBackground(null);
                    //focusChangeListerChild.onFocusChanged(arrayListFavourite.get(position));
                } else {
                    v.findViewById(R.id.text_playlist_name).setBackgroundResource(R.drawable.background_gradient_transparent);
                    Utility.focusOut(v);
                }
            }
        });
        if (position < 5) {
            Utility.setMarginTop(holder.itemView, 50, context);
        } else {
            Utility.setMarginTop(holder.itemView, 0, context);
        }

        if (position > arrayListFavourite.size() - 6) {
            Utility.setMarginBottom(holder.itemView, 50, context);
        } else {
            Utility.setMarginBottom(holder.itemView, 0, context);
        }


       // if (position == (position % 5)) {
       //     Utility.setMarginLeft(holder.itemView, 100, context);
        //} else {
            //Utility.setMarginLeft(holder.itemView, 0, context);
       //}


        Picasso.with(context).load(arrayListFavourite.get(position).getImage()).into(childHolder.img_item_video);
        childHolder.text_playlist_name.setText(arrayListFavourite.get(position).getName());

        childHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityDetail.class);
                Bundle b = new Bundle();
                ModelMaster.playList.Videos videos = new ModelMaster.playList.Videos();
                videos.setVideoId(arrayListFavourite.get(position).getId());
                videos.setVideoTitle(arrayListFavourite.get(position).getName());
                videos.setVideoDetail(arrayListFavourite.get(position).getDetail());
                videos.setVideoImage(arrayListFavourite.get(position).getImage());
                b.putSerializable("video", videos);
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListFavourite.size();
    }

    public class ChildHolder extends RecyclerView.ViewHolder {

        TextView text_playlist_name;
        ImageView img_item_video;

        public ChildHolder(@NonNull View v) {
            super(v);
            img_item_video = itemView.findViewById(R.id.img_item_video);
            text_playlist_name = itemView.findViewById(R.id.text_playlist_name);

        }

    }

    public interface FocusChangeListerChild {
        void onFocusChanged(ModelFavourite videoData);

        void Clicked(ModelFavourite videoData);
    }

}