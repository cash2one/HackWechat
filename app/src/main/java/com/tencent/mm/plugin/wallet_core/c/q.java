package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q extends i {
    public BindCardOrder sIg;

    public q(p pVar) {
        this(pVar, -1);
    }

    public q(p pVar, int i) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(pVar.pCn, hashMap, hashMap2);
        hashMap.put("flag", pVar.flag);
        if ("2".equals(pVar.flag)) {
            hashMap.put("passwd", pVar.sPj);
        }
        hashMap.put("verify_code", pVar.sPk);
        hashMap.put("token", pVar.token);
        if (!(pVar.pCn == null || bh.ov(pVar.pCn.fuH))) {
            hashMap.put("req_key", pVar.pCn.fuH);
        }
        if (i >= 0) {
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
        D(hashMap);
        aB(hashMap2);
    }

    public final int ayQ() {
        return 13;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("test", "test");
        this.sIg = new BindCardOrder();
        this.sIg.W(jSONObject);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverify";
    }

    public final int Hr() {
        return 472;
    }
}
