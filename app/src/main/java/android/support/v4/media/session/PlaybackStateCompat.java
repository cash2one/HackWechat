package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new Creator<PlaybackStateCompat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };
    private final Bundle mExtras;
    private final int mState;
    private final long vr;
    private final long vs;
    private final float vt;
    private final long vu;
    private final CharSequence vv;
    private final long vw;
    private List<CustomAction> vx;
    private final long vy;

    private PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.vr = parcel.readLong();
        this.vt = parcel.readFloat();
        this.vw = parcel.readLong();
        this.vs = parcel.readLong();
        this.vu = parcel.readLong();
        this.vv = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.vx = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.vy = parcel.readLong();
        this.mExtras = parcel.readBundle();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.mState);
        stringBuilder.append(", position=").append(this.vr);
        stringBuilder.append(", buffered position=").append(this.vs);
        stringBuilder.append(", speed=").append(this.vt);
        stringBuilder.append(", updated=").append(this.vw);
        stringBuilder.append(", actions=").append(this.vu);
        stringBuilder.append(", error=").append(this.vv);
        stringBuilder.append(", custom actions=").append(this.vx);
        stringBuilder.append(", active item id=").append(this.vy);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.vr);
        parcel.writeFloat(this.vt);
        parcel.writeLong(this.vw);
        parcel.writeLong(this.vs);
        parcel.writeLong(this.vu);
        TextUtils.writeToParcel(this.vv, parcel, i);
        parcel.writeTypedList(this.vx);
        parcel.writeLong(this.vy);
        parcel.writeBundle(this.mExtras);
    }
}
