package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCDouble implements Parcelable {
    public static final Creator<IPCDouble> CREATOR = new 1();
    public double value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.value);
    }

    public String toString() {
        return Double.toString(this.value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IPCDouble)) {
            return obj instanceof Double ? obj.equals(Double.valueOf(this.value)) : false;
        } else {
            if (this.value != ((IPCDouble) obj).value) {
                return false;
            }
            return true;
        }
    }
}
