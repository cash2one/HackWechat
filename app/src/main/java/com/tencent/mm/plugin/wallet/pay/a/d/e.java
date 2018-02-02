package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.plugin.wallet_core.e.b;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class e extends j {
    private int pLT = -1;
    protected p sEG;
    public Orders sEs = null;

    public e(p pVar, Orders orders) {
        String str = null;
        this.sEs = orders;
        this.sEG = pVar;
        List list = orders.sNW;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).fuI;
        }
        if (pVar.pCn == null) {
            x.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
            return;
        }
        this.pLT = pVar.pCn.fCV;
        a(orders.fuH, str, pVar.pCn.fCV, pVar.pCn.fCR, pVar.oZz, pVar.oZA);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("flag", pVar.flag);
        hashMap.put("passwd", pVar.sPj);
        x.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", new Object[]{Boolean.valueOf(!bh.ov(pVar.sPj))});
        a(pVar.pCn, hashMap, hashMap2, r0);
        hashMap.put("verify_type", pVar.fCz);
        if (pVar.fCz == 0) {
            hashMap.put("verify_code", pVar.sPk);
        } else {
            hashMap.put("cre_tail", pVar.sPm);
            hashMap.put("cre_type", pVar.sPn);
        }
        hashMap.put("token", pVar.token);
        hashMap.put("bank_type", pVar.oZz);
        hashMap.put("bind_serial", pVar.oZA);
        hashMap.put("arrive_type", pVar.sKA);
        hashMap.put("default_favorcomposedid", pVar.sKD);
        hashMap.put("favorcomposedid", pVar.sKE);
        S(hashMap);
        if (o.cBs()) {
            hashMap2.put("uuid_for_bindcard", o.cBu());
            hashMap2.put("bindcard_scene", o.cBt());
        }
        D(hashMap);
        aB(hashMap2);
    }

    protected void S(Map<String, String> map) {
    }

    public int ayQ() {
        return 1;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            x.d("MicroMsg.NetSceneTenpayPayVertify", "Pay Success! saving bind_serial:" + jSONObject.optString("bind_serial"));
            if ("1".equals(jSONObject.optString("pay_flag"))) {
                this.sFA = true;
                this.sEs = Orders.a(jSONObject, this.sEs);
            } else {
                this.sFA = false;
            }
            x.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.pLT);
            if (this.pLT == 39) {
                x.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
                b.ad(jSONObject);
                return;
            }
            x.i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
        }
    }

    public String getUri() {
        if (this.pLT == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverify";
        }
        if (this.pLT == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverify";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verify";
    }

    public int Hr() {
        if (this.pLT == 11) {
            return 1607;
        }
        if (this.pLT == 21) {
            return 1606;
        }
        return 462;
    }

    public final boolean bJT() {
        if (this.pLT == 11 || this.pLT == 21) {
            return true;
        }
        return false;
    }
}
