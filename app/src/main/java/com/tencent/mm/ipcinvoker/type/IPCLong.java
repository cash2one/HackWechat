package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCLong implements Parcelable {
    public static final Creator<IPCLong> CREATOR = new 1();
    public long value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.value);
    }

    public String toString() {
        return Long.toString(this.value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IPCLong)) {
            return obj instanceof Long ? obj.equals(Long.valueOf(this.value)) : false;
        } else {
            if (this.value != ((IPCLong) obj).value) {
                return false;
            }
            return true;
        }
    }
}
