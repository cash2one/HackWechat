package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class b$4 implements OnClickListener {
    final /* synthetic */ Activity oZ;

    b$4(Activity activity) {
        this.oZ = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.oZ instanceof WalletOfflineCoinPurseUI) {
            ((WalletOfflineCoinPurseUI) this.oZ).oYD = false;
        }
        dialogInterface.dismiss();
    }
}
