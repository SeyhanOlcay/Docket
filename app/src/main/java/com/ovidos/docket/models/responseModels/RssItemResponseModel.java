package com.ovidos.docket.models.responseModels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by omral on 18.05.2017.
 */

public class RssItemResponseModel extends BaseResponseModel {

    @SerializedName("Content")
    public String content;
    @SerializedName("CreateDate")
    public Date createDate;
    @SerializedName("Title")
    public String title;
    @SerializedName("Description")
    public String description;
    @SerializedName("ImageUrl")
    public String imageUrl;
    @SerializedName("Url")
    public String url;
    @SerializedName("PublisherName")
    public String publisherName;
    @SerializedName("PublisherLogoUrl")
    public String publisherLogoUrl;
    @SerializedName("IsLiked")
    public boolean isLiked;
    @SerializedName("IsUnliked")
    public boolean isUnliked;
    @SerializedName("IsRead")
    public boolean isRead;
    @SerializedName("IsSaved")
    public boolean isSaved;
    @SerializedName("LikeCount")
    public int likeCount;
    @SerializedName("ReadCount")
    public int readCount;
    @SerializedName("UnLikeCount")
    public int unlikeCount;
    @SerializedName("SaveCount")
    public int saveCount;

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
