package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends i {
    public BindCardOrder sIg;

    public b(p pVar) {
        this(pVar, -1);
    }

    public b(p pVar, int i) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("flag", pVar.flag);
        hashMap.put("passwd", pVar.sPj);
        hashMap.put("verify_code", pVar.sPk);
        hashMap.put("token", pVar.token);
        hashMap.put("bind_flag", pVar.sPl ? "1" : "0");
        if (i > 0) {
            hashMap.put("realname_scene", String.valueOf(i));
            x.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        }
        if (!bh.ov(pVar.oZz)) {
            hashMap.put("bank_type", pVar.oZz);
        }
        if (o.cBs()) {
            hashMap2.put("uuid_for_bindcard", o.cBu());
            hashMap2.put("bindcard_scene", o.cBt());
        }
        a(pVar.pCn, hashMap, hashMap2);
        D(hashMap);
        aB(hashMap2);
    }

    public final int ayQ() {
        return 17;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.sIg = new BindCardOrder();
        this.sIg.W(jSONObject);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverifyreg";
    }

    public final int Hr() {
        return 475;
    }
}
