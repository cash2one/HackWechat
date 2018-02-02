package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bh;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ae extends aa {
    public String nZa;
    public String ods;
    public String odt;

    public ae(int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, int i3) {
        Map hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(i));
        hashMap.put("wishing", URLEncoder.encode(bh.ou(str)));
        hashMap.put("sendUserName", str4);
        if (!bh.ov(str3)) {
            hashMap.put("username", str3);
        }
        if (!bh.ov(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
        }
        if (!bh.ov(str5)) {
            hashMap.put("nickName", URLEncoder.encode(bh.ou(str5)));
        }
        hashMap.put("inWay", String.valueOf(i2));
        hashMap.put("imageId", str6);
        hashMap.put("imageAesKey", str7);
        hashMap.put("imageLength", String.valueOf(i3));
        D(hashMap);
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/yearrequestwxhb";
    }

    public final int getType() {
        return 1643;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.nZa = jSONObject.optString("sendId");
        this.ods = jSONObject.optString("reqkey");
        this.odt = jSONObject.optString("sendMsgXml");
    }
}
