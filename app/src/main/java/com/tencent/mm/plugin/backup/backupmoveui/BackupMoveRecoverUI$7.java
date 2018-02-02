package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$7 implements OnClickListener {
    final /* synthetic */ BackupMoveRecoverUI kmF;
    final /* synthetic */ int kmI;

    BackupMoveRecoverUI$7(BackupMoveRecoverUI backupMoveRecoverUI, int i) {
        this.kmF = backupMoveRecoverUI;
        this.kmI = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", new Object[]{Integer.valueOf(this.kmI)});
        g.pQN.a(485, 44, 1, false);
        b.aoR().aoU().mD(5);
        b.aoR().aoS().stop();
        b.aoR().aoU().a(true, true, -100);
    }
}
