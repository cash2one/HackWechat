package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bh;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x extends aa {
    public String ljf;

    public x(int i, long j, long j2, int i2, String str, String str2, String str3, String str4, int i3) {
        Map hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i));
        hashMap.put("totalAmount", String.valueOf(j));
        hashMap.put("perValue", String.valueOf(j2));
        hashMap.put("hbType", String.valueOf(i2));
        hashMap.put("wishing", URLEncoder.encode(bh.ou(str)));
        hashMap.put("currency", String.valueOf(i3));
        if (!bh.ov(str3)) {
            hashMap.put("headImg", URLEncoder.encode(str3));
        }
        hashMap.put("nickName", URLEncoder.encode(bh.ou(str4)));
        if (!bh.ov(str2)) {
            hashMap.put("username", URLEncoder.encode(str2));
        }
        D(hashMap);
    }

    public final int getType() {
        return 1645;
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/h5requestwxhb";
    }

    public final int ayO() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneLuckyMoneyH5Request", "NetSceneLuckyMoneyH5Request response errCode=" + i);
        if (i == 0) {
            this.ljf = jSONObject.optString("payUrl");
        }
    }
}
