package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.multitalk.a.e.3;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.voip.model.d;

class e$3$2 implements Runnable {
    final /* synthetic */ 3 oGB;

    e$3$2(3 3) {
        this.oGB = 3;
    }

    public final void run() {
        if (this.oGB.oGz.oGh == e.oIA) {
            d.bGk().wZ(this.oGB.oGz.oGk);
            if (this.oGB.oGz.oGq != null) {
                this.oGB.oGz.oGq.aTh();
            }
        }
    }
}
