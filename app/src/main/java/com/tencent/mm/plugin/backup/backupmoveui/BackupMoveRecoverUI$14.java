package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;

class BackupMoveRecoverUI$14 implements OnClickListener {
    final /* synthetic */ BackupMoveRecoverUI kmF;

    BackupMoveRecoverUI$14(BackupMoveRecoverUI backupMoveRecoverUI) {
        this.kmF = backupMoveRecoverUI;
    }

    public final void onClick(View view) {
        b.aoR().aoS().stop();
        b.aoR().aol().kiJ = -100;
        BackupMoveRecoverUI.b(this.kmF);
    }
}
