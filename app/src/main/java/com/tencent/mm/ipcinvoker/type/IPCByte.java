package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCByte implements Parcelable {
    public static final Creator<IPCByte> CREATOR = new 1();
    public byte value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.value);
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IPCByte)) {
            return obj instanceof Byte ? obj.equals(Byte.valueOf(this.value)) : false;
        } else {
            if (this.value != ((IPCByte) obj).value) {
                return false;
            }
            return true;
        }
    }
}
