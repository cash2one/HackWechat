package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.ae.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.protocal.c.amm;
import com.tencent.mm.protocal.c.amn;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONObject;

public final class aa extends a {
    public static final int CTRL_BYTE = 231;
    public static final String NAME = "login";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiLogin", "invoke");
        Context aPh = dVar.aPh();
        LinkedList linkedList = new LinkedList();
        String str = "";
        String str2 = "";
        String aPl = dVar.aPl();
        if (bh.ov(aPl)) {
            x.e("MicroMsg.GameJsApiLogin", "appId is null!");
            dVar.E(i, a.e("login:fail", null));
            return;
        }
        a.a aVar = new a.a(dVar, i);
        b.a aVar2 = new b.a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_amm = new amm();
        aVar2.hmj = com_tencent_mm_protocal_c_amm;
        aVar2.hmk = new amn();
        aVar2.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar2.hmi = 1029;
        aVar2.hml = 0;
        aVar2.hmm = 0;
        com_tencent_mm_protocal_c_amm.ngo = aPl;
        com_tencent_mm_protocal_c_amm.wta = linkedList;
        com_tencent_mm_protocal_c_amm.wtf = 0;
        com_tencent_mm_protocal_c_amm.nfX = str2;
        com_tencent_mm_protocal_c_amm.wtg = str;
        com_tencent_mm_protocal_c_amm.wtc = 0;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.JZ(), new 1(this, aVar, aPh, aPl));
    }
}
