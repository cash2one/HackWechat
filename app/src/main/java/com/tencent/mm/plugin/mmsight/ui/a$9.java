package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.pluginsdk.ui.tools.f$a;

class a$9 implements f$a {
    final /* synthetic */ a oBU;

    a$9(a aVar) {
        this.oBU = aVar;
    }

    public final void hX() {
    }

    public final void vh() {
        if (this.oBU.oBF > 0) {
            this.oBU.oxz.c((double) this.oBU.oBF, true);
        } else {
            this.oBU.oxz.c(0.0d, true);
        }
    }

    public final int cf(int i, int i2) {
        return 0;
    }

    public final void cg(int i, int i2) {
    }

    public final void onError(int i, int i2) {
    }
}
