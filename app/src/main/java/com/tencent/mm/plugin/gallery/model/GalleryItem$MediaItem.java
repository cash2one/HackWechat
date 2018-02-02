package com.tencent.mm.plugin.gallery.model;

import android.os.Parcelable;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;

public abstract class GalleryItem$MediaItem implements Parcelable, Comparable<GalleryItem$MediaItem> {
    public String hOo;
    public String mMimeType;
    public String mRd;
    public String mRe;
    public long mRf;
    public long mRg;
    public String mld;

    public abstract String aNV();

    public abstract int getType();

    public /* synthetic */ int compareTo(Object obj) {
        return a((GalleryItem$MediaItem) obj);
    }

    public GalleryItem$MediaItem() {
        this(0, "", "", "");
    }

    public GalleryItem$MediaItem(long j) {
        this(j, "", "", "");
    }

    public GalleryItem$MediaItem(long j, String str, String str2, String str3) {
        this.mRf = j;
        this.hOo = str;
        this.mld = str2;
        this.mMimeType = str3;
    }

    public static GalleryItem$MediaItem a(int i, long j, String str, String str2, String str3) {
        if (i == 1) {
            return new ImageMediaItem(j, str, str2, str3);
        }
        return new VideoMediaItem(j, str, str2, str3);
    }

    public static GalleryItem$MediaItem w(int i, long j) {
        if (i == 1) {
            return new ImageMediaItem(j);
        }
        return new VideoMediaItem(j);
    }

    public final int a(GalleryItem$MediaItem galleryItem$MediaItem) {
        if (this.mRg > galleryItem$MediaItem.mRg) {
            return 1;
        }
        return this.mRg < galleryItem$MediaItem.mRg ? -1 : -1;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GalleryItem$MediaItem)) {
            return false;
        }
        GalleryItem$MediaItem galleryItem$MediaItem = (GalleryItem$MediaItem) obj;
        if (this.hOo == null || !this.hOo.equals(galleryItem$MediaItem.hOo)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "MediaItem{mOrignalPath='" + this.hOo + '\'' + ", mThumbPath='" + this.mld + '\'' + ", origId=" + this.mRf + ", addDate=" + this.mRg + ", mMimeType='" + this.mMimeType + '\'' + '}';
    }
}
