package com.tencent.mm.plugin.backup.backuppcui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.f.b;
import com.tencent.mm.plugin.backup.b.b.a;
import java.util.LinkedList;

class BackupPcChooseUI$5 implements a {
    final /* synthetic */ BackupPcChooseUI koo;

    BackupPcChooseUI$5(BackupPcChooseUI backupPcChooseUI) {
        this.koo = backupPcChooseUI;
    }

    public final void v(LinkedList<b> linkedList) {
        if (linkedList != null) {
            if (linkedList.size() == 0) {
                BackupPcChooseUI.b(this.koo).setVisibility(8);
                BackupPcChooseUI.c(this.koo).setVisibility(0);
                switch (BackupPcChooseUI.JM()) {
                    case 0:
                        BackupPcChooseUI.c(this.koo).setText(R.l.dIE);
                        return;
                    case 1:
                        BackupPcChooseUI.c(this.koo).setText(R.l.dJK);
                        return;
                    default:
                        return;
                }
            }
            BackupPcChooseUI.d(this.koo).setClickable(true);
            BackupPcChooseUI.b(this.koo).setVisibility(4);
            BackupPcChooseUI.a(this.koo).notifyDataSetChanged();
        }
    }
}
