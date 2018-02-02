package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;

class GalleryItem$VideoMediaItem$1 implements Creator<MediaItem> {
    GalleryItem$VideoMediaItem$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        VideoMediaItem videoMediaItem = new VideoMediaItem();
        videoMediaItem.hOo = parcel.readString();
        videoMediaItem.mld = parcel.readString();
        videoMediaItem.mRf = parcel.readLong();
        videoMediaItem.mMimeType = parcel.readString();
        videoMediaItem.videoWidth = parcel.readInt();
        videoMediaItem.videoHeight = parcel.readInt();
        videoMediaItem.hOr = parcel.readInt();
        videoMediaItem.hOp = parcel.readString();
        videoMediaItem.hOq = parcel.readString();
        videoMediaItem.hOs = parcel.readInt();
        videoMediaItem.videoFrameRate = parcel.readInt();
        videoMediaItem.videoBitRate = parcel.readInt();
        return videoMediaItem;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MediaItem[i];
    }
}
