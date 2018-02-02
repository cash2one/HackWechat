package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$8 implements OnClickListener {
    final /* synthetic */ BackupMoveRecoverUI kmF;
    final /* synthetic */ int kmI;

    BackupMoveRecoverUI$8(BackupMoveRecoverUI backupMoveRecoverUI, int i) {
        this.kmF = backupMoveRecoverUI;
        this.kmI = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d]", new Object[]{Integer.valueOf(this.kmI)});
        g.pQN.a(485, 48, 1, false);
        b.aoR().aoS().stop();
        b.aoR().aoU().a(true, true, -100);
    }
}
