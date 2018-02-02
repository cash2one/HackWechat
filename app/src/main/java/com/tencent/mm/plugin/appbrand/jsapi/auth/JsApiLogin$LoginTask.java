package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.auth.b.a;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.c;
import com.tencent.mm.u.a.d;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class JsApiLogin$LoginTask extends MainProcessTask {
    public static final Creator<JsApiLogin$LoginTask> CREATOR = new Creator<JsApiLogin$LoginTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiLogin$LoginTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiLogin$LoginTask[i];
        }
    };
    public String appId;
    public String code;
    public String data;
    public int iKd;
    public String iVz;
    j jcM;
    public int jcN;
    public String jdO;
    public int jdU;
    b jfT;
    a jfU;
    public Bundle jfV;
    public String jfW;
    public String jfX;
    public int jfY;
    public int jfZ;
    public Bundle jga;
    public int jge;
    public String mAppName;

    public JsApiLogin$LoginTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        a 1 = new 1(this);
        if (this.jfW.equals("login")) {
            x.i("MicroMsg.JsApiLogin", "start login");
            LinkedList linkedList = new LinkedList();
            this.jge = 1;
            this.jdO = "";
            g.Di().gPJ.a(new c(this.appId, linkedList, this.jge, "", this.jdO, this.iKd, this.jdU, new 4(this, 1)), 0);
        } else if (this.jfW.equals("loginConfirm")) {
            x.i("MicroMsg.JsApiLogin", "start loginConfirm");
            a(this.appId, this.jfV, this.jge, this.jdO, this.iKd, this.jfY, 1);
        }
    }

    public final void Ys() {
        afj();
        if (!this.jcM.Vx) {
            return;
        }
        if (this.jfX.equals("ok")) {
            Map hashMap = new HashMap();
            hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.code);
            this.jcM.E(this.jcN, this.jfT.e("ok", hashMap));
            this.jfU.afC();
        } else if (this.jfX.equals("fail")) {
            this.jfT.a(this.jcM, this.jcN, "fail");
            this.jfU.afC();
        } else if (this.jfX.equals("needConfirm")) {
            final LinkedList linkedList = new LinkedList();
            int i = 0;
            while (i < this.jfZ) {
                byte[] byteArray = this.jga.getByteArray(String.valueOf(i));
                bec com_tencent_mm_protocal_c_bec = new bec();
                try {
                    com_tencent_mm_protocal_c_bec.aF(byteArray);
                    linkedList.add(com_tencent_mm_protocal_c_bec);
                    i++;
                } catch (Throwable e) {
                    x.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.JsApiLogin", e, "", new Object[0]);
                    this.jfT.a(this.jcM, this.jcN, "fail");
                    this.jfU.afC();
                    return;
                }
            }
            if (linkedList.size() > 0) {
                ag.y(new Runnable(this) {
                    final /* synthetic */ JsApiLogin$LoginTask jgf;

                    public final void run() {
                        this.jgf.jcM.irP.a(new com.tencent.mm.plugin.appbrand.widget.c.c(this.jgf.jfT.a(this.jgf.jcM), linkedList, this.jgf.mAppName, this.jgf.iVz, new com.tencent.mm.plugin.appbrand.widget.c.c.a(this) {
                            final /* synthetic */ AnonymousClass2 jgg;

                            {
                                this.jgg = r1;
                            }

                            public final void d(int i, Bundle bundle) {
                                x.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                                switch (i) {
                                    case 1:
                                    case 2:
                                        this.jgg.jgf.jfW = "loginConfirm";
                                        this.jgg.jgf.jfV = bundle;
                                        this.jgg.jgf.jfY = i;
                                        AppBrandMainProcessService.a(this.jgg.jgf);
                                        if (i == 2) {
                                            this.jgg.jgf.jfT.a(this.jgg.jgf.jcM, this.jgg.jgf.jcN, "fail auth deny");
                                            this.jgg.jgf.jfU.afC();
                                            return;
                                        }
                                        return;
                                    default:
                                        x.d("MicroMsg.JsApiLogin", "press back button!");
                                        this.jgg.jgf.jfT.a(this.jgg.jgf.jcM, this.jgg.jgf.jcN, "fail auth cancel");
                                        this.jgg.jgf.jfU.afC();
                                        return;
                                }
                            }
                        }));
                    }
                });
                return;
            }
            this.jfT.a(this.jcM, this.jcN, "fail");
            this.jfU.afC();
        }
    }

    public final void f(Parcel parcel) {
        this.data = parcel.readString();
        this.jcN = parcel.readInt();
        this.jfW = parcel.readString();
        this.appId = parcel.readString();
        this.code = parcel.readString();
        this.jfX = parcel.readString();
        this.jdO = parcel.readString();
        this.jge = parcel.readInt();
        this.mAppName = parcel.readString();
        this.iVz = parcel.readString();
        this.jfZ = parcel.readInt();
        this.jga = parcel.readBundle(JsApiLogin.class.getClassLoader());
        this.jfV = parcel.readBundle(JsApiLogin.class.getClassLoader());
        this.iKd = parcel.readInt();
        this.jfY = parcel.readInt();
        this.jdU = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.data);
        parcel.writeInt(this.jcN);
        parcel.writeString(this.jfW);
        parcel.writeString(this.appId);
        parcel.writeString(this.code);
        parcel.writeString(this.jfX);
        parcel.writeString(this.jdO);
        parcel.writeInt(this.jge);
        parcel.writeString(this.mAppName);
        parcel.writeString(this.iVz);
        parcel.writeInt(this.jfZ);
        parcel.writeBundle(this.jga);
        parcel.writeBundle(this.jfV);
        parcel.writeInt(this.iKd);
        parcel.writeInt(this.jfY);
        parcel.writeInt(this.jdU);
    }

    private void a(String str, Bundle bundle, int i, String str2, int i2, int i3, a aVar) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
        LinkedList linkedList = new LinkedList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            linkedList.add((String) it.next());
        }
        g.Di().gPJ.a(new d(str, linkedList, i, str2, i2, i3, this.jdU, new 5(this, aVar, i3)), 0);
    }
}
