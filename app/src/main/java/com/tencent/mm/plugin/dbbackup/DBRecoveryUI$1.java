package com.tencent.mm.plugin.dbbackup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class DBRecoveryUI$1 implements OnClickListener {
    final /* synthetic */ DBRecoveryUI lpF;

    DBRecoveryUI$1(DBRecoveryUI dBRecoveryUI) {
        this.lpF = dBRecoveryUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (DBRecoveryUI.a(this.lpF) != 0) {
            DBRecoveryUI.b(this.lpF).setVisibility(0);
            DBRecoveryUI.c(this.lpF).setVisibility(8);
            return;
        }
        d.azG();
    }
}
