package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.backuppcmodel.e.3;
import com.tencent.mm.plugin.backup.f.b.b;
import com.tencent.mm.sdk.platformtools.x;

class e$3$1 implements b {
    final /* synthetic */ 3 kod;

    e$3$1(3 3) {
        this.kod = 3;
    }

    public final void dI(boolean z) {
        if (z) {
            x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
            com.tencent.mm.plugin.backup.f.b.mM(0);
            return;
        }
        this.kod.koc.mK(b.aps().aol().kiJ);
    }
}
