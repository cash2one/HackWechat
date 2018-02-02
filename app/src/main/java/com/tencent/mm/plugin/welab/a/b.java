package com.tencent.mm.plugin.welab.a;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.welab.a.a.a;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.protocal.c.anv;
import com.tencent.mm.protocal.c.anw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.HashMap;
import java.util.Map;

public final class b implements a {
    private Map<String, Integer> tPC = new HashMap();
    private String tag = "";

    public b() {
        bVy();
    }

    private void bVy() {
        this.tag = (String) g.Dj().CU().get(w.a.xvo, null);
        x.i("LabAppLifeService", "load red tag " + this.tag);
        if (!TextUtils.isEmpty(this.tag)) {
            for (Object obj : this.tag.split("&")) {
                if (!TextUtils.isEmpty(obj)) {
                    String[] split = obj.split("=");
                    if (split != null && split.length == 2) {
                        this.tPC.put(split[0], Integer.valueOf(bh.VI(split[1])));
                    }
                }
            }
        }
    }

    public final boolean QA(String str) {
        if (com.tencent.mm.plugin.welab.b.bVu().Qw(str).field_Switch == 2) {
            return true;
        }
        return false;
    }

    public final boolean QB(String str) {
        return this.tPC.get(str) == null || ((Integer) this.tPC.get(str)).intValue() == 0;
    }

    public final void open(String str) {
        this.tPC.put(str, Integer.valueOf(1));
        this.tag += "&" + str + "=1";
        g.Dj().CU().a(w.a.xvo, this.tag);
        com.tencent.mm.plugin.welab.c.a.a Qw = com.tencent.mm.plugin.welab.b.bVu().Qw(str);
        e.a aVar = new e.a();
        aVar.fFm = str;
        aVar.tPA = Qw.field_expId;
        aVar.hOG = System.currentTimeMillis();
        aVar.action = 3;
        e.a(aVar);
    }

    public final boolean QC(String str) {
        return com.tencent.mm.plugin.welab.b.bVu().Qw(str).isRunning();
    }

    public final void aV(String str, boolean z) {
        int i = 1;
        c Qw = com.tencent.mm.plugin.welab.b.bVu().Qw(str);
        int i2 = z ? 2 : 1;
        if (Qw.field_Switch != i2) {
            Qw.field_Switch = i2;
            com.tencent.mm.plugin.welab.b.bVu().tPx.c(Qw, new String[0]);
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_anw = new anw();
            anv com_tencent_mm_protocal_c_anv = new anv();
            com_tencent_mm_protocal_c_anv.wuJ = bh.VI(Qw.field_expId);
            com_tencent_mm_protocal_c_anv.wuK = Qw.field_LabsAppId;
            if (Qw.field_Switch != 2) {
                i = 2;
            }
            com_tencent_mm_protocal_c_anv.wgQ = i;
            com_tencent_mm_protocal_c_anw.gBH.add(com_tencent_mm_protocal_c_anv);
            ((h) g.h(h.class)).EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(207, com_tencent_mm_protocal_c_anw));
            e.o(str, Qw.field_Switch == 2 ? 4 : 5, false);
        }
    }
}
