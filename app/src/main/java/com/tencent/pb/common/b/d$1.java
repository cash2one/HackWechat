package com.tencent.pb.common.b;

import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.f;

class d$1 implements Runnable {
    final /* synthetic */ d zMh;

    d$1(d dVar) {
        this.zMh = dVar;
    }

    public final void run() {
        this.zMh.kAd = true;
        c.d("MicroMsg.Voip", new Object[]{"NETTASK_RECV TimeOut cmd= ", this.zMh.cCD()});
        f.w(20006, 3, "-1104");
        if (this.zMh.zMc != null) {
            this.zMh.zMc.a(2, -1, "time exceed, force to callback", this.zMh);
        }
    }
}
