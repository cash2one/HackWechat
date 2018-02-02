package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.ae.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.protocal.c.ami;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_BYTE = 232;
    public static final String NAME = "authorize";

    public final void a(com.tencent.mm.plugin.game.gamewebview.ui.d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiAuthorize", "invoke");
        Context aPh = dVar.aPh();
        JSONArray optJSONArray = jSONObject.optJSONArray("scope");
        if (optJSONArray == null) {
            x.e("MicroMsg.GameJsApiAuthorize", "scope is null!");
            dVar.E(i, a.e("authorize:fail", null));
            return;
        }
        String aPl = dVar.aPl();
        if (bh.ov(aPl)) {
            x.e("MicroMsg.GameJsApiAuthorize", "appId is null!");
            dVar.E(i, a.e("authorize:fail", null));
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            linkedList.add(optJSONArray.optString(i2));
        }
        b.a aVar = new b.a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_ami = new ami();
        aVar.hmj = com_tencent_mm_protocal_c_ami;
        aVar.hmk = new amj();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar.hmi = 1157;
        aVar.hml = 0;
        aVar.hmm = 0;
        com_tencent_mm_protocal_c_ami.ngo = aPl;
        com_tencent_mm_protocal_c_ami.wta = linkedList;
        com_tencent_mm_protocal_c_ami.wtc = 0;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.JZ(), new 1(this, new a.a(dVar, i), aPh, aPl));
    }
}
