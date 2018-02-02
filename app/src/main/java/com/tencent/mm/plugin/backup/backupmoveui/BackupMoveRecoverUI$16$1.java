package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.16;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$16$1 implements OnClickListener {
    final /* synthetic */ 16 kmK;

    BackupMoveRecoverUI$16$1(16 16) {
        this.kmK = 16;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[]{Integer.valueOf(this.kmK.kly)});
        g.pQN.a(485, 44, 1, false);
        b.aoR().aoU().mD(6);
        b.aoR().aoS().stop();
        b.aoR().aoU().a(true, true, -100);
    }
}
