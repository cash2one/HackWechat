package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.13;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$3$13$1 implements OnClickListener {
    final /* synthetic */ 13 koz;

    BackupPcUI$3$13$1(13 13) {
        this.koz = 13;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
        g.pQN.a(400, 26, 1, false);
        b.aps().aoS().stop();
        b.aps().apv().a(true, true, -100);
    }
}
