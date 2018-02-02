package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ae.u;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiScanCode$GetA8KeyTask extends MainProcessTask {
    public static final Creator<JsApiScanCode$GetA8KeyTask> CREATOR = new 2();
    public int actionCode;
    public int fqb;
    public int fqc;
    public String jea;
    public String jeb;
    public Runnable jec;

    public final void Yr() {
        l lVar = new l(this.jea, 36, this.fqb, this.fqc, null, (int) System.currentTimeMillis(), new byte[0]);
        u.a(lVar.gJQ, new 1(this, lVar), true);
    }

    public final void Ys() {
        if (this.jec != null) {
            this.jec.run();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jea);
        parcel.writeInt(this.actionCode);
        parcel.writeString(this.jeb);
        parcel.writeInt(this.fqb);
        parcel.writeInt(this.fqc);
    }

    public final void f(Parcel parcel) {
        this.jea = parcel.readString();
        this.actionCode = parcel.readInt();
        this.jeb = parcel.readString();
        this.fqb = parcel.readInt();
        this.fqc = parcel.readInt();
    }
}
