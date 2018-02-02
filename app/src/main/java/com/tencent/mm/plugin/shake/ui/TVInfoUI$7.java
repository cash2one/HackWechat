package com.tencent.mm.plugin.shake.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ui.base.preference.f;

class TVInfoUI$7 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ String oZc;
    final /* synthetic */ TVInfoUI qsE;

    TVInfoUI$7(TVInfoUI tVInfoUI, String str, Bitmap bitmap) {
        this.qsE = tVInfoUI;
        this.oZc = str;
        this.jsN = bitmap;
    }

    public final void run() {
        if (TVInfoUI.e(this.qsE) != null && TVInfoUI.e(this.qsE).equals(this.oZc)) {
            if (!(TVInfoUI.f(this.qsE) == null || this.jsN == null)) {
                TVInfoUI.f(this.qsE).setImageBitmap(this.jsN);
                TVInfoUI.g(this.qsE);
            }
            TVInfoUI.h(this.qsE);
        }
        f fVar = this.qsE.ilB;
    }
}
