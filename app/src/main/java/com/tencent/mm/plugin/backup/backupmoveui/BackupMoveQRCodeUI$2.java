package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveQRCodeUI$2 implements OnClickListener {
    final /* synthetic */ BackupMoveQRCodeUI kmw;

    BackupMoveQRCodeUI$2(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        this.kmw = backupMoveQRCodeUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
        b.aoR().aoS().stop();
        b.aoR().aoT().al(true);
        b.aoR().aol().kiJ = -100;
        BackupMoveQRCodeUI.b(this.kmw);
    }
}
