package com.tencent.mm.ui;

import com.tencent.mm.storage.t;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class HomeUI$13 implements Runnable {
    final /* synthetic */ HomeUI xGv;

    HomeUI$13(HomeUI homeUI) {
        this.xGv = homeUI;
    }

    public final void run() {
        if (ar.Hj()) {
            ar.Hg();
            t CU = c.CU();
            if (CU != null) {
                CU.lH(true);
            }
        }
    }
}
