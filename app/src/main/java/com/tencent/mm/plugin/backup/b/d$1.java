package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import java.util.HashMap;

class d$1 implements Runnable {
    final /* synthetic */ d kkn;

    d$1(d dVar) {
        this.kkn = dVar;
    }

    public final void run() {
        e.reset();
        e.aoL();
        d.a(this.kkn).begin();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (String str : d.b(this.kkn).keySet()) {
            d.aoF();
            String str2 = g.vl(str) + str;
            if (b.ceK()) {
                d.a(this.kkn, str2, hashMap, hashMap2);
                if (d.c(this.kkn)) {
                    x.e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferSessions size[%d], recovering session num[%d]", new Object[]{str, Integer.valueOf(d.d(this.kkn).size()), Integer.valueOf(d.e(this.kkn))});
                    d.aoG();
                    d.a(this.kkn).end();
                    c.k(hashMap);
                    d.a(this.kkn, d.f(this.kkn), d.g(this.kkn));
                    return;
                }
            }
            try {
                d.a(this.kkn, str2, hashMap, hashMap2);
                if (d.c(this.kkn)) {
                    x.e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferSessions size[%d], recovering session num[%d]", new Object[]{str, Integer.valueOf(d.d(this.kkn).size()), Integer.valueOf(d.e(this.kkn))});
                    d.aoG();
                    d.a(this.kkn).end();
                    c.k(hashMap);
                    d.a(this.kkn, d.f(this.kkn), d.g(this.kkn));
                    return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BackupRecoverMerger", e, "recoverFromSdcard MMThread.run():", new Object[0]);
            }
            d.d(this.kkn).add(d.b(this.kkn).get(str));
            d.h(this.kkn).aol().F(26, d.d(this.kkn).size() > d.e(this.kkn) ? d.e(this.kkn) : d.d(this.kkn).size(), d.e(this.kkn));
            this.kkn.mB(26);
            d.a(this.kkn).aoJ();
            d.aoG();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e2) {
            }
            x.i("MicroMsg.BackupRecoverMerger", "msgDataId[%s] merge finish, transferSessions size[%d]", new Object[]{str, Integer.valueOf(d.d(this.kkn).size())});
        }
        c.k(hashMap);
        x.i("MicroMsg.BackupRecoverMerger", "readFromSdcard build temDB finish! transferSession:%s totalSession:%d", new Object[]{Integer.valueOf(d.d(this.kkn).size()), Integer.valueOf(d.e(this.kkn))});
        d.a(this.kkn).end();
        if (b.ceK()) {
            d.h(this.kkn).aol().kiK = d.d(this.kkn).size() > d.e(this.kkn) ? d.e(this.kkn) : d.d(this.kkn).size();
        } else {
            d.h(this.kkn).aol().kiK = d.e(this.kkn);
        }
        d.h(this.kkn).aol().kiL = d.e(this.kkn);
        x.cfk();
        if (d.i(this.kkn) != d.aoH()) {
            d.a(this.kkn, d.aoH());
            d.aoE();
            x.i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp backupRecoverCloseTempDb merge success, restart sync");
            if (d.j(this.kkn) == 1) {
                ar.Hg();
                com.tencent.mm.z.c.CU().a(a.xtf, Boolean.valueOf(false));
            } else if (d.j(this.kkn) == 2) {
                ar.Hg();
                com.tencent.mm.z.c.CU().a(a.xti, Boolean.valueOf(false));
            }
            if (d.k(this.kkn) != null) {
                d.k(this.kkn).aok();
            }
            ar.Hg().FM().chL();
            ar.Hg().FN().chL();
            d.h(this.kkn).aol().F(27, d.d(this.kkn).size() > d.e(this.kkn) ? d.e(this.kkn) : d.d(this.kkn).size(), d.e(this.kkn));
            this.kkn.mB(27);
            d.a(this.kkn, d.aoI());
            d.l(this.kkn);
            d.h(this.kkn).aon();
        }
    }
}
