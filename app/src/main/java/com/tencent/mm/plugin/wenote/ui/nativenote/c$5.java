package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;

class c$5 implements Runnable {
    final /* synthetic */ View jLA;
    final /* synthetic */ c tXL;
    final /* synthetic */ boolean tXM;

    c$5(c cVar, View view, boolean z) {
        this.tXL = cVar;
        this.jLA = view;
        this.tXM = z;
    }

    public final void run() {
        this.jLA.setPressed(this.tXM);
    }
}
