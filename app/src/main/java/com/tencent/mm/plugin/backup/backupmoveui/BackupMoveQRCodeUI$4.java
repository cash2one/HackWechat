package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveQRCodeUI$4 implements OnClickListener {
    final /* synthetic */ BackupMoveQRCodeUI kmw;

    BackupMoveQRCodeUI$4(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        this.kmw = backupMoveQRCodeUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click cancel.");
        BackupMoveQRCodeUI.d(this.kmw);
    }
}
