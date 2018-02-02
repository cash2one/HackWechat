package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class BaseScanUI$16 implements OnClickListener {
    final /* synthetic */ BaseScanUI pUR;

    BaseScanUI$16(BaseScanUI baseScanUI) {
        this.pUR = baseScanUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        BaseScanUI.j(this.pUR);
        this.pUR.finish();
    }
}
