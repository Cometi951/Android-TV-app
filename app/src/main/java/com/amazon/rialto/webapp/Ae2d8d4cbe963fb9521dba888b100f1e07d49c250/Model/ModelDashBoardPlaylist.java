package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelDashBoardPlaylist {
    @SerializedName("kind")
    @Expose
    public String kind;
    @SerializedName("etag")
    @Expose
    public String etag;
    @SerializedName("nextPageToken")
    @Expose
    public String nextPageToken;
    @SerializedName("pageInfo")
    @Expose
    public PageInfo pageInfo;
    @SerializedName("items")
    @Expose
    public List<Item> items;

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

    public class Item{

        @SerializedName("kind")
        @Expose
        public String kind;
        @SerializedName("etag")
        @Expose
        public String etag;
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("snippet")
        @Expose
        public Snippet snippet;


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


        public class Snippet{
            @SerializedName("publishedAt")
            @Expose
            public String publishedAt;
            @SerializedName("channelId")
            @Expose
            public String channelId;
            @SerializedName("title")
            @Expose
            public String title;
            @SerializedName("description")
            @Expose
            public String description;
            @SerializedName("thumbnails")
            @Expose
            public Thumbnails thumbnails;
            @SerializedName("channelTitle")
            @Expose
            public String channelTitle;
            @SerializedName("localized")
            @Expose
            public Localized localized;


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

            public Localized getLocalized() {
                return localized;
            }

            public void setLocalized(Localized localized) {
                this.localized = localized;
            }


            public class Thumbnails{

                @SerializedName("medium")
                @Expose
                public Medium medium;
                @SerializedName("standard")
                @Expose
                public Standard standard;

                public class Medium{
                    @SerializedName("url")
                    @Expose
                    public String url;
                    @SerializedName("width")
                    @Expose
                    public int width;
                    @SerializedName("height")
                    @Expose
                    public int height;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }
                }

                public class Standard{
                    @SerializedName("url")
                    @Expose
                    public String url;
                    @SerializedName("width")
                    @Expose
                    public int width;
                    @SerializedName("height")
                    @Expose
                    public int height;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }
                }

                public Medium getMedium() {
                    return medium;
                }

                public void setMedium(Medium medium) {
                    this.medium = medium;
                }

                public Standard getStandard() {
                    return standard;
                }

                public void setStandard(Standard standard) {
                    this.standard = standard;
                }
            }

            public class Localized{
                @SerializedName("title")
                @Expose
                public String title;
                @SerializedName("description")
                @Expose
                public String description;

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
            }

        }


    }

    public class PageInfo{
        @SerializedName("totalResults")
        @Expose
        public int totalResults;
        @SerializedName("resultsPerPage")
        @Expose
        public int resultsPerPage;

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public int getResultsPerPage() {
            return resultsPerPage;
        }

        public void setResultsPerPage(int resultsPerPage) {
            this.resultsPerPage = resultsPerPage;
        }
    }
}
