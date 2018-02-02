package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask extends MainProcessTask {
    public static final Creator<JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask> CREATOR = new 2();
    public int fDt = 0;
    public long fmZ = 0;
    private c jcH;
    Runnable jcI;

    public final void Yr() {
        x.i("MicroMsg.JsApiAddNativeDownloadTask", "runInMainProcess flag:%d", new Object[]{Integer.valueOf(this.fDt)});
        this.jcH = new 1(this);
        a.xef.a(this.jcH);
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    public final void f(Parcel parcel) {
        this.fDt = parcel.readInt();
        this.fmZ = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fDt);
        parcel.writeLong(this.fmZ);
    }
}
