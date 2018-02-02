package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class RatingCompat$1 implements Creator<RatingCompat> {
    RatingCompat$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new RatingCompat(parcel.readInt(), parcel.readFloat(), (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new RatingCompat[i];
    }
}
