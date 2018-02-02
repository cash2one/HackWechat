package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.12;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$12$1 implements OnClickListener {
    final /* synthetic */ 12 kmJ;

    BackupMoveRecoverUI$12$1(12 12) {
        this.kmJ = 12;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", Integer.valueOf(this.kmJ.kly));
        g.pQN.a(485, 48, 1, false);
        b.aoR().aoS().stop();
        b.aoR().aoU().a(true, true, -100);
    }
}
