package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model.ModelMaster;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.R;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Utility.Utility;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant.isFirstTime;

public class AdapterDashBoardVideo extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ModelMaster.playList.Videos> arrayListPlayListVideos;
    int positionPlayList;
    OnClicked onClicked;
    Context context;
    FocusChangeListerChild focusChangeListerChild;
    Handler handler = new Handler();


    public AdapterDashBoardVideo(Context context, int positionPlayList, List<ModelMaster.playList.Videos> arrayListPlayListVideos, FocusChangeListerChild focusChangeListerChild) {
        this.context = context;
        this.positionPlayList = positionPlayList;
        this.arrayListPlayListVideos = arrayListPlayListVideos;
        this.focusChangeListerChild = focusChangeListerChild;
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
        if (position == 0) {
            //Utility.setMarginLeft(holder.itemView, 50, context);
            /*LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(Utility.dpToPx(50, context), 0, Utility.dpToPx(8, context), 0);
            holder.itemView.setLayoutParams(layoutParams);*/
            //holder.itemView.setPadding(Utility.dpToPx(50, context), 0, Utility.dpToPx(8, context), 0);

            if (positionPlayList == 0 && isFirstTime) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        childHolder.itemView.requestFocus();
                        isFirstTime = false;
                    }
                },500);
            }
        } else {
            /*if (position == arrayListPlayListVideos.size() - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(0, 0, Utility.dpToPx(50, context), 0);
                holder.itemView.setLayoutParams(layoutParams);
                //holder.itemView.setPadding(0, 0, Utility.dpToPx(50, context), 0);
            } else {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(0, 0, Utility.dpToPx(8, context), 0);
                holder.itemView.setLayoutParams(layoutParams);*/
                //holder.itemView.setPadding(0, 0, Utility.dpToPx(8, context), 0);
            //}
        }
            childHolder.itemView.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus) {
                    v.findViewById(R.id.frame_item).setPadding(6,6,6,6);
                    v.findViewById(R.id.relative_item).setPadding(40,0,40,0);


                    Utility.focusIn(v);
                    focusChangeListerChild.onFocusChanged(arrayListPlayListVideos.get(position));
                } else {
                    v.findViewById(R.id.frame_item).setPadding(0,0,0,0);
                    v.findViewById(R.id.relative_item).setPadding(0,0,0,0);
//                        v.findViewById(R.id.text_playlist_name).setVisibility(View.VISIBLE);
                    Utility.focusOut(v);
                }
            });


        /*handler.post(new Runnable() {
            @Override
            public void run() {*/



            /*}
        });*/

        Picasso.with(context).load(arrayListPlayListVideos.get(position).getVideoImage()).into(childHolder.img_item_video);
        childHolder.text_playlist_name.setText(arrayListPlayListVideos.get(position).getVideoTitle());

        childHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                focusChangeListerChild.Clicked(arrayListPlayListVideos.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayListPlayListVideos.size();
    }

    public class ChildHolder extends RecyclerView.ViewHolder {

        TextView text_playlist_name;
        ImageView img_item_video, imgItemHeaderSelection;

        public ChildHolder(@NonNull View v) {
            super(v);
            img_item_video = itemView.findViewById(R.id.img_item_video);
            text_playlist_name = itemView.findViewById(R.id.text_playlist_name);
            imgItemHeaderSelection = itemView.findViewById(R.id.imgItemHeaderSelection);

        }

    }

    public interface OnClicked {
        //  void OnItemViewLiveClickListenerChild(ModelOnDemand.LiveClass mLiveClass);
        //  void OnItemViewCategoryClickListenerChild(ModelOnDemand.Category.Video video_);
    }

    public interface FocusChangeListerChild {
        void onFocusChanged(ModelMaster.playList.Videos videoData);

        void Clicked(ModelMaster.playList.Videos videoData);
    }


}