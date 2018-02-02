package com.tencent.mm.ag;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class d$b$b {
    public int hpa;
    public int hpb;
    public int hpc;

    public static d$b$b jE(String str) {
        x.i("MicroMsg.BizInfo", "HardwareBizInfo = " + str);
        d$b$b com_tencent_mm_ag_d_b_b = new d$b$b();
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                com_tencent_mm_ag_d_b_b.hpa = jSONObject.optInt("hardware_flag");
                com_tencent_mm_ag_d_b_b.hpb = jSONObject.optInt("connect_status_display_mode");
                com_tencent_mm_ag_d_b_b.hpc = jSONObject.optInt("special_internal_brand_type");
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        return com_tencent_mm_ag_d_b_b;
    }

    public final boolean LH() {
        return (this.hpa & 1) > 0;
    }
}
