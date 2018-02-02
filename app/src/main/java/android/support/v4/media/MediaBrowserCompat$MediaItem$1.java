package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaBrowserCompat.MediaItem;

class MediaBrowserCompat$MediaItem$1 implements Creator<MediaItem> {
    MediaBrowserCompat$MediaItem$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new MediaItem(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MediaItem[i];
    }
}
