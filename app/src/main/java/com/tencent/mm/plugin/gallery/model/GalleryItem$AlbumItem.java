package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.bh;

public class GalleryItem$AlbumItem implements Parcelable {
    public static final Creator<GalleryItem$AlbumItem> CREATOR = new 1();
    public int ftF;
    public String mRb;
    public MediaItem mRc;

    public GalleryItem$AlbumItem(String str, int i) {
        this.mRb = bh.ou(str);
        this.ftF = i;
    }

    protected GalleryItem$AlbumItem(Parcel parcel) {
        this.mRb = parcel.readString();
        this.ftF = parcel.readInt();
        this.mRc = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
    }

    public final String aNV() {
        if (this.mRc == null) {
            return null;
        }
        return this.mRc.aNV();
    }

    public final long aNW() {
        if (this.mRc == null) {
            return -1;
        }
        return this.mRc.mRf;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mRb);
        parcel.writeInt(this.ftF);
        parcel.writeParcelable(this.mRc, i);
    }
}
