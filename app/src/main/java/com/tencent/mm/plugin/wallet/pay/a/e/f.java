package com.tencent.mm.plugin.wallet.pay.a.e;

import com.tencent.mm.plugin.wallet_core.e.b;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class f extends j {
    private int pLT = -1;
    public Orders sEs = null;

    public f(p pVar, Orders orders) {
        String str = null;
        int i = -1;
        this.sEs = orders;
        if (pVar.pCn != null) {
            this.pLT = pVar.pCn.fCV;
            i = pVar.pCn.fCR;
        }
        List list = orders.sNW;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).fuI;
        }
        a(orders.fuH, str, this.pLT, i, pVar.oZz, pVar.oZA);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        x.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", new Object[]{Boolean.valueOf(!bh.ov(pVar.sPj))});
        a(pVar.pCn, hashMap, hashMap2, r0);
        hashMap.put("flag", pVar.flag);
        hashMap.put("passwd", pVar.sPj);
        hashMap.put("verify_code", pVar.sPk);
        hashMap.put("token", pVar.token);
        hashMap.put("favorcomposedid", pVar.sKE);
        hashMap.put("default_favorcomposedid", pVar.sKD);
        D(hashMap);
        aB(hashMap2);
    }

    public final int ayQ() {
        return 16;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            x.d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:" + jSONObject.optString("bind_serial"));
            if ("1".equals(jSONObject.optString("pay_flag"))) {
                this.sFA = true;
                this.sEs = Orders.a(jSONObject, this.sEs);
            } else {
                this.sFA = false;
            }
            x.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.pLT);
            if (this.pLT == 39) {
                x.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
                b.ad(jSONObject);
                return;
            }
            x.i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
        }
    }

    public String getUri() {
        if (this.pLT == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverifyreg";
        }
        if (this.pLT == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverifyreg";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verifyreg";
    }

    public int Hr() {
        if (this.pLT == 11) {
            return 1684;
        }
        if (this.pLT == 21) {
            return 1608;
        }
        return 474;
    }

    public final boolean bJT() {
        if (this.pLT == 11 || this.pLT == 21) {
            return true;
        }
        return false;
    }
}
