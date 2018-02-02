package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Creator<MediaBrowserCompat$MediaItem> CREATOR = new 1();
    private final int ur;
    private final MediaDescriptionCompat us;

    private MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.ur = parcel.readInt();
        this.us = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.ur);
        this.us.writeToParcel(parcel, i);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MediaItem{");
        stringBuilder.append("mFlags=").append(this.ur);
        stringBuilder.append(", mDescription=").append(this.us);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
