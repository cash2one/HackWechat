package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.wx_extension.b$a;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.canvas.widget.b;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.protocal.c.rq;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.c.e;
import com.tencent.mm.u.c.f;
import com.tencent.mm.z.u$b;

public final class c implements b {
    boolean Vx;
    String appId;
    volatile e gOM;
    String gOP;
    String iKB;
    int iRK;
    String iRL;
    g iRM;
    String iRN;
    volatile boolean iRO;
    private volatile boolean iRP;
    boolean iRQ = false;
    boolean iRR = false;
    private b$a iRS;
    Runnable iRT;
    Context mContext;
    String mUrl;

    private static class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            String string = bundle.getString("widgetId");
            String string2 = bundle.getString("respData");
            if (!bh.ov(string)) {
                IPCDynamicPageView rv = com.tencent.mm.plugin.appbrand.dynamic.h.a.ade().rv(string);
                if (rv != null) {
                    p anonymousClass1 = new p(this) {
                        final /* synthetic */ a iRV;

                        {
                            this.iRV = r1;
                        }

                        public final void b(boolean z, String str, Bundle bundle) {
                        }
                    };
                    if (rv.iVn == null) {
                        anonymousClass1.b(false, "listener is null", null);
                        return;
                    }
                    t tVar = (t) rv.iVn.iy("OnDataPush");
                    if (tVar == null) {
                        anonymousClass1.b(false, "listener is null", null);
                    } else {
                        tVar.Y(string, string2);
                    }
                }
            }
        }
    }

    public c(Context context) {
        this.mContext = context;
        this.iRS = new 1(this);
        this.iRT = new Runnable(this) {
            final /* synthetic */ c iRU;

            {
                this.iRU = r1;
            }

            public final void run() {
                this.iRU.acD();
            }
        };
    }

    public final boolean aY(String str, String str2) {
        if (this.gOM == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        f fVar = this.gOM.gOR;
        com.tencent.mm.u.b.e fs = fVar.gOV.fs(str);
        if (fs == null) {
            x.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[]{str});
            return false;
        } else if (fVar.gOH.gn(fs.getIndex())) {
            if (bh.ov(str2)) {
                str2 = "{}";
            }
            x.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[]{str, Integer.valueOf(str2.length()), Integer.valueOf(0)});
            fVar.gOS.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[]{str, str2, "undefined", f.Cc()}), null);
            return true;
        } else {
            x.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[]{str});
            return false;
        }
    }

    void cleanup() {
        if (this.iRM != null) {
            x.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s, %s)", new Object[]{this.iRM.field_id, this.iRM.field_appId, this.iRM.field_cacheKey});
        } else {
            x.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
        }
        if (this.gOM != null) {
            e eVar = this.gOM;
            x.v("MicroMsg.MiniJsBridge", "onStop(%s)", new Object[]{eVar.gOP});
            eVar.Vx = false;
            eVar.gOS.cleanup();
            com.tencent.mm.u.c.c cVar = eVar.gOQ;
            cVar.gOJ.quit();
            cVar.gOG.gON.recycle();
            if (eVar.gOU != null) {
                eVar.gOU.B(eVar.gOP, 4);
                eVar.gOU = null;
            }
        }
    }

    final void acD() {
        g gVar = this.iRM;
        if (gVar != null && this.Vx) {
            if (this.iRO) {
                this.iRP = true;
            } else if (bh.ov(gVar.field_appId)) {
                x.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", new Object[]{this.gOP});
            } else {
                this.iRP = false;
                long currentTimeMillis = (gVar.field_updateTime + (((long) gVar.field_interval) * 1000)) - System.currentTimeMillis();
                if (currentTimeMillis > 0) {
                    x.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", new Object[]{Long.valueOf(currentTimeMillis)});
                    b.d(this.iRT, currentTimeMillis);
                    return;
                }
                x.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s, %s)", new Object[]{this.iRM.field_id, this.iRM.field_appId, this.iRM.field_cacheKey});
                com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
                aVar.hmi = 1193;
                aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
                com.tencent.mm.bq.a rqVar = new rq();
                rqVar.fFm = gVar.field_appId;
                rqVar.aAM = gVar.field_cacheKey;
                rqVar.scene = this.iRK;
                rqVar.fDj = this.iRL;
                rqVar.url = this.mUrl;
                aVar.hmj = rqVar;
                aVar.hmk = new rr();
                com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.JZ(), this.iRS);
            }
        }
    }

    static void a(e eVar, g gVar) {
        boolean z = false;
        if (eVar == null || gVar == null || bh.ov(gVar.field_data)) {
            boolean z2;
            String str = "MicroMsg.DynamicPageViewIPCProxy";
            String str2 = "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null";
            Object[] objArr = new Object[2];
            if (eVar == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (gVar == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            return;
        }
        com.tencent.mm.u.b.c cVar = new com.tencent.mm.plugin.appbrand.dynamic.f.c();
        cVar.data = gVar.field_data;
        eVar.a(cVar);
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", gVar.field_id);
        bundle.putString("respData", gVar.field_data);
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:tools", bundle, a.class, null);
    }

    public final void o(Bundle bundle) {
        if (bundle != null) {
            u$b com_tencent_mm_z_u_b = this.gOM.gOQ.gOG.gON;
            for (String str : bundle.keySet()) {
                com_tencent_mm_z_u_b.o(str, bundle.get(str));
            }
        }
    }

    public final void onPause() {
        x.i("MicroMsg.DynamicPageViewIPCProxy", "onPause(%s)", new Object[]{this.gOP});
        this.iRO = true;
        if (this.gOM != null) {
            this.gOM.b(new com.tencent.mm.plugin.appbrand.dynamic.f.f());
        }
    }

    public final void onResume() {
        x.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", new Object[]{this.gOP});
        boolean z = this.iRO;
        if (this.gOM != null) {
            this.gOM.c(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
        }
        this.iRO = false;
        if (z && this.iRP) {
            acD();
        }
    }

    public final boolean isPaused() {
        return this.iRO;
    }
}
