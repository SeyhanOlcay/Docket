package com.ovidos.docket.models.responseModels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by omral on 18.05.2017.
 */

public class RssItemResponseModel extends BaseResponseModel {

    @SerializedName("Content")
    private String content;
    @SerializedName("CreateDate")
    private Date createDate;
    @SerializedName("Title")
    private String title;
    @SerializedName("Description")
    private String description;
    @SerializedName("ImageUrl")
    private String imageUrl;
    @SerializedName("Url")
    private String url;
    @SerializedName("PublisherName")
    private String publisherName;
    @SerializedName("PublisherLogoUrl")
    private String publisherLogoUrl;
    @SerializedName("IsLiked")
    private boolean isLiked;
    @SerializedName("IsUnliked")
    private boolean isUnliked;
    @SerializedName("IsRead")
    private boolean isRead;
    @SerializedName("IsSaved")
    private boolean isSaved;
    @SerializedName("LikeCount")
    private int likeCount;
    @SerializedName("ReadCount")
    private int readCount;
    @SerializedName("UnLikeCount")
    private int unlikeCount;
    @SerializedName("SaveCount")
    private int saveCount;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherLogoUrl() {
        return publisherLogoUrl;
    }

    public void setPublisherLogoUrl(String publisherLogoUrl) {
        this.publisherLogoUrl = publisherLogoUrl;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public boolean isUnliked() {
        return isUnliked;
    }

    public void setUnliked(boolean unliked) {
        isUnliked = unliked;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getUnlikeCount() {
        return unlikeCount;
    }

    public void setUnlikeCount(int unlikeCount) {
        this.unlikeCount = unlikeCount;
    }

    public int getSaveCount() {
        return saveCount;
    }

    public void setSaveCount(int saveCount) {
        this.saveCount = saveCount;
    }
}
