package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashMap;
import java.util.Map;

class JsApiStartPlayVoice$StartPlayVoice extends MainProcessTask {
    public static final Creator<JsApiStartPlayVoice$StartPlayVoice> CREATOR = new 2();
    public String filePath;
    public String fus;
    private e jcL;
    private j jcM;
    private int jcN;
    public boolean jeA = false;

    public JsApiStartPlayVoice$StartPlayVoice(e eVar, j jVar, int i) {
        this.jcL = eVar;
        this.jcM = jVar;
        this.jcN = i;
    }

    public JsApiStartPlayVoice$StartPlayVoice(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        ag.y(new Runnable(this) {
            final /* synthetic */ JsApiStartPlayVoice$StartPlayVoice jfD;

            {
                this.jfD = r1;
            }

            public final void run() {
                ((d) g.h(d.class)).a(this.jfD.filePath, new 1(this), new 2(this));
            }
        });
    }

    public final void Ys() {
        Map hashMap = new HashMap();
        hashMap.put("localId", this.fus);
        this.jcM.E(this.jcN, this.jcL.e(this.jeA ? "fail" : "ok", hashMap));
        JsApiStartPlayVoice.jfz = null;
    }

    public final void f(Parcel parcel) {
        this.fus = parcel.readString();
        this.filePath = parcel.readString();
        this.jeA = parcel.readByte() != (byte) 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fus);
        parcel.writeString(this.filePath);
        parcel.writeByte(this.jeA ? (byte) 1 : (byte) 0);
    }
}
