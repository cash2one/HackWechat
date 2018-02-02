package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.r;

class bb$1 implements Runnable {
    final /* synthetic */ bb rLm;

    bb$1(bb bbVar) {
        this.rLm = bbVar;
    }

    public final void run() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        bb.a(this.rLm).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ae.bvk();
        r.dB(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
