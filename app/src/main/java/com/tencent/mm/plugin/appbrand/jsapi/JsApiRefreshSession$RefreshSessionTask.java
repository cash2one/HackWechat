package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.protocal.c.amq;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.cbj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public class JsApiRefreshSession$RefreshSessionTask extends MainProcessTask {
    public static final Creator<JsApiRefreshSession$RefreshSessionTask> CREATOR = new 2();
    String appId;
    private int iKd;
    j jcM;
    int jcN;
    e jdQ;
    private int jdR;
    private int jdS;
    private int jdT;
    int jdU;

    public JsApiRefreshSession$RefreshSessionTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        afi();
        a aVar = new a();
        aVar.hmj = new amq();
        aVar.hmk = new amr();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
        aVar.hmi = 1196;
        aVar.hml = 0;
        aVar.hmm = 0;
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_amq = new amq();
        com_tencent_mm_protocal_c_amq.ngo = this.appId;
        com_tencent_mm_protocal_c_amq.wtc = this.iKd;
        aVar.hmj = com_tencent_mm_protocal_c_amq;
        if (this.jdU > 0) {
            com_tencent_mm_protocal_c_amq.wtd = new cbj();
            com_tencent_mm_protocal_c_amq.wtd.scene = this.jdU;
        }
        x.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", new Object[]{this.appId, Integer.valueOf(this.iKd), Integer.valueOf(this.jdU)});
        u.a(aVar.JZ(), new 1(this), true);
    }

    public final void Ys() {
        Map hashMap = new HashMap();
        switch (this.jdT) {
            case 1:
                hashMap.put("expireIn", this.jdR);
                hashMap.put("errCode", this.jdS);
                this.jcM.E(this.jcN, this.jdQ.e("ok", hashMap));
                break;
            case 2:
                hashMap.put("errCode", this.jdS);
                this.jcM.E(this.jcN, this.jdQ.e("fail", hashMap));
                break;
            default:
                hashMap.put("errCode", "-1");
                this.jcM.E(this.jcN, this.jdQ.e("fail", hashMap));
                break;
        }
        afj();
    }

    public final void f(Parcel parcel) {
        this.jdR = parcel.readInt();
        this.jdS = parcel.readInt();
        this.jdT = parcel.readInt();
        this.jcN = parcel.readInt();
        this.appId = parcel.readString();
        this.iKd = parcel.readInt();
        this.jdU = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.jdR);
        parcel.writeInt(this.jdS);
        parcel.writeInt(this.jdT);
        parcel.writeInt(this.jcN);
        parcel.writeString(this.appId);
        parcel.writeInt(this.iKd);
        parcel.writeInt(this.jdU);
    }
}
