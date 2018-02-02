package com.tencent.mm.ui.conversation;

import android.widget.ListView;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    d kZW = new d(new 1(this));
    ListView yVR;
    g yWw;
    boolean yZP = false;
    private ag yZQ;
    private Runnable yZR;
    int yZS = -1;

    static /* synthetic */ void a(k kVar, int i) {
        if (i < 0) {
            i = 300;
        }
        kVar.cwM();
        if (kVar.yZQ == null) {
            kVar.yZQ = new ag("pre load mainui avatar");
        }
        kVar.yZP = false;
        ag agVar = kVar.yZQ;
        Runnable 3 = new 3(kVar);
        kVar.yZR = 3;
        agVar.g(3, (long) i);
    }

    final void cwM() {
        if (!this.yZP) {
            x.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
            this.yZP = true;
        }
        if (this.yZQ != null && this.yZR != null) {
            this.yZQ.cfF().removeCallbacks(this.yZR);
        }
    }
}
