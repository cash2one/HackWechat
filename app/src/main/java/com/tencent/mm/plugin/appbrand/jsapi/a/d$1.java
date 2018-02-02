package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.ahc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

class d$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ p jdJ;
    final /* synthetic */ d jgW;

    d$1(d dVar, p pVar, int i) {
        this.jgW = dVar;
        this.jdJ = pVar;
        this.gOK = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        Map hashMap = new HashMap();
        if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
            ahc com_tencent_mm_protocal_c_ahc = (ahc) bVar.hmh.hmo;
            x.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData success");
            Object obj = "";
            if (!TextUtils.isEmpty(com_tencent_mm_protocal_c_ahc.wow)) {
                obj = com_tencent_mm_protocal_c_ahc.wow;
            }
            Object obj2 = "";
            if (!TextUtils.isEmpty(com_tencent_mm_protocal_c_ahc.wox)) {
                obj2 = com_tencent_mm_protocal_c_ahc.wox;
            }
            int i3 = com_tencent_mm_protocal_c_ahc.vJs;
            Collection collection = com_tencent_mm_protocal_c_ahc.woy;
            x.i("MicroMsg.JsApiGetUserAutoFillData", "auth_info:%s, auth_status:%d", obj2, Integer.valueOf(i3));
            x.i("MicroMsg.JsApiGetUserAutoFillData", "user_info_json:%s", obj);
            hashMap.put("userData", obj);
            hashMap.put("authStatus", Integer.valueOf(i3));
            hashMap.put("authInfo", obj2);
            if (collection != null && collection.size() > 0) {
                hashMap.put("authGroupList", new JSONArray(collection));
                x.i("MicroMsg.JsApiGetUserAutoFillData", "authGroupList:%s", new JSONArray(collection).toString());
            }
            this.jdJ.E(this.gOK, this.jgW.e("ok", hashMap));
            return;
        }
        x.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo);
        hashMap.put("ret", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            this.jdJ.E(this.gOK, this.jgW.e("fail: ErrMsg: cgi fail", hashMap));
        } else {
            this.jdJ.E(this.gOK, this.jgW.e("fail: ErrMsg:" + str, hashMap));
        }
    }
}
