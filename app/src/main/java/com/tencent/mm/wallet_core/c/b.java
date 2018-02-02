package com.tencent.mm.wallet_core.c;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b {
    public String fwM = "";
    public String title = "";
    public String zHh = "";
    public String zHi = "";
    public String zHj = "";

    public b(String str) {
        if (!bh.ov(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.title = jSONObject.optString("title");
                this.zHh = jSONObject.optString("body1");
                this.zHi = jSONObject.optString("body2");
                this.zHj = jSONObject.optString("button");
            } catch (Exception e) {
                x.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", new Object[]{e.getMessage()});
            }
        }
    }
}
