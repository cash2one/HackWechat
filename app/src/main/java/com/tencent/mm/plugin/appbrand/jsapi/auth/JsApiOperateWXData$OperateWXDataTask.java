package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.i.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.auth.b.a;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class JsApiOperateWXData$OperateWXDataTask extends MainProcessTask {
    public static final Creator<JsApiOperateWXData$OperateWXDataTask> CREATOR = new 3();
    public String appId;
    public int iKd;
    public String iVz;
    j jcM;
    public int jcN;
    int jdU;
    b jfT;
    a jfU;
    public String jfW;
    public String jfX;
    public int jfY;
    public int jfZ;
    public Bundle jga;
    public String jgi;
    public String jgj;
    public String jgk;
    public String mAppName;

    public JsApiOperateWXData$OperateWXDataTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        a 1 = new 1(this);
        if (this.jfW.equals(JsApiOperateWXData.NAME)) {
            a(this.appId, this.jgi, "", this.iKd, this.jfY, 1);
        } else if (this.jfW.equals("operateWXDataConfirm")) {
            a(this.appId, this.jgi, this.jgk, this.iKd, this.jfY, 1);
        }
    }

    public final void Ys() {
        afj();
        if (!this.jcM.Vx) {
            return;
        }
        if (this.jfX.equals("ok")) {
            Map hashMap = new HashMap();
            hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, this.jgj);
            this.jcM.E(this.jcN, this.jfT.e("ok", hashMap));
            this.jfU.afC();
        } else if (this.jfX.contains("fail")) {
            this.jfT.a(this.jcM, this.jcN, this.jfX);
            this.jfU.afC();
        } else if (this.jfX.equals("needConfirm")) {
            LinkedList linkedList = new LinkedList();
            int i = 0;
            while (i < this.jfZ) {
                byte[] byteArray = this.jga.getByteArray(String.valueOf(i));
                bec com_tencent_mm_protocal_c_bec = new bec();
                try {
                    com_tencent_mm_protocal_c_bec.aF(byteArray);
                    linkedList.add(com_tencent_mm_protocal_c_bec);
                    i++;
                } catch (Throwable e) {
                    x.e("MicroMsg.JsApiOperateWXData", "IOException %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                    this.jfT.a(this.jcM, this.jcN, "fail");
                    this.jfU.afC();
                    return;
                }
            }
            if (linkedList.size() > 0) {
                ag.y(new 2(this, linkedList));
                return;
            }
            this.jfT.a(this.jcM, this.jcN, "fail");
            this.jfU.afC();
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.jfX = parcel.readString();
        this.mAppName = parcel.readString();
        this.iVz = parcel.readString();
        this.jgi = parcel.readString();
        this.jgj = parcel.readString();
        this.jcN = parcel.readInt();
        this.jfW = parcel.readString();
        this.jgk = parcel.readString();
        this.jfZ = parcel.readInt();
        this.jga = parcel.readBundle(JsApiOperateWXData.class.getClassLoader());
        this.iKd = parcel.readInt();
        this.jfY = parcel.readInt();
        this.jdU = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.jfX);
        parcel.writeString(this.mAppName);
        parcel.writeString(this.iVz);
        parcel.writeString(this.jgi);
        parcel.writeString(this.jgj);
        parcel.writeInt(this.jcN);
        parcel.writeString(this.jfW);
        parcel.writeString(this.jgk);
        parcel.writeInt(this.jfZ);
        parcel.writeBundle(this.jga);
        parcel.writeInt(this.iKd);
        parcel.writeInt(this.jfY);
        parcel.writeInt(this.jdU);
    }

    private void a(String str, String str2, String str3, int i, int i2, a aVar) {
        g.Di().gPJ.a(new b(str, str2, str3, i, i2, this.jdU, new 4(this, aVar, i2)), 0);
    }
}
