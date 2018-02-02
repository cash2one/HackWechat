package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.az.r;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import java.io.File;

class d$1 extends c<ck> {
    final /* synthetic */ d nCv;

    d$1(d dVar) {
        this.nCv = dVar;
        this.xen = ck.class.getName().hashCode();
    }

    private boolean a(ck ckVar) {
        if (ckVar instanceof ck) {
            x.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
            ar.Hg();
            int intValue = ((Integer) com.tencent.mm.z.c.CU().get(a.xpb, Integer.valueOf(0))).intValue();
            int i = g.zY().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
            x.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i)});
            if (intValue != i) {
                ar.Hg();
                com.tencent.mm.z.c.CU().a(a.xpb, Integer.valueOf(i));
                r.QH().ij(26);
                c aTj = c.aTj();
                x.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[]{e.gZK + "ipcallCountryCodeConfig.cfg"});
                try {
                    File file = new File(e.gZK + "ipcallCountryCodeConfig.cfg");
                    if (file.exists()) {
                        file.delete();
                    }
                    aTj.isInit = false;
                    aTj.nCs.clear();
                } catch (Exception e) {
                    x.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[]{e.getMessage()});
                }
                this.nCv.fQ(true);
            }
        }
        return false;
    }
}
