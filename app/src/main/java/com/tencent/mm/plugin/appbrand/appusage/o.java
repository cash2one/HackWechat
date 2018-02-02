package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.protocal.c.afp;
import com.tencent.mm.protocal.c.afq;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.concurrent.TimeUnit;

public final class o extends a<afq> {
    private static final long iKe = TimeUnit.MINUTES.toSeconds(5);

    protected final /* synthetic */ void a(int i, int i2, String str, bdf com_tencent_mm_protocal_c_bdf, k kVar) {
        afq com_tencent_mm_protocal_c_afq = (afq) com_tencent_mm_protocal_c_bdf;
        super.a(i, i2, str, com_tencent_mm_protocal_c_afq, kVar);
        c Zl = f.Zl();
        com.tencent.mm.plugin.appbrand.o.a Zt = f.Zt();
        if (Zl == null || Zt == null) {
            x.e("MicroMsg.CgiGetSearchShowOutWxaApp", "storage NULL [ %s | %s ]", new Object[]{Zl, Zt});
            return;
        }
        long j = (i == 0 && i2 == 0 && com_tencent_mm_protocal_c_afq != null) ? (long) com_tencent_mm_protocal_c_afq.wnz : iKe;
        Zl.aV("GetSearchShowOutWxaApp_interval", String.valueOf(j));
        if (i == 0 && i2 == 0 && com_tencent_mm_protocal_c_afq != null) {
            try {
                Zt.k("GetSearchShowOutWxaApp_resp", com_tencent_mm_protocal_c_afq.toByteArray());
            } catch (Exception e) {
                x.e("MicroMsg.CgiGetSearchShowOutWxaApp", "save resp e %s", new Object[]{e});
            }
        }
    }

    private o(int i) {
        b.a aVar = new b.a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_afp = new afp();
        com_tencent_mm_protocal_c_afp.aAk = (i - 1) + 1;
        aVar.hmj = com_tencent_mm_protocal_c_afp;
        aVar.hmk = new afq();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getsearchshowoutwxaapp";
        aVar.hmi = 1314;
        this.gJQ = aVar.JZ();
    }

    public static void jG(int i) {
        if (g.Dh().gPy) {
            switch (1.iKf[i - 1]) {
                case 1:
                    if (bh.getLong(f.Zl().get("GetSearchShowOutWxaApp_lastCheck", "$$invalid"), 0) + bh.getLong(f.Zl().get("GetSearchShowOutWxaApp_interval", "$$invalid"), iKe) <= bh.Wo()) {
                        f.Zl().aV("GetSearchShowOutWxaApp_lastCheck", String.valueOf(bh.Wo()));
                        break;
                    }
                    return;
                case 2:
                    if (((Long) g.Dj().CU().get(w.a.xse, Long.valueOf(0))).longValue() + TimeUnit.DAYS.toSeconds(1) <= bh.Wo()) {
                        g.Dj().CU().a(w.a.xse, Long.valueOf(bh.Wo()));
                        break;
                    }
                    return;
            }
            new o(i).JV();
        }
    }

    static afq abe() {
        return (afq) f.Zt().g("GetSearchShowOutWxaApp_resp", afq.class);
    }
}
