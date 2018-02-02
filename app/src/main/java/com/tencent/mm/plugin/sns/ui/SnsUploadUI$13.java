package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.r;

class SnsUploadUI$13 implements Runnable {
    final /* synthetic */ SnsUploadUI rLR;

    SnsUploadUI$13(SnsUploadUI snsUploadUI) {
        this.rLR = snsUploadUI;
    }

    public final void run() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.rLR.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ae.bvk();
        r.dB(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
