package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.R;
import com.tencent.mm.plugin.dbbackup.c.1;
import com.tencent.mm.ui.base.h;

class c$1$1 implements Runnable {
    final /* synthetic */ int lpl;
    final /* synthetic */ 1 lpm;

    c$1$1(1 1, int i) {
        this.lpm = 1;
        this.lpl = i;
    }

    public final void run() {
        int i;
        if (this.lpm.lpj != null) {
            this.lpm.lpj.dismiss();
        }
        switch (this.lpl) {
            case -3:
                i = R.l.eCN;
                break;
            case -2:
                i = R.l.eCO;
                break;
            case 0:
                i = R.l.eCP;
                break;
            default:
                i = R.l.eCL;
                break;
        }
        h.h(this.lpm.val$context, i, R.l.dGO);
    }
}
