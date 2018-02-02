package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class MediaMetadataCompat$1 implements Creator<MediaMetadataCompat> {
    MediaMetadataCompat$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new MediaMetadataCompat(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MediaMetadataCompat[i];
    }
}
