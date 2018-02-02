package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class FingerPrintAuthUI$4 implements Runnable {
    final /* synthetic */ int fmb;
    final /* synthetic */ String gID;
    final /* synthetic */ FingerPrintAuthUI mAe;

    FingerPrintAuthUI$4(FingerPrintAuthUI fingerPrintAuthUI, String str, int i) {
        this.mAe = fingerPrintAuthUI;
        this.gID = str;
        this.fmb = i;
    }

    public final void run() {
        h.a(this.mAe, this.gID, "", this.mAe.getString(i.uRP), false, new 1(this));
    }
}
