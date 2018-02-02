package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.base.r;
import java.util.TimerTask;

class e$4 extends TimerTask {
    final /* synthetic */ r kCx;
    final /* synthetic */ af kCy;

    e$4(r rVar, af afVar) {
        this.kCx = rVar;
        this.kCy = afVar;
    }

    public final void run() {
        if (this.kCx != null) {
            this.kCx.dismiss();
            this.kCy.sendEmptyMessage(0);
        }
    }
}
