package com.tencent.mm.bn;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.mm.bq.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.ajd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class b {
    public static void run() {
        long j = 0;
        if (ar.Hj() && !ar.Cs()) {
            long Wo = bh.Wo();
            ar.Hg();
            long a = bh.a((Long) c.CU().get(331797, null), 0);
            if (10013 != r.idt || r.idu == 0) {
                j = a;
            }
            if (j < Wo) {
                ar.Hg();
                c.CU().set(331797, Long.valueOf(432000 + Wo));
                try {
                    a com_tencent_mm_protocal_c_ajd = new ajd();
                    com_tencent_mm_protocal_c_ajd.wqC = "";
                    for (Account account : AccountManager.get(ac.getContext()).getAccountsByType("com.google")) {
                        if (!bh.ov(com_tencent_mm_protocal_c_ajd.wqC)) {
                            break;
                        }
                        x.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", new Object[]{account.name});
                        com_tencent_mm_protocal_c_ajd.wqC = account.name;
                    }
                    if (10013 == r.idt && r.idu != 0) {
                        com_tencent_mm_protocal_c_ajd.wqC = "rssjbbk@gmail.com";
                    }
                    if (bh.ov(com_tencent_mm_protocal_c_ajd.wqC)) {
                        x.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
                        return;
                    }
                    ar.Hg();
                    c.EX().b(new e.a(57, com_tencent_mm_protocal_c_ajd));
                } catch (Exception e) {
                    x.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", new Object[]{e.getMessage()});
                }
            }
        }
    }
}
