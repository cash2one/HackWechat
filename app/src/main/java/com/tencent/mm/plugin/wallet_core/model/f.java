package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class f {
    public int sLA;
    public String sLB;
    public String sLC;
    public String sLD;
    public String sLE;
    public String sLF;

    public static f MQ(String str) {
        if (!bh.ov(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                f fVar = new f();
                fVar.sLA = jSONObject.optInt("menu_jump_type", -1);
                fVar.sLB = jSONObject.optString("menu_jump_url", "");
                fVar.sLC = jSONObject.optString("menu_username", "");
                fVar.sLD = jSONObject.optString("menu_path", "");
                fVar.sLE = jSONObject.optString("menu_title", "");
                fVar.sLF = jSONObject.optString("menu_icon_url", "");
                x.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", new Object[]{Integer.valueOf(fVar.sLA), fVar.sLE});
                return fVar;
            } catch (Throwable e) {
                x.printErrStackTrace("BindCardMenu", e, "", new Object[0]);
            }
        }
        return null;
    }
}
