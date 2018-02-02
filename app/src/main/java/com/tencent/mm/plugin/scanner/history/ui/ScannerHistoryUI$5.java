package com.tencent.mm.plugin.scanner.history.ui;

import com.tencent.mm.plugin.scanner.history.a.a;
import com.tencent.mm.ui.base.h.c;

class ScannerHistoryUI$5 implements c {
    final /* synthetic */ int hvX;
    final /* synthetic */ ScannerHistoryUI pSn;

    ScannerHistoryUI$5(ScannerHistoryUI scannerHistoryUI, int i) {
        this.pSn = scannerHistoryUI;
        this.hvX = i;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                a aVar = (a) ScannerHistoryUI.a(this.pSn).getItem(this.hvX);
                if (aVar != null) {
                    com.tencent.mm.plugin.scanner.c.boB().a(aVar, new String[0]);
                    ScannerHistoryUI.c(this.pSn);
                    ScannerHistoryUI.a(this.pSn).a(null, null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
