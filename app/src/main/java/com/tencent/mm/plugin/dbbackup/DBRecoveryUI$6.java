package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.ui.base.i;

class DBRecoveryUI$6 implements Runnable {
    final /* synthetic */ DBRecoveryUI lpF;
    final /* synthetic */ i lpG;

    DBRecoveryUI$6(DBRecoveryUI dBRecoveryUI, i iVar) {
        this.lpF = dBRecoveryUI;
        this.lpG = iVar;
    }

    public final void run() {
        this.lpG.dismiss();
        this.lpF.finish();
        d.azG();
    }
}
