package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class BaseScanUI$15 implements OnClickListener {
    final /* synthetic */ BaseScanUI pUR;

    BaseScanUI$15(BaseScanUI baseScanUI) {
        this.pUR = baseScanUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pUR.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        BaseScanUI.j(this.pUR);
        this.pUR.finish();
    }
}
