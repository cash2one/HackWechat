package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.3;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$3$3$1 implements OnClickListener {
    final /* synthetic */ 3 kox;

    BackupPcUI$3$3$1(3 3) {
        this.kox = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
        g.pQN.a(400, 10, 1, false);
        b.aps().apu().mJ(4);
        b.aps().aoS().stop();
        b.aps().apu().al(true);
        b.aps().aol().kiJ = -100;
        BackupPcUI.l(this.kox.kou.kot);
    }
}
