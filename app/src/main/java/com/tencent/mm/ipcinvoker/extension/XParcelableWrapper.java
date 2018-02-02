package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class XParcelableWrapper implements Parcelable {
    public static final Creator<XParcelableWrapper> CREATOR = new 1();
    public f gNb;

    private XParcelableWrapper() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.gNb != null) {
            parcel.writeInt(1);
            parcel.writeString(this.gNb.getClass().getName());
            this.gNb.e(parcel);
            return;
        }
        parcel.writeInt(0);
    }
}
