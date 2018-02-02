package com.tencent.mm.ag;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class d$b$g {
    public String hpu;
    public String hpv;
    public boolean hpw;

    public static d$b$g jJ(String str) {
        x.i("MicroMsg.BizInfo", "RegisterSource = %s", new Object[]{str});
        d$b$g com_tencent_mm_ag_d_b_g = new d$b$g();
        if (str != null && str.length() > 0) {
            try {
                boolean z;
                JSONObject jSONObject = new JSONObject(str);
                com_tencent_mm_ag_d_b_g.hpu = jSONObject.optString("RegisterBody");
                com_tencent_mm_ag_d_b_g.hpv = jSONObject.optString("IntroUrl");
                if (jSONObject.optInt("IsClose", 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                com_tencent_mm_ag_d_b_g.hpw = z;
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception in RegisterSource:%s", new Object[]{bh.i(e)});
            }
        }
        return com_tencent_mm_ag_d_b_g;
    }
}
