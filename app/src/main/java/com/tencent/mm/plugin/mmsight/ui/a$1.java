package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.api.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements e {
    final /* synthetic */ a oBU;

    a$1(a aVar) {
        this.oBU = aVar;
    }

    public final void onFinish() {
        x.i("MicroMsg.MMSightVideoEditor", "photoEditor onFinish");
        this.oBU.oBJ.a(new 1(this));
    }

    public final void sW() {
        x.i("MicroMsg.MMSightVideoEditor", "photoEditor onExit");
        this.oBU.release();
        if (this.oBU.oBM != null) {
            ag.y(new 2(this));
        }
    }
}
