package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCBoolean implements Parcelable {
    public static final Creator<IPCBoolean> CREATOR = new 1();
    public boolean value;

    public IPCBoolean(boolean z) {
        this.value = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.value ? 1 : 0);
    }

    public String toString() {
        return Boolean.toString(this.value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IPCBoolean)) {
            return obj instanceof Boolean ? obj.equals(Boolean.valueOf(this.value)) : false;
        } else {
            if (this.value != ((IPCBoolean) obj).value) {
                return false;
            }
            return true;
        }
    }
}
