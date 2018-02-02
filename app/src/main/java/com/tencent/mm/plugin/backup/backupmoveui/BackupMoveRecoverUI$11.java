package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$11 implements OnClickListener {
    final /* synthetic */ BackupMoveRecoverUI kmF;

    BackupMoveRecoverUI$11(BackupMoveRecoverUI backupMoveRecoverUI) {
        this.kmF = backupMoveRecoverUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
        b.aoR().aoU();
        if (c.aoW()) {
            b.aoR().aoU().aoC();
            return;
        }
        x.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
        b.aoR().aol().kiJ = -22;
        this.kmF.mz(-22);
        g.pQN.a(485, 6, 1, false);
    }
}
