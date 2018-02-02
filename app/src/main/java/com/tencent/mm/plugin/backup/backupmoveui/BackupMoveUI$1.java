package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;

class BackupMoveUI$1 implements OnClickListener {
    final /* synthetic */ BackupMoveUI kmL;

    BackupMoveUI$1(BackupMoveUI backupMoveUI) {
        this.kmL = backupMoveUI;
    }

    public final void onClick(View view) {
        b.aoR().aoS().stop();
        b.aoR().aoT().al(true);
        b.aoR().aol().kiJ = -100;
        BackupMoveUI.a(this.kmL);
    }
}
