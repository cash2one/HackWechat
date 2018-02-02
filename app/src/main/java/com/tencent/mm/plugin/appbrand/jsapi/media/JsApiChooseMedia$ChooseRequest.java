package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiChooseMedia$ChooseRequest extends ProcessRequest {
    public static final Creator<JsApiChooseMedia$ChooseRequest> CREATOR = new Creator<JsApiChooseMedia$ChooseRequest>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiChooseMedia$ChooseRequest(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiChooseMedia$ChooseRequest[i];
        }
    };
    String appId;
    int count;
    boolean isFront;
    boolean jmI;
    boolean jmJ;
    boolean jmZ;
    boolean jna;
    boolean jnb;
    boolean jnc;
    int maxDuration;

    protected final Class<? extends AppBrandProxyUIProcessTask> afn() {
        return JsApiChooseMedia$a.class;
    }

    protected final String afm() {
        return "GalleryChooseMedia";
    }

    protected final void h(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.appId = parcel.readString();
        this.jmZ = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.jna = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.jnb = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.jnc = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.isFront = z;
        this.maxDuration = parcel.readInt();
        this.count = parcel.readInt();
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
        parcel.writeByte(this.jmZ ? (byte) 1 : (byte) 0);
        if (this.jna) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.jnb) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.jnc) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.isFront) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeInt(this.maxDuration);
        parcel.writeInt(this.count);
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

    protected final boolean afl() {
        return true;
    }

    JsApiChooseMedia$ChooseRequest() {
    }

    JsApiChooseMedia$ChooseRequest(Parcel parcel) {
        h(parcel);
    }
}
