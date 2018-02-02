package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;

class GalleryItem$AlbumItem$1 implements Creator<AlbumItem> {
    GalleryItem$AlbumItem$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AlbumItem(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AlbumItem[i];
    }
}
