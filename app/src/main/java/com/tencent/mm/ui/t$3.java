package com.tencent.mm.ui;

import android.content.Context;
import com.tencent.mm.pluginsdk.model.app.a;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class t$3 implements Runnable {
    final /* synthetic */ String jkM;
    final /* synthetic */ Context val$context;
    final /* synthetic */ int xKc;

    t$3(int i, String str, Context context) {
        this.xKc = i;
        this.jkM = str;
        this.val$context = context;
    }

    public final void run() {
        if (this.xKc == 4 && a.bYz() == null) {
            x.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
        } else if (q.x.bYd() != null && q.x.bYd().IB(this.jkM) != null) {
            ag.y(new Runnable(this) {
                final /* synthetic */ t$3 xKd;

                {
                    this.xKd = r1;
                }

                public final void run() {
                    if (q.x.bYd() != null) {
                        q.x.bYd().ds(this.xKd.val$context);
                    }
                }
            });
        }
    }
}
