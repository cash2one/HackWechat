package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b$a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.protocal.c.bsd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class bq$1 implements b$a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ bq jeu;

    bq$1(bq bqVar, j jVar, int i) {
        this.jeu = bqVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        boolean z = true;
        if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
            bsd com_tencent_mm_protocal_c_bsd = (bsd) bVar.hmh.hmo;
            Map hashMap = new HashMap();
            try {
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, new JSONObject(com_tencent_mm_protocal_c_bsd.wTx));
                this.iZy.E(this.gOK, this.jeu.e("ok", hashMap));
                return;
            } catch (Exception e) {
                this.iZy.E(this.gOK, this.jeu.e("fail:resp invalid", null));
                return;
            }
        }
        String str2 = "MicroMsg.JsApiVerifyPlugin";
        String str3 = "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %b";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        if (bVar.hmh.hmo != null) {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        x.e(str2, str3, objArr);
        this.iZy.E(this.gOK, this.jeu.e("fail:cgi fail", null));
    }
}
