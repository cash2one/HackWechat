package com.tencent.mm.plugin.nfc_open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.hce.a.b;
import com.tencent.mm.plugin.nfc.c.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ a oSg;

    a$1(a aVar) {
        this.oSg = aVar;
    }

    public final void run() {
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "system_config_prefs", 4);
        if (bh.bA(sharedPreferences.getLong("NFC_REPORT_TIME", 0)) > 86400000) {
            int i;
            int dj = a.bfv().dj(ac.getContext());
            int i2 = dj == 0 ? 0 : 1;
            if (b.aSr()) {
                i = 1;
            } else {
                i = 0;
            }
            x.i("MicroMsg.SubCoreCpuCard", "alvinluo NFC report isSupportNFC: %d, isSupportHCE: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
            g.pQN.h(12779, new Object[]{q.yE(), Integer.valueOf(i2), Integer.valueOf(i)});
            Editor edit = sharedPreferences.edit();
            edit.putLong("NFC_REPORT_TIME", bh.Wq());
            edit.commit();
            x.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = " + dj);
        }
    }
}
