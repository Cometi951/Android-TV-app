package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelDashBoardVideos {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("pageInfo")
    @Expose
    private PageInfo pageInfo;

    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;
    @SerializedName("regionCode")
    @Expose
    private String regionCode;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public class PageInfo {

        @SerializedName("totalResults")
        @Expose
        private Integer totalResults;
        @SerializedName("resultsPerPage")
        @Expose
        private Integer resultsPerPage;

        public Integer getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(Integer totalResults) {
            this.totalResults = totalResults;
        }

        public Integer getResultsPerPage() {
            return resultsPerPage;
        }

        public void setResultsPerPage(Integer resultsPerPage) {
            this.resultsPerPage = resultsPerPage;
        }

    }



        public class Item {

            @SerializedName("kind")
            @Expose
            private String kind;
            @SerializedName("etag")
            @Expose
            private String etag;
            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("snippet")
            @Expose
            private Snippet snippet;

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

            public String getEtag() {
                return etag;
            }

            public void setEtag(String etag) {
                this.etag = etag;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Snippet getSnippet() {
                return snippet;
            }

            public void setSnippet(Snippet snippet) {
                this.snippet = snippet;
            }

        }

        public class Id {

            @SerializedName("kind")
            @Expose
            private String kind;
            @SerializedName("videoId")
            @Expose
            private String videoId;

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

            public String getVideoId() {
                return videoId;
            }

            public void setVideoId(String videoId) {
                this.videoId = videoId;
            }

        }

        public class Snippet {

            @SerializedName("publishedAt")
            @Expose
            private String publishedAt;
            @SerializedName("channelId")
            @Expose
            private String channelId;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("thumbnails")
            @Expose
            private Thumbnails thumbnails;
            @SerializedName("channelTitle")
            @Expose
            private String channelTitle;
            @SerializedName("playlistId")
            @Expose
            private String playlistId;
            @SerializedName("position")
            @Expose
            private Integer position;
            @SerializedName("resourceId")
            @Expose
            private ResourceId resourceId;

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getChannelId() {
                return channelId;
            }

            public void setChannelId(String channelId) {
                this.channelId = channelId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public Thumbnails getThumbnails() {
                return thumbnails;
            }

            public void setThumbnails(Thumbnails thumbnails) {
                this.thumbnails = thumbnails;
            }

            public String getChannelTitle() {
                return channelTitle;
            }

            public void setChannelTitle(String channelTitle) {
                this.channelTitle = channelTitle;
            }

            public String getPlaylistId() {
                return playlistId;
            }

            public void setPlaylistId(String playlistId) {
                this.playlistId = playlistId;
            }

            public Integer getPosition() {
                return position;
            }

            public void setPosition(Integer position) {
                this.position = position;
            }

            public ResourceId getResourceId() {
                return resourceId;
            }

            public void setResourceId(ResourceId resourceId) {
                this.resourceId = resourceId;
            }

            public class Thumbnails {

                @SerializedName("default")
                @Expose
                private Default _default;
                @SerializedName("medium")
                @Expose
                private Medium medium;
                @SerializedName("high")
                @Expose
                private High high;
                @SerializedName("standard")
                @Expose
                private Standard standard;
                @SerializedName("maxres")
                @Expose
                private Maxres maxres;

                public Default getDefault() {
                    return _default;
                }

                public void setDefault(Default _default) {
                    this._default = _default;
                }

                public Medium getMedium() {
                    return medium;
                }

                public void setMedium(Medium medium) {
                    this.medium = medium;
                }

                public High getHigh() {
                    return high;
                }

                public void setHigh(High high) {
                    this.high = high;
                }

                public Standard getStandard() {
                    return standard;
                }

                public void setStandard(Standard standard) {
                    this.standard = standard;
                }

                public Maxres getMaxres() {
                    return maxres;
                }

                public void setMaxres(Maxres maxres) {
                    this.maxres = maxres;
                }

                public class Default {

                    @SerializedName("url")
                    @Expose
                    private String url;
                    @SerializedName("width")
                    @Expose
                    private Integer width;
                    @SerializedName("height")
                    @Expose
                    private Integer height;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public Integer getWidth() {
                        return width;
                    }

                    public void setWidth(Integer width) {
                        this.width = width;
                    }

                    public Integer getHeight() {
                        return height;
                    }

                    public void setHeight(Integer height) {
                        this.height = height;
                    }

                }

                public class Standard {

                    @SerializedName("url")
                    @Expose
                    private String url;
                    @SerializedName("width")
                    @Expose
                    private Integer width;
                    @SerializedName("height")
                    @Expose
                    private Integer height;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public Integer getWidth() {
                        return width;
                    }

                    public void setWidth(Integer width) {
                        this.width = width;
                    }

                    public Integer getHeight() {
                        return height;
                    }

                    public void setHeight(Integer height) {
                        this.height = height;
                    }

                }

                public class Medium {

                    @SerializedName("url")
                    @Expose
                    private String url;
                    @SerializedName("width")
                    @Expose
                    private Integer width;
                    @SerializedName("height")
                    @Expose
                    private Integer height;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public Integer getWidth() {
                        return width;
                    }

                    public void setWidth(Integer width) {
                        this.width = width;
                    }

                    public Integer getHeight() {
                        return height;
                    }

                    public void setHeight(Integer height) {
                        this.height = height;
                    }

                }

                public class Maxres {

                    @SerializedName("url")
                    @Expose
                    private String url;
                    @SerializedName("width")
                    @Expose
                    private Integer width;
                    @SerializedName("height")
                    @Expose
                    private Integer height;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public Integer getWidth() {
                        return width;
                    }

                    public void setWidth(Integer width) {
                        this.width = width;
                    }

                    public Integer getHeight() {
                        return height;
                    }

                    public void setHeight(Integer height) {
                        this.height = height;
                    }

                }

                public class High {

                    @SerializedName("url")
                    @Expose
                    private String url;
                    @SerializedName("width")
                    @Expose
                    private Integer width;
                    @SerializedName("height")
                    @Expose
                    private Integer height;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public Integer getWidth() {
                        return width;
                    }

                    public void setWidth(Integer width) {
                        this.width = width;
                    }

                    public Integer getHeight() {
                        return height;
                    }

                    public void setHeight(Integer height) {
                        this.height = height;
                    }

                }

            }

            public class ResourceId {

                @SerializedName("kind")
                @Expose
                private String kind;
                @SerializedName("videoId")
                @Expose
                private String videoId;

                public String getKind() {
                    return kind;
                }

                public void setKind(String kind) {
                    this.kind = kind;
                }

                public String getVideoId() {
                    return videoId;
                }

                public void setVideoId(String videoId) {
                    this.videoId = videoId;
                }

            }

        }

    }


