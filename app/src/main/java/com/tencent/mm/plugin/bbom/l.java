package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ag.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.c.ara;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;

public final class l implements f, k {
    public final void a(ara com_tencent_mm_protocal_c_ara, au auVar) {
        if (com.tencent.mm.ag.f.eE(auVar.field_talker)) {
            com_tencent_mm_protocal_c_ara.vHc = auVar.gjF;
            if (bh.ov(com_tencent_mm_protocal_c_ara.vHc)) {
                com_tencent_mm_protocal_c_ara.vHc = e.kr(auVar.gjF);
                return;
            }
            return;
        }
        com_tencent_mm_protocal_c_ara.vHc = auVar.gjF;
    }

    public final String s(au auVar) {
        if (com.tencent.mm.ag.f.eE(auVar.field_talker)) {
            return e.HD();
        }
        return null;
    }
}
