package com.tencent.mm.plugin.appbrand.game;

import android.graphics.Point;
import android.view.WindowManager;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.d$b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends j implements g {
    k iXb;
    long iXc;
    long iXd;
    long iXe;
    b irR;

    protected final b YM() {
        this.irR = new f(this);
        this.iXb = new k(this, this.irR);
        return this.irR;
    }

    protected final com.tencent.mm.plugin.appbrand.jsapi.d YN() {
        com.tencent.mm.plugin.appbrand.jsapi.d dVar = new com.tencent.mm.plugin.appbrand.jsapi.d(this, this.irR);
        this.irR.addJavascriptInterface(dVar, "WeixinJSCore");
        return dVar;
    }

    public final void init() {
        x.i("MicroMsg.WAGameAppService", "WAGameAppService.init");
        if (this.irP != null) {
            this.irP.iqM.o(7, this.irX);
        }
        e(new 1(this));
    }

    final boolean adG() {
        return this.iXb != null && this.iXb.adZ();
    }

    public final void cleanup() {
        super.cleanup();
        k kVar = this.iXb;
        synchronized (kVar) {
            kVar.iXD = null;
            kVar.iXF = null;
            kVar.iXE = null;
            kVar.iXG = null;
            kVar.iXC = false;
        }
    }

    protected final JSONObject d(JSONObject jSONObject) {
        JSONObject jSONObject2;
        boolean z;
        int i = 0;
        AppBrandSysConfig appBrandSysConfig = this.irP.iqx;
        JSONObject jSONObject3 = null;
        try {
            jSONObject3 = jSONObject.optJSONObject("wxAppInfo");
        } catch (Exception e) {
        }
        if (jSONObject3 == null) {
            jSONObject2 = new JSONObject();
        } else {
            jSONObject2 = jSONObject3;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (Object put : appBrandSysConfig.iOJ.iNF) {
                jSONArray.put(put);
            }
            a(jSONObject2, "subContextImgDomain", jSONArray);
        } catch (Exception e2) {
        }
        a(jSONObject, "wxAppInfo", jSONObject2);
        Point point = new Point();
        l.iXJ.b(point);
        float density = a.getDensity(getContext());
        x.i("MicroMsg.WAGameAppService", "dm.widthPixels %d, dm.heightPixels %d", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y)});
        e eVar = this.irP;
        switch (((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                z = true;
                break;
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                z = false;
                break;
            default:
                z = true;
                break;
        }
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex] isCurrentPortrait %b, isGameShouldPortrait %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(com.tencent.mm.plugin.appbrand.config.d.a(eVar.iqw, eVar.iqy) == d$b.PORTRAIT)});
        if (z == (com.tencent.mm.plugin.appbrand.config.d.a(eVar.iqw, eVar.iqy) == d$b.PORTRAIT)) {
            i = 1;
        }
        if (i != 0) {
            x.i("MicroMsg.WAGameAppService", "screen in right orientation");
            a(jSONObject, "screenWidth", Float.valueOf(((float) point.x) / density));
            a(jSONObject, "screenHeight", Float.valueOf(((float) point.y) / density));
        } else {
            x.w("MicroMsg.WAGameAppService", "screen in reverse orientation");
            a(jSONObject, "screenWidth", Float.valueOf(((float) point.y) / density));
            a(jSONObject, "screenHeight", Float.valueOf(((float) point.x) / density));
        }
        a(jSONObject, "devicePixelRatio", Float.valueOf(density));
        if (adG()) {
            a(jSONObject, "isIsolateContext", Boolean.valueOf(true));
        }
        return jSONObject;
    }

    public final void E(int i, String str) {
        if (this.Vx) {
            e(new 2(this, i, str));
        }
    }

    public final void h(final String str, final String str2, final int i) {
        if (this.Vx) {
            e(new Runnable(this) {
                final /* synthetic */ d iXf;

                public final void run() {
                    super.h(str, str2, i);
                }
            });
        }
    }

    private void e(Runnable runnable) {
        c cVar;
        p aex = this.irP.iqC.aiT().aex();
        if (aex instanceof c) {
            cVar = (c) aex;
        } else {
            x.e("MicroMsg.WAGameAppService", "runOnRenderThread can't find the IRenderThreadHandler");
            cVar = null;
        }
        if (cVar != null) {
            cVar.e(runnable);
        } else {
            x.e("MicroMsg.WAGameAppService", "runOnRenderThread can't find the IRenderThreadHandler");
        }
    }
}
