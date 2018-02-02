package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.ak.a;

class a$10 implements a {
    final /* synthetic */ a oBU;

    a$10(a aVar) {
        this.oBU = aVar;
    }

    public final boolean uF() {
        if (this.oBU.oxz != null && this.oBU.oxz.isPlaying()) {
            if (this.oBU.oBG <= 0 || this.oBU.oxz.getCurrentPosition() < this.oBU.oBG) {
                this.oBU.oBC.al(((float) this.oBU.oxz.getCurrentPosition()) / ((float) this.oBU.oBE));
            } else {
                this.oBU.oxz.c((double) this.oBU.oBF, true);
                this.oBU.oBC.al(((float) this.oBU.oBF) / ((float) this.oBU.oBE));
            }
        }
        return true;
    }
}
