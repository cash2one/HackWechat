package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$1 implements OnClickListener {
    final /* synthetic */ int kmP;
    final /* synthetic */ BackupPcUI kot;

    BackupPcUI$1(BackupPcUI backupPcUI, int i) {
        this.kot = backupPcUI;
        this.kmP = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupPcUI", "low battery, user click sure. battery:%d", new Object[]{Integer.valueOf(this.kmP)});
    }
}
