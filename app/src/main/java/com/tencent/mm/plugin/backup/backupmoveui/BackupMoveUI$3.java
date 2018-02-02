package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveUI$3 implements OnClickListener {
    final /* synthetic */ BackupMoveUI kmL;

    BackupMoveUI$3(BackupMoveUI backupMoveUI) {
        this.kmL = backupMoveUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
        g.pQN.a(485, 25, 1, false);
        b.aoR().aoS().stop();
        b.aoR().aoT().al(false);
        b.aoR().aol().kiJ = -100;
        BackupMoveUI.c(this.kmL);
    }
}
