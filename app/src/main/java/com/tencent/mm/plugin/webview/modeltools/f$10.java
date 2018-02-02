package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;

class f$10 extends a {
    private final byte[] gym = new byte[0];
    final /* synthetic */ f tuZ;

    f$10(f fVar) {
        this.tuZ = fVar;
    }

    public final void eq(int i) {
        synchronized (this.gym) {
            if (an.getNetType(ac.getContext()) == 0) {
                ah.bQR().setNetWorkState(1);
            } else {
                ah.bQR().setNetWorkState(2);
            }
        }
    }
}
