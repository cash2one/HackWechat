package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ String iSm;
    final /* synthetic */ int tlS;
    final /* synthetic */ String tlT;
    final /* synthetic */ c tlU;

    public c$1(c cVar, int i, String str, String str2) {
        this.tlU = cVar;
        this.tlS = i;
        this.iSm = str;
        this.tlT = str2;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (kVar.getType() == 2608) {
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.FTS.FTSWebSearchLogic", "getPoiInfo onSceneEnd errType:" + i + " errCode:" + i2 + " will retry");
            } else if (bVar != null) {
                bfg com_tencent_mm_protocal_c_bfg = (bfg) bVar.hmh.hmo;
                g Be = h.Be(this.tlS);
                String str2 = this.iSm;
                String str3 = this.tlT;
                String str4 = com_tencent_mm_protocal_c_bfg.vOe;
                Bundle bundle = new Bundle();
                bundle.putString("searchId", str2);
                bundle.putString("poiId", str3);
                bundle.putString("json", str4);
                try {
                    if (Be.fBH != null) {
                        Be.fBH.n(c.CTRL_INDEX, bundle);
                    }
                } catch (RemoteException e) {
                    x.w("MicroMsg.MsgHandler", "onGetPoiReady exception" + e.getMessage());
                }
            }
        }
        return 0;
    }
}
