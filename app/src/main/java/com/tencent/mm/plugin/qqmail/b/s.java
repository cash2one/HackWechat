package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;

public final class s {
    r ppr;

    public s() {
        ar.Hg();
        String str = (String) c.CU().get(282625, "");
        try {
            this.ppr = new r();
            this.ppr.aF(Base64.decode(str, 0));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            x.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
            this.ppr = new r();
        }
    }

    public final void HM(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.ShareMailInfoMgr", "remove info fail, info is null");
            return;
        }
        for (int i = 0; i < this.ppr.omU.size(); i++) {
            if (((q) this.ppr.omU.get(i)).poi.equals(str)) {
                this.ppr.omU.remove(i);
                break;
            }
        }
        save();
    }

    static void HN(String str) {
        au auVar = new au();
        auVar.dS("qqmail");
        auVar.aq(ba.hR("qqmail"));
        auVar.eR(0);
        auVar.setContent(String.format(ac.getContext().getString(R.l.eJR), new Object[]{str}));
        auVar.setType(1);
        auVar.eQ(3);
        ar.Hg();
        x.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[]{Long.valueOf(c.Fa().Q(auVar))});
    }

    final void save() {
        try {
            x.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[]{Base64.encodeToString(this.ppr.toByteArray(), 0)});
            ar.Hg();
            c.CU().set(282625, r0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            x.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
        }
    }
}
