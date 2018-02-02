package com.tencent.mm.plugin.setting.a;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class a$2 implements Runnable {
    final /* synthetic */ a qgt;

    a$2(a aVar) {
        this.qgt = aVar;
    }

    public final void run() {
        try {
            this.qgt.qgm.await();
            long currentTimeMillis = System.currentTimeMillis();
            this.qgt.qgn.clear();
            this.qgt.qgo.remove(q.FS());
            this.qgt.qgn.addAll(this.qgt.qgo);
            this.qgt.qgn.addAll(this.qgt.qgp);
            this.qgt.qgn.addAll(this.qgt.qgq);
            if (this.qgt.qgk) {
                this.qgt.qgn.retainAll(this.qgt.qgq);
            }
            if (this.qgt.qgl) {
                this.qgt.qgn.retainAll(this.qgt.qgp);
            }
            if (this.qgt.qgj) {
                this.qgt.qgn.retainAll(this.qgt.qgo);
            }
            this.qgt.qgs.e(this.qgt.qgn);
            x.i("MicroMsg.UnfamiliarContactEngine", "[onResult] :%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            ag.y(new Runnable(this) {
                final /* synthetic */ a$2 qgu;

                {
                    this.qgu = r1;
                }

                public final void run() {
                    this.qgu.qgt.qgs.onSuccess();
                }
            });
            x.i("MicroMsg.UnfamiliarContactEngine", "all cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.qgt.mYz)});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UnfamiliarContactEngine", e, "", new Object[0]);
            ag.y(new 2(this));
        }
    }
}
