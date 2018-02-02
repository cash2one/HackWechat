package com.tencent.mm.plugin.backup.backupmoveui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;

class BackupUI$4 implements a {
    final /* synthetic */ BackupUI kmO;

    BackupUI$4(BackupUI backupUI) {
        this.kmO = backupUI;
    }

    public final boolean uF() {
        if (bh.ov(g.cl(this.kmO))) {
            if (BackupUI.ya()) {
                BackupUI.a(this.kmO).setText(R.l.dJO);
                BackupUI.a(this.kmO).setTextColor(this.kmO.getResources().getColor(R.e.brw));
                BackupUI.b(this.kmO).setEnabled(false);
                BackupUI.bc(false);
                com.tencent.mm.plugin.report.service.g.pQN.h(11788, Integer.valueOf(2));
            }
        } else if (!BackupUI.ya()) {
            BackupUI.a(this.kmO).setText(R.l.dJP);
            BackupUI.a(this.kmO).setTextColor(this.kmO.getResources().getColor(R.e.brv));
            BackupUI.b(this.kmO).setEnabled(true);
            BackupUI.bc(true);
        }
        return true;
    }
}
