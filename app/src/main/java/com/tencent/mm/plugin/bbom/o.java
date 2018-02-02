package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.network.n;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak;

public final class o {
    private static boolean kvF = false;

    static /* synthetic */ void ard() {
        if (!g.Dh().Cy() || a.Cs()) {
            x.w("MicroMsg.OnNetworkAvailableListener", "dealWithNetworkAvailable hasSetuin:" + g.Dh().Cy() + " isHold:" + a.Cs());
            return;
        }
        m.UF().run();
        com.tencent.mm.modelvideo.o.TZ().run();
        com.tencent.mm.aq.o.Pu().run();
        an.bYU().run();
        if (ak.a.hfO != null) {
            ak.a.hfO.GS();
        }
        com.tencent.mm.sdk.b.a.xef.m(new qq());
    }

    public static synchronized void cb(final Context context) {
        synchronized (o.class) {
            if (!kvF) {
                kvF = true;
                g.Di().a(new n.a() {
                    public final void eq(int i) {
                        if (i == 4 || i == 6) {
                            o.ard();
                        }
                    }
                });
            }
        }
    }
}
