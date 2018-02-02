package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a;

final class JsApiChooseVideo$ChooseRequest extends ProcessRequest {
    public static final Creator<JsApiChooseVideo$ChooseRequest> CREATOR = new 1();
    String appId;
    boolean jmG;
    boolean jmH;
    boolean jnr;
    int maxDuration;

    protected final Class<? extends AppBrandProxyUIProcessTask> afn() {
        return a.class;
    }

    protected final String afm() {
        return "GalleryChooseVideo";
    }

    protected final void h(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.appId = parcel.readString();
        this.maxDuration = parcel.readInt();
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
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.jnr = z2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        parcel.writeString(this.appId);
        parcel.writeInt(this.maxDuration);
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
        if (!this.jnr) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
    }

    protected final boolean afl() {
        return true;
    }

    JsApiChooseVideo$ChooseRequest() {
    }

    JsApiChooseVideo$ChooseRequest(Parcel parcel) {
        h(parcel);
    }
}
