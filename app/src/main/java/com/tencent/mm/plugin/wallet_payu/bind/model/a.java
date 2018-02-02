package com.tencent.mm.plugin.wallet_payu.bind.model;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String description;
    public String fKM;
    public String pin;
    public String sQP;
    public String tbn;
    public String tbw;
    public String tbx;
    public String tby;

    public final int bKL() {
        return 0;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.tbw = str;
        this.sQP = str2;
        this.fKM = str3;
        this.tbx = str4;
        this.tby = str5;
        this.description = str6;
        this.tbn = str7;
        this.pin = str8;
        Map hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("information", str2);
        hashMap.put("name_on_card", str3);
        hashMap.put("card_number", str4);
        hashMap.put("card_expiry", str5);
        hashMap.put("description", str6);
        hashMap.put("cvv", str7);
        hashMap.put("pin", str8);
        D(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
