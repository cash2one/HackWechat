package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.bh;

public class GalleryItem$ImageMediaItem extends MediaItem {
    public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MediaItem galleryItem$ImageMediaItem = new GalleryItem$ImageMediaItem();
            galleryItem$ImageMediaItem.hOo = parcel.readString();
            galleryItem$ImageMediaItem.mld = parcel.readString();
            galleryItem$ImageMediaItem.mRf = parcel.readLong();
            galleryItem$ImageMediaItem.mRg = parcel.readLong();
            galleryItem$ImageMediaItem.mMimeType = parcel.readString();
            return galleryItem$ImageMediaItem;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaItem[i];
        }
    };

    public GalleryItem$ImageMediaItem(long j) {
        super(j);
    }

    public GalleryItem$ImageMediaItem(long j, String str, String str2, String str3) {
        super(j, str, str2, str3);
    }

    public final int getType() {
        return 1;
    }

    public final String aNV() {
        if (bh.ov(this.mld)) {
            return this.hOo;
        }
        return this.mld;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hOo);
        parcel.writeString(this.mld);
        parcel.writeLong(this.mRf);
        parcel.writeLong(this.mRg);
        parcel.writeString(this.mMimeType);
    }
}
