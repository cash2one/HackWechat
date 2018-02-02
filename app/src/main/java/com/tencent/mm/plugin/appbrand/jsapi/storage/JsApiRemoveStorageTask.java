package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiRemoveStorageTask extends MainProcessTask {
    public static final Creator<JsApiRemoveStorageTask> CREATOR = new 1();
    public String aAM;
    public String appId;

    public final void Yr() {
        c Zg = f.Zg();
        if (Zg != null) {
            Zg.aM(this.appId, this.aAM);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.aAM);
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.aAM = parcel.readString();
    }
}
