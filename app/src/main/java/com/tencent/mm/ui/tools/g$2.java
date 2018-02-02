package com.tencent.mm.ui.tools;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements Runnable {
    final /* synthetic */ View rpV;
    final /* synthetic */ g zkR;

    g$2(g gVar, View view) {
        this.zkR = gVar;
        this.rpV = view;
    }

    public final void run() {
        if (this.zkR.rpS == this.zkR.rpN) {
            x.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
            this.rpV.requestLayout();
        }
    }
}
