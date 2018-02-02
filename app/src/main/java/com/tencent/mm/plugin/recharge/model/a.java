package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a {
    public static final int[] pBF = new int[]{-1, -1};
    public static final int[] pBG = new int[]{-2, -2};
    public int fqd;
    public String name;
    public String pBH;
    public String pBI;
    public int[] pBJ;

    public a(String str, String str2, int i) {
        this(str, str2, "", i);
    }

    public a(String str, String str2, String str3, int i) {
        this.pBJ = pBF;
        this.pBH = str;
        this.name = str2;
        this.pBI = str3;
        this.fqd = i;
    }

    public final JSONObject bmu() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("record", bh.az(this.pBH, ""));
            jSONObject.put("name", bh.az(this.name, ""));
            jSONObject.put("location", bh.az(this.pBI, ""));
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallInputRecord", e, "", new Object[0]);
            return null;
        }
    }

    public static a R(JSONObject jSONObject) {
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("record");
        String optString3 = jSONObject.optString("location");
        if (bh.ov(optString2)) {
            return null;
        }
        return new a(optString2, optString, optString3, 2);
    }
}
