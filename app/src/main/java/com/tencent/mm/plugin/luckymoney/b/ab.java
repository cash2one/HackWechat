package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bh;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ab extends aa {
    public String obN;
    public String obV;

    public ab(String str, String str2, String str3, String str4) {
        this.obV = str3;
        this.obN = str2;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("receiveId", str3);
        hashMap.put("wishing", URLEncoder.encode(bh.ou(str2)));
        hashMap.put("ver", str4);
        D(hashMap);
    }

    public final int getType() {
        return 1682;
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/wishwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
