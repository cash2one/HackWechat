package com.tencent.mm.booter;

import com.tencent.mm.booter.NotifyReceiver.a;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class NotifyReceiver$a$3 implements Runnable {
    final /* synthetic */ a gyr;

    NotifyReceiver$a$3(a aVar) {
        this.gyr = aVar;
    }

    public final void run() {
        if (g.Dh().Cy()) {
            int i;
            if (bh.e((Integer) g.Dj().CU().get(15, null)) == 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                x.e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
                return;
            }
            long Wp = bh.Wp();
            if (Wp - a.jD() <= 0 || Wp - a.jD() >= 10000) {
                a.ay(Wp);
                x.i("MicroMsg.NotifyReceiver", "begin post sync task");
                Wp = bh.Wq();
                com.tencent.mm.sdk.b.a.xef.m(new lu());
                x.i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", new Object[]{Long.valueOf(bh.bA(Wp))});
                a.b(this.gyr);
                return;
            }
            x.d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", new Object[]{Long.valueOf(Wp - a.jD())});
        }
    }

    public final String toString() {
        return super.toString() + "|doPostSyncTask";
    }
}
