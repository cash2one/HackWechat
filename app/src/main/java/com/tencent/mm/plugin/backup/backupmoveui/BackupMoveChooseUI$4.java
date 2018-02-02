package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;

class BackupMoveChooseUI$4 implements OnClickListener {
    final /* synthetic */ BackupMoveChooseUI kmr;

    BackupMoveChooseUI$4(BackupMoveChooseUI backupMoveChooseUI) {
        this.kmr = backupMoveChooseUI;
    }

    public final void onClick(View view) {
        int i = 0;
        if (b.aoR().aoV().kkG) {
            a a = BackupMoveChooseUI.a(this.kmr);
            if (a.kmb.size() == a.getCount()) {
                a.kmb.clear();
                a.kmc = false;
            } else {
                while (i < a.getCount()) {
                    a.kmb.add(Integer.valueOf(i));
                    i++;
                }
                a.kmc = true;
            }
            a.notifyDataSetChanged();
            a.kma.a(a.kmb);
        }
    }
}
