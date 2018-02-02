package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;

class BackupPcChooseUI$4 implements OnClickListener {
    final /* synthetic */ BackupPcChooseUI koo;

    BackupPcChooseUI$4(BackupPcChooseUI backupPcChooseUI) {
        this.koo = backupPcChooseUI;
    }

    public final void onClick(View view) {
        int i = 0;
        if (b.aps().apw().kkG) {
            a a = BackupPcChooseUI.a(this.koo);
            if (a.kmb.size() == a.getCount()) {
                a.kmb.clear();
                a.koj = false;
            } else {
                while (i < a.getCount()) {
                    a.kmb.add(Integer.valueOf(i));
                    i++;
                }
                a.koj = true;
            }
            a.notifyDataSetChanged();
            a.koi.a(a.kmb);
        }
    }
}
