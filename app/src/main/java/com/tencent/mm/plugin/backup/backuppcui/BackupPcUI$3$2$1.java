package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.2;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$3$2$1 implements OnClickListener {
    final /* synthetic */ 2 kow;

    BackupPcUI$3$2$1(2 2) {
        this.kow = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
        b.aps().aoS().stop();
        b.aps().apv().a(true, true, -100);
        g.pQN.a(400, 52, 1, false);
        b.aps().apv().mJ(4);
    }
}
