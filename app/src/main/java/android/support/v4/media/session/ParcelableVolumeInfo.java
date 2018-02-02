package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new 1();
    public int vm;
    public int vn;
    public int vo;
    public int vp;
    public int vq;

    public ParcelableVolumeInfo(Parcel parcel) {
        this.vm = parcel.readInt();
        this.vo = parcel.readInt();
        this.vp = parcel.readInt();
        this.vq = parcel.readInt();
        this.vn = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.vm);
        parcel.writeInt(this.vo);
        parcel.writeInt(this.vp);
        parcel.writeInt(this.vq);
        parcel.writeInt(this.vn);
    }
}
