package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class e$6 implements Runnable {
    final /* synthetic */ e nIr;

    e$6(e eVar) {
        this.nIr = eVar;
    }

    public final void run() {
        ar.Hg();
        if (((Boolean) c.CU().get(a.xph, Boolean.valueOf(false))).booleanValue()) {
            this.nIr.nIq.setVisibility(0);
        } else {
            this.nIr.nIq.setVisibility(8);
        }
        ar.Hg();
        String str = (String) c.CU().get(a.xpj, "");
        ar.Hg();
        String str2 = (String) c.CU().get(a.xpk, "");
        if (!bh.ov(str)) {
            this.nIr.nIp.setText(str);
            this.nIr.nIo.setVisibility(0);
        } else if (bh.ov(str2)) {
            this.nIr.nIp.setText("");
            this.nIr.nIo.setVisibility(8);
        } else {
            this.nIr.nIp.setText(str2);
            this.nIr.nIo.setVisibility(0);
        }
    }
}
