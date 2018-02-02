package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class JsApiUpdateApp$SyncResult implements Parcelable {
    public static final Creator<JsApiUpdateApp$SyncResult> CREATOR = new 1();
    private int fIm;
    private boolean jrJ;

    JsApiUpdateApp$SyncResult(boolean z, int i) {
        this.jrJ = z;
        this.fIm = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.jrJ ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.fIm);
    }

    JsApiUpdateApp$SyncResult(Parcel parcel) {
        this.jrJ = parcel.readByte() != (byte) 0;
        this.fIm = parcel.readInt();
    }
}
