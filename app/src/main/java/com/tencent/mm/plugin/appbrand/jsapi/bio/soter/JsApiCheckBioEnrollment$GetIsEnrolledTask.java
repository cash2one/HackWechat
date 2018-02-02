package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiCheckBioEnrollment$GetIsEnrolledTask extends MainProcessTask {
    public static final Creator<JsApiCheckBioEnrollment$GetIsEnrolledTask> CREATOR = new 1();
    private j iqB = null;
    private int jcs = -1;
    private JsApiCheckBioEnrollment jhu;
    private int jhv = -1;
    private int jhw = -1;

    public final void Ys() {
        boolean z = false;
        super.Ys();
        x.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[]{Integer.valueOf(this.jhw)});
        Map hashMap = new HashMap(2);
        String str = "isEnrolled";
        if (this.jhw == 1) {
            z = true;
        }
        hashMap.put(str, Boolean.valueOf(z));
        if (this.jhw == 0) {
            this.iqB.E(this.jcs, this.jhu.e("ok", hashMap));
        } else if (this.jhw == -1) {
            this.iqB.E(this.jcs, this.jhu.e("fail not support", hashMap));
        } else if (this.jhw == 1) {
            this.iqB.E(this.jcs, this.jhu.e("ok", hashMap));
        } else {
            this.iqB.E(this.jcs, this.jhu.e("fail unknown error", hashMap));
        }
        c.bk(this);
    }

    public final void Yr() {
        b hjVar = new hj();
        hjVar.fxE.fxG = this.jhv;
        a.xef.m(hjVar);
        this.jhw = hjVar.fxF.fxH;
        x.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[]{Integer.valueOf(this.jhw)});
        afp();
    }

    public JsApiCheckBioEnrollment$GetIsEnrolledTask(j jVar, int i, int i2, JsApiCheckBioEnrollment jsApiCheckBioEnrollment) {
        this.iqB = jVar;
        this.jcs = i;
        this.jhu = jsApiCheckBioEnrollment;
        this.jhv = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.jhw);
        parcel.writeInt(this.jhv);
    }

    protected JsApiCheckBioEnrollment$GetIsEnrolledTask(Parcel parcel) {
        f(parcel);
    }

    public final void f(Parcel parcel) {
        super.f(parcel);
        this.jhw = parcel.readInt();
        this.jhv = parcel.readInt();
    }
}
