package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$2 implements OnClickListener {
    final /* synthetic */ BackupPcUI kot;

    BackupPcUI$2(BackupPcUI backupPcUI) {
        this.kot = backupPcUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge.");
        g.pQN.a(400, 26, 1, false);
        b.aps().aoS().stop();
        b.aps().apv().a(true, true, -100);
    }
}
