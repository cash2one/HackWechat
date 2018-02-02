package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.auth.b.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.c.c;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiAuthorize extends b {
    private static final int CTRL_INDEX = 54;
    private static final String NAME = "authorize";

    private static class AuthorizeTask extends MainProcessTask {
        public static final Creator<AuthorizeTask> CREATOR = new 3();
        public String appId;
        public String data;
        public int iKd;
        public String iVz;
        j jcM;
        public int jcN;
        private int jdU;
        b jfT;
        a jfU;
        public Bundle jfV;
        public String jfW;
        public String jfX;
        public int jfY;
        public int jfZ;
        public Bundle jga;
        public String mAppName;

        public AuthorizeTask(Parcel parcel) {
            f(parcel);
        }

        public final void Yr() {
            a 1 = new 1(this);
            if (this.jfW.equals("authorize")) {
                try {
                    JSONArray jSONArray = new JSONArray(new JSONObject(this.data).optString("scope"));
                    LinkedList linkedList = new LinkedList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        linkedList.add(jSONArray.optString(i));
                    }
                    g.Di().gPJ.a(new com.tencent.mm.u.a.a(this.appId, linkedList, this.iKd, this.jdU, new 4(this, 1)), 0);
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiAuthorize", "Exception %s", new Object[]{e.getMessage()});
                    this.jfX = "fail";
                    afp();
                }
            } else if (this.jfW.equals("authorizeConfirm")) {
                a(this.appId, this.jfV, this.iKd, this.jfY, 1);
            }
        }

        public final void Ys() {
            afj();
            if (!this.jcM.Vx) {
                return;
            }
            if (this.jfX.equals("ok")) {
                this.jfT.a(this.jcM, this.jcN, "ok");
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
                        x.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[]{e.getMessage()});
                        x.printErrStackTrace("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                        this.jfT.a(this.jcM, this.jcN, "fail");
                        this.jfU.afC();
                        return;
                    }
                }
                if (linkedList.size() > 0) {
                    ag.y(new Runnable(this) {
                        final /* synthetic */ AuthorizeTask jgb;

                        public final void run() {
                            this.jgb.jcM.irP.a(new c(this.jgb.jfT.a(this.jgb.jcM), linkedList, this.jgb.mAppName, this.jgb.iVz, new 1(this)));
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
            this.appId = parcel.readString();
            this.jfX = parcel.readString();
            this.jfW = parcel.readString();
            this.mAppName = parcel.readString();
            this.iVz = parcel.readString();
            this.jfZ = parcel.readInt();
            this.jga = parcel.readBundle(JsApiAuthorize.class.getClassLoader());
            this.jfV = parcel.readBundle(JsApiAuthorize.class.getClassLoader());
            this.iKd = parcel.readInt();
            this.jfY = parcel.readInt();
            this.jdU = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.data);
            parcel.writeInt(this.jcN);
            parcel.writeString(this.appId);
            parcel.writeString(this.jfX);
            parcel.writeString(this.jfW);
            parcel.writeString(this.mAppName);
            parcel.writeString(this.iVz);
            parcel.writeInt(this.jfZ);
            parcel.writeBundle(this.jga);
            parcel.writeBundle(this.jfV);
            parcel.writeInt(this.iKd);
            parcel.writeInt(this.jfY);
            parcel.writeInt(this.jdU);
        }

        private void a(String str, Bundle bundle, int i, int i2, a aVar) {
            ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
            LinkedList linkedList = new LinkedList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                linkedList.add((String) it.next());
            }
            g.Di().gPJ.a(new b(str, linkedList, i, i2, this.jdU, new 5(this, aVar, i2)), 0);
        }
    }

    public final /* bridge */ /* synthetic */ void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
    }

    public final void a(j jVar, JSONObject jSONObject, int i, a aVar) {
        x.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
        MainProcessTask authorizeTask = new AuthorizeTask();
        authorizeTask.appId = jVar.mAppId;
        authorizeTask.jfW = "authorize";
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        if (appBrandSysConfig != null) {
            authorizeTask.iKd = appBrandSysConfig.iOI.iGK;
        }
        AppBrandStatObject oT = com.tencent.mm.plugin.appbrand.a.oT(jVar.mAppId);
        if (oT != null) {
            authorizeTask.jdU = oT.scene;
        }
        String jSONObject2 = jSONObject.toString();
        authorizeTask.jfT = this;
        authorizeTask.jcM = jVar;
        authorizeTask.data = jSONObject2;
        authorizeTask.jcN = i;
        authorizeTask.jfU = aVar;
        authorizeTask.jga = new Bundle();
        authorizeTask.afi();
        AppBrandMainProcessService.a(authorizeTask);
    }
}
