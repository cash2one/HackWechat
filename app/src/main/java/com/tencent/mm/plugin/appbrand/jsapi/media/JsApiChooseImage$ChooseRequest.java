package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessRequest;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a;

final class JsApiChooseImage$ChooseRequest extends AppBrandProxyUIProcessTask$ProcessRequest {
    public static final Creator<JsApiChooseImage$ChooseRequest> CREATOR = new 1();
    String appId;
    int count;
    boolean jmG;
    boolean jmH;
    boolean jmI;
    boolean jmJ;

    protected final Class<? extends AppBrandProxyUIProcessTask> afn() {
        return a.class;
    }

    protected final void h(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.appId = parcel.readString();
        this.count = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.jmG = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.jmH = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.jmI = z;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.jmJ = z2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        parcel.writeString(this.appId);
        parcel.writeInt(this.count);
        if (this.jmG) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.jmH) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.jmI) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.jmJ) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
    }

    protected final String afm() {
        return "GalleryChooseImage";
    }

    protected final boolean afl() {
        return true;
    }

    JsApiChooseImage$ChooseRequest() {
    }

    JsApiChooseImage$ChooseRequest(Parcel parcel) {
        h(parcel);
    }
}
