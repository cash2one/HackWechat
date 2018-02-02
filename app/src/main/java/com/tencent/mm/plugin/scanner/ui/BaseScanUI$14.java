package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.e.b;

class BaseScanUI$14 implements OnClickListener {
    final /* synthetic */ BaseScanUI pUR;

    BaseScanUI$14(BaseScanUI baseScanUI) {
        this.pUR = baseScanUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.aL(this.pUR);
        this.pUR.finish();
    }
}
