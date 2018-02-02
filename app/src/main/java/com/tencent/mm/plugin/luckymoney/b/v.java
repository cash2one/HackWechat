package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class v extends aa {
    long fqm;
    public e ocQ;
    public String odd;
    String talker;

    public v(String str, int i, int i2, String str2, String str3) {
        this(str, i, i2, str2, str3, "");
    }

    public v(String str, int i, String str2, long j, String str3, String str4) {
        this.ocQ = null;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", "11");
        hashMap.put("offset", String.valueOf(i));
        if (!bh.ov(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("befortTimestamp", String.valueOf(j));
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        D(hashMap);
    }

    public v(String str, int i, int i2, String str2, String str3, String str4) {
        this.ocQ = null;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        if (!bh.ov(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        D(hashMap);
    }

    public final int getType() {
        return 1585;
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/qrydetailwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            this.ocQ = l.H(jSONObject);
            this.odd = jSONObject.optString("processContent");
        } catch (JSONException e) {
            x.w("MicroMsg.NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
    }
}
