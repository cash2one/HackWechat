package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ParcelableVolumeInfo$1 implements Creator<ParcelableVolumeInfo> {
    ParcelableVolumeInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ParcelableVolumeInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ParcelableVolumeInfo[i];
    }
}
