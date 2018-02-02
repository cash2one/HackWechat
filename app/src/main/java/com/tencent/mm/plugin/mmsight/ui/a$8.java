package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.sdk.platformtools.x;

class a$8 implements b {
    final /* synthetic */ a oBU;

    a$8(a aVar) {
        this.oBU = aVar;
    }

    public final void A(float f, float f2) {
        if (this.oBU.oxz != null) {
            int i = this.oBU.oBE;
            this.oBU.oBF = Math.round(((float) i) * f);
            this.oBU.oBG = Math.round(((float) i) * f2);
            x.i("MicroMsg.MMSightVideoEditor", "onRecyclerChanged, start: %s, end: %s %s %s", new Object[]{Integer.valueOf(this.oBU.oBF), Integer.valueOf(this.oBU.oBG), Float.valueOf(f), Float.valueOf(f2)});
            this.oBU.oxz.c((double) this.oBU.oBF, true);
        }
    }

    public final void bbb() {
        if (this.oBU.oxz != null) {
            this.oBU.oxz.pause();
        }
    }

    public final void B(float f, float f2) {
        if (this.oBU.oxz != null) {
            int i = this.oBU.oBE;
            this.oBU.oBF = Math.round(((float) i) * f);
            this.oBU.oBG = Math.round(((float) i) * f2);
            this.oBU.oxz.c((double) this.oBU.oBF, true);
            x.i("MicroMsg.MMSightVideoEditor", "onUp, start: %s, end: %s %s %s", new Object[]{Integer.valueOf(this.oBU.oBF), Integer.valueOf(this.oBU.oBG), Float.valueOf(f), Float.valueOf(f2)});
        }
    }

    public final void C(float f, float f2) {
    }
}
