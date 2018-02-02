package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public Orders pPl;
    private String sEE;

    public c(String str) {
        this(str, 0);
    }

    public c(String str, int i) {
        this.pPl = null;
        this.sEE = null;
        this.sEE = str;
        Map hashMap = new HashMap();
        hashMap.put("req_key", this.sEE);
        hashMap.put("query_scene", String.valueOf(i));
        D(hashMap);
    }

    public final int bKL() {
        return 8;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.pPl = Orders.Y(jSONObject);
        if (this.pPl != null) {
            this.pPl.fuH = this.sEE;
        }
    }
}
