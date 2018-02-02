package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WidgetRuntimeConfig implements Parcelable {
    public static final Creator<WidgetRuntimeConfig> CREATOR = new 1();
    public String appId;
    public int iUf;
    public int iUv = 32;
    public boolean iUw = false;
    public boolean iUx = true;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.appId);
        parcel.writeInt(this.iUf);
        parcel.writeInt(this.iUv);
        if (this.iUw) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.iUx) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
