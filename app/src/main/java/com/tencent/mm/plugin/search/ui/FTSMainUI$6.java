package com.tencent.mm.plugin.search.ui;

import com.tencent.mm.bc.g;
import com.tencent.mm.plugin.search.ui.i.b;
import com.tencent.mm.protocal.c.bdh;
import com.tencent.mm.sdk.platformtools.bh;

class FTSMainUI$6 implements b {
    final /* synthetic */ FTSMainUI qdk;

    FTSMainUI$6(FTSMainUI fTSMainUI) {
        this.qdk = fTSMainUI;
    }

    public final void bqk() {
        h a = FTSMainUI.a(this.qdk);
        String str = a.fDj != null ? a.fDj : "";
        if (FTSMainUI.a(this.qdk).getVisibility() == 0 && !bh.ov(str) && !FTSMainUI.b(this.qdk).containsKey(str)) {
            FTSMainUI.b(this.qdk).put(str, Integer.valueOf(1));
            a = FTSMainUI.a(this.qdk);
            String str2 = a.iRN != null ? a.iRN : "";
            long currentTimeMillis = System.currentTimeMillis();
            a = FTSMainUI.a(this.qdk);
            StringBuilder stringBuilder = new StringBuilder("");
            if (a.qcA != null) {
                for (bdh com_tencent_mm_protocal_c_bdh : a.qcA) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(com_tencent_mm_protocal_c_bdh.wJs);
                }
            }
            g.a(str, str2, currentTimeMillis, stringBuilder.toString());
        }
    }
}
