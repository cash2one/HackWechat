package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveQRCodeUI$5 implements OnClickListener {
    final /* synthetic */ BackupMoveQRCodeUI kmw;

    BackupMoveQRCodeUI$5(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        this.kmw = backupMoveQRCodeUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click move all.");
        BackupMoveQRCodeUI.c(this.kmw);
        b.aoR().aoT().dF(true);
    }
}
