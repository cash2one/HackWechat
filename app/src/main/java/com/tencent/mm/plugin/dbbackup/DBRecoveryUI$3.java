package com.tencent.mm.plugin.dbbackup;

import android.view.View;
import android.view.View.OnClickListener;

class DBRecoveryUI$3 implements OnClickListener {
    final /* synthetic */ DBRecoveryUI lpF;

    DBRecoveryUI$3(DBRecoveryUI dBRecoveryUI) {
        this.lpF = dBRecoveryUI;
    }

    public final void onClick(View view) {
        DBRecoveryUI.d(this.lpF).setEnabled(false);
        DBRecoveryUI.f(this.lpF);
    }
}
