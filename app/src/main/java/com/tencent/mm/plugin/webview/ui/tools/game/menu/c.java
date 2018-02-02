package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import com.tencent.mm.protocal.c.aqy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c {
    private static c tFP;

    public static c bUj() {
        if (tFP == null) {
            synchronized (c.class) {
                if (tFP == null) {
                    tFP = new c();
                }
            }
        }
        return tFP;
    }

    public final n i(List<aqy> list, boolean z) {
        if (bh.cA(list)) {
            return null;
        }
        List<aqy> arrayList = new ArrayList();
        for (aqy com_tencent_mm_protocal_c_aqy : list) {
            if (com_tencent_mm_protocal_c_aqy != null && a.AX(com_tencent_mm_protocal_c_aqy.wgQ)) {
                arrayList.add(com_tencent_mm_protocal_c_aqy);
            }
        }
        if (bh.cA(arrayList)) {
            return null;
        }
        Collections.sort(arrayList, new 1(this));
        int i = ((aqy) arrayList.get(arrayList.size() - 1)).wyP;
        List<aqy> arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList2.add(null);
        }
        for (aqy com_tencent_mm_protocal_c_aqy2 : arrayList) {
            if (a.AY(com_tencent_mm_protocal_c_aqy2.wgQ) == a.tFW) {
                if (!z && com_tencent_mm_protocal_c_aqy2.wyP > 0 && com_tencent_mm_protocal_c_aqy2.wyP <= arrayList2.size()) {
                    arrayList2.set(com_tencent_mm_protocal_c_aqy2.wyP - 1, com_tencent_mm_protocal_c_aqy2);
                }
            } else if (a.AY(com_tencent_mm_protocal_c_aqy2.wgQ) == a.tFX) {
                if (z && com_tencent_mm_protocal_c_aqy2.wyP > 0 && com_tencent_mm_protocal_c_aqy2.wyP <= arrayList2.size()) {
                    arrayList2.set(com_tencent_mm_protocal_c_aqy2.wyP - 1, com_tencent_mm_protocal_c_aqy2);
                }
            } else if (com_tencent_mm_protocal_c_aqy2.wyP > 0 && com_tencent_mm_protocal_c_aqy2.wyP <= arrayList2.size()) {
                arrayList2.set(com_tencent_mm_protocal_c_aqy2.wyP - 1, com_tencent_mm_protocal_c_aqy2);
            }
        }
        n nVar = new n();
        for (aqy com_tencent_mm_protocal_c_aqy22 : arrayList2) {
            if (com_tencent_mm_protocal_c_aqy22 == null) {
                nVar.f(-1, "");
            } else {
                nVar.f(com_tencent_mm_protocal_c_aqy22.wyO, com_tencent_mm_protocal_c_aqy22.fon + "__" + com_tencent_mm_protocal_c_aqy22.pbP);
            }
        }
        return nVar;
    }
}
