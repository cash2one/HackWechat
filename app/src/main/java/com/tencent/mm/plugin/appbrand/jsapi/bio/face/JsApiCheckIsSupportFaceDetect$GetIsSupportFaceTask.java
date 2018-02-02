package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask extends MainProcessTask {
    public static final Creator<JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask> CREATOR = new 1();
    private int errCode = -1;
    private boolean fIP = false;
    private String fnL = "not returned";
    private j iqB = null;
    private int jcs = -1;
    private JsApiCheckIsSupportFaceDetect jhq;
    private int jhr = -1;

    public final void Ys() {
        super.Ys();
        x.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", new Object[]{Boolean.valueOf(this.fIP), Integer.valueOf(this.errCode), this.fnL, Integer.valueOf(this.jhr)});
        Map hashMap = new HashMap(3);
        hashMap.put("errCode", Integer.valueOf(this.errCode));
        hashMap.put("libVersionCode", Integer.valueOf(this.jhr));
        if (this.errCode == 0) {
            this.iqB.E(this.jcs, this.jhq.e("ok", hashMap));
        } else {
            this.iqB.E(this.jcs, this.jhq.e("fail " + this.fnL, hashMap));
        }
        c.bk(this);
    }

    public final void Yr() {
        b hkVar = new hk();
        a.xef.m(hkVar);
        this.fIP = hkVar.fxI.fxJ;
        this.errCode = hkVar.fxI.fxK;
        this.fnL = hkVar.fxI.fxL;
        this.jhr = hkVar.fxI.fxM;
        x.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[]{Boolean.valueOf(this.fIP), Integer.valueOf(this.errCode), this.fnL, Integer.valueOf(this.jhr)});
        afp();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.fIP ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.fnL);
        parcel.writeInt(this.jhr);
    }

    public JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask(j jVar, int i, JsApiCheckIsSupportFaceDetect jsApiCheckIsSupportFaceDetect) {
        this.iqB = jVar;
        this.jcs = i;
        this.jhq = jsApiCheckIsSupportFaceDetect;
    }

    protected JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask(Parcel parcel) {
        f(parcel);
    }

    public final void f(Parcel parcel) {
        super.f(parcel);
        this.fIP = parcel.readByte() != (byte) 0;
        this.errCode = parcel.readInt();
        this.fnL = parcel.readString();
        this.jhr = parcel.readInt();
    }
}
