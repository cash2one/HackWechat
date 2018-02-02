package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.ui.e.1;

class e$1$2 implements Runnable {
    final /* synthetic */ 1 jLI;
    final /* synthetic */ View jLJ;
    final /* synthetic */ ViewGroup jLK;

    e$1$2(1 1, View view, ViewGroup viewGroup) {
        this.jLI = 1;
        this.jLJ = view;
        this.jLK = viewGroup;
    }

    public final void run() {
        this.jLJ.setVisibility(8);
        this.jLK.removeView(this.jLJ);
    }
}
