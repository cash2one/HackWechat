package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class PlaybackStateCompat$CustomAction implements Parcelable {
    public static final Creator<PlaybackStateCompat$CustomAction> CREATOR = new 1();
    private final Bundle mExtras;
    private final CharSequence vA;
    private final int vB;
    private final String vz;

    private PlaybackStateCompat$CustomAction(Parcel parcel) {
        this.vz = parcel.readString();
        this.vA = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.vB = parcel.readInt();
        this.mExtras = parcel.readBundle();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.vz);
        TextUtils.writeToParcel(this.vA, parcel, i);
        parcel.writeInt(this.vB);
        parcel.writeBundle(this.mExtras);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "Action:mName='" + this.vA + ", mIcon=" + this.vB + ", mExtras=" + this.mExtras;
    }
}
