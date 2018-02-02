package com.tencent.mm.plugin.dbbackup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class DBRecoveryUI$5 implements OnClickListener {
    final /* synthetic */ DBRecoveryUI lpF;

    DBRecoveryUI$5(DBRecoveryUI dBRecoveryUI) {
        this.lpF = dBRecoveryUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lpF.finish();
        d.azG();
    }
}
