package com.tencent.mm.plugin.scanner.ui;

import android.hardware.Camera.AutoFocusCallback;
import android.os.Message;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class BaseScanUI$9 extends af {
    final /* synthetic */ BaseScanUI pUR;

    BaseScanUI$9(BaseScanUI baseScanUI) {
        this.pUR = baseScanUI;
    }

    public final void handleMessage(Message message) {
        if (BaseScanUI.f(this.pUR) != null && BaseScanUI.m(this.pUR) && !BaseScanUI.G(this.pUR) && message.what == 0) {
            BaseScanUI.a(this.pUR, System.currentTimeMillis());
            h f = BaseScanUI.f(this.pUR);
            AutoFocusCallback autoFocusCallback = this.pUR;
            if (f.gEB != null && f.mgX) {
                try {
                    f.bpG();
                    f.gEB.autoFocus(autoFocusCallback);
                } catch (RuntimeException e) {
                    x.w("MicroMsg.scanner.ScanCamera", "autoFocus() " + e.getMessage());
                }
            }
        }
    }
}
