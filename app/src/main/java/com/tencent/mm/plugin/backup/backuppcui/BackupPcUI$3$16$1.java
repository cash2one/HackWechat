package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.16;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$3$16$1 implements OnClickListener {
    final /* synthetic */ 16 koA;

    BackupPcUI$3$16$1(16 16) {
        this.koA = 16;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
        b.aps().aoS().stop();
        b.aps().apu().al(true);
        b.aps().aol().kiJ = -100;
        g.pQN.a(400, 52, 1, false);
        b.aps().apu().mJ(4);
        BackupPcUI.k(this.koA.kou.kot);
    }
}
