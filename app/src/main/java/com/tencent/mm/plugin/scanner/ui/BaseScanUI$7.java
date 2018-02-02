package com.tencent.mm.plugin.scanner.ui;

import android.hardware.Camera.PreviewCallback;
import android.os.Message;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class BaseScanUI$7 extends af {
    final /* synthetic */ BaseScanUI pUR;

    BaseScanUI$7(BaseScanUI baseScanUI) {
        this.pUR = baseScanUI;
    }

    public final void handleMessage(Message message) {
        if (BaseScanUI.f(this.pUR) != null && BaseScanUI.m(this.pUR)) {
            h f = BaseScanUI.f(this.pUR);
            PreviewCallback previewCallback = this.pUR;
            if (f.gEB != null && f.mgX) {
                try {
                    f.gEB.setOneShotPreviewCallback(previewCallback);
                } catch (RuntimeException e) {
                    x.w("MicroMsg.scanner.ScanCamera", "takeOneShot() " + e.getMessage());
                }
            }
        }
    }
}
