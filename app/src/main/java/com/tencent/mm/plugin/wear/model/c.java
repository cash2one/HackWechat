package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.pluginsdk.q.w.a;
import com.tencent.mm.protocal.c.byj;
import com.tencent.mm.sdk.platformtools.bh;

public final class c implements a {
    public final String bOv() {
        byj com_tencent_mm_protocal_c_byj = a.bOt().thH.thY.tiP;
        if (com_tencent_mm_protocal_c_byj != null) {
            return com_tencent_mm_protocal_c_byj.wYC + "\n" + com_tencent_mm_protocal_c_byj.wYD + "\n" + com_tencent_mm_protocal_c_byj.wYE;
        }
        return "Not Connect";
    }

    public final void bOw() {
        a.bOt().thN.a(new com.tencent.mm.plugin.wear.model.f.a());
    }

    public final boolean bOx() {
        String str = null;
        byj com_tencent_mm_protocal_c_byj = a.bOt().thH.thY.tiP;
        return (bh.ov(str) && bh.ov(str)) ? com_tencent_mm_protocal_c_byj != null : bh.ov(str) ? com_tencent_mm_protocal_c_byj != null && str.equals("gh_43f2581f6fd6") : bh.ov(str) ? com_tencent_mm_protocal_c_byj != null && str.equals(com_tencent_mm_protocal_c_byj.wYz) : com_tencent_mm_protocal_c_byj != null && str.equals("gh_43f2581f6fd6") && str.equals(com_tencent_mm_protocal_c_byj.wYz);
    }
}
