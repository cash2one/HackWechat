package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.h.b.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class b$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ WeakReference jjX;
    final /* synthetic */ b jpw;

    b$1(b bVar, WeakReference weakReference, int i) {
        this.jpw = bVar;
        this.jjX = weakReference;
        this.gOK = i;
    }

    public final void run() {
        String str;
        Object bT;
        String str2 = null;
        String str3 = (String) b.agF().get();
        if (bh.ov(str3)) {
            if (ac.cfA()) {
                try {
                    str = ((IPCString) XIPCInvoker.a("com.tencent.mm", IPCVoid.gNf, a.class)).value;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e, "query updated address path", new Object[0]);
                    str = str2;
                }
            } else {
                str = "";
            }
            if (bh.ov(str)) {
                str2 = str3;
            } else {
                try {
                    bT = e.bT(str);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e2, "read address from file %s", str);
                }
            }
            if (bh.ov(bT)) {
                try {
                    bT = bh.convertStreamToString(ac.getContext().getAssets().open("address"));
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e22, "read address from assets", new Object[0]);
                }
            }
            if (!bh.ov(bT)) {
                b.agF().set(bT);
            }
        } else {
            str2 = str3;
        }
        p pVar = (p) this.jjX.get();
        if (pVar != null && pVar.isRunning()) {
            Map hashMap = new HashMap(1);
            hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, bT);
            pVar.E(this.gOK, this.jpw.e("ok", hashMap));
        }
    }
}
