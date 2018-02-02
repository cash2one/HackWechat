package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.PlaybackStateCompat.CustomAction;

class PlaybackStateCompat$CustomAction$1 implements Creator<CustomAction> {
    PlaybackStateCompat$CustomAction$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new CustomAction(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CustomAction[i];
    }
}
