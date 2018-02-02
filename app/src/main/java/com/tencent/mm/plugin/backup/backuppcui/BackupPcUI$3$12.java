package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$3$12 implements OnClickListener {
    final /* synthetic */ 3 kou;

    BackupPcUI$3$12(3 3) {
        this.kou = 3;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
        b.aps().apv();
        if (!d.aoW()) {
            b.aps().apv();
            if (!d.aoW()) {
                b.aps().aol().kiJ = -22;
                this.kou.mz(-22);
                g.pQN.a(400, 64, 1, false);
                return;
            }
        }
        g.pQN.h(13735, new Object[]{Integer.valueOf(27), Integer.valueOf(b.aps().apt().knJ)});
        b.aps().apv().aoC();
    }
}
