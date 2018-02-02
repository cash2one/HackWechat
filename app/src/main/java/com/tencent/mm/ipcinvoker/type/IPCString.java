package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCString implements Parcelable {
    public static final Creator<IPCString> CREATOR = new 1();
    public String value;

    public IPCString(String str) {
        this.value = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.value);
    }

    public String toString() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IPCString)) {
            return obj instanceof String ? obj.equals(this.value) : false;
        } else {
            IPCString iPCString = (IPCString) obj;
            if (this.value == iPCString.value) {
                return true;
            }
            if (this.value == null || !this.value.equals(iPCString.value)) {
                return false;
            }
            return true;
        }
    }
}
