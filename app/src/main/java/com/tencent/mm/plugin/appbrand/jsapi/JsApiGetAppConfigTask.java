package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiGetAppConfigTask extends MainProcessTask {
    public static final Creator<JsApiGetAppConfigTask> CREATOR = new 2();
    public String aAM;
    public String appId;
    public Runnable jcI;
    public int type;
    public String value;

    public JsApiGetAppConfigTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        m.a(this.appId, this.type, 0, new 1(this), true);
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.aAM = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.aAM);
        parcel.writeString(this.value);
        parcel.writeInt(this.type);
    }
}
