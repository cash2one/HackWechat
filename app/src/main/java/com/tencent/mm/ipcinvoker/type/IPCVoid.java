package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCVoid implements Parcelable {
    public static final Creator<IPCVoid> CREATOR = new 1();
    public static final IPCVoid gNf = new IPCVoid();

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
