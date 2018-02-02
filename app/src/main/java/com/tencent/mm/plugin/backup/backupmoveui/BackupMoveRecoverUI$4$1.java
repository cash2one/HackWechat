package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.4;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$4$1 implements OnClickListener {
    final /* synthetic */ 4 kmH;

    BackupMoveRecoverUI$4$1(4 4) {
        this.kmH = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[]{Integer.valueOf(this.kmH.kly)});
        g.pQN.a(485, 44, 1, false);
        b.aoR().aoU().mD(5);
        b.aoR().aoS().stop();
        b.aoR().aoU().a(true, true, -100);
    }
}
