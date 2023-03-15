package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model;

import java.io.Serializable;
import java.util.List;

public class ModelMaster {

    private  List<playList> playLists = null;

    public List<playList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(List<playList> playLists) {
        this.playLists = playLists;
    }

    public static class playList implements Serializable{

        private String playListId;
        private String playListTile;
        private List<Videos> videos = null;

        public String getPlayListId() {
            return playListId;
        }

        public void setPlayListId(String playListId) {
            this.playListId = playListId;
        }

        public String getPlayListTile() {
            return playListTile;
        }

        public void setPlayListTile(String playListTile) {
            this.playListTile = playListTile;
        }

        public List<Videos> getVideos() {
            return videos;
        }

        public void setVideos(List<Videos> videos) {
            this.videos = videos;
        }

        public static class Videos implements Serializable {
            private String videoId;
            private String videoTitle;
            private String videoImage;
            private String videoDetail;

            public String getVideoId() {
                return videoId;
            }

            public void setVideoId(String videoId) {
                this.videoId = videoId;
            }

            public String getVideoTitle() {
                return videoTitle;
            }

            public void setVideoTitle(String videoTitle) {
                this.videoTitle = videoTitle;
            }

            public String getVideoImage() {
                return videoImage;
            }

            public void setVideoImage(String videoImage) {
                this.videoImage = videoImage;
            }

            public String getVideoDetail() {
                return videoDetail;
            }

            public void setVideoDetail(String videoDetail) {
                this.videoDetail = videoDetail;
            }
        }
    }




}
