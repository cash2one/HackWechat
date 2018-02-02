package com.tencent.mm.booter;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class MountReceiver$2 implements Runnable {
    final /* synthetic */ MountReceiver gyg;

    MountReceiver$2(MountReceiver mountReceiver) {
        this.gyg = mountReceiver;
    }

    public final void run() {
        x.d("MicroMsg.MountReceiver", "dkmount [MOUNT] action:%s hasuin:%b", new Object[]{MountReceiver.a(this.gyg), Boolean.valueOf(ar.Hj())});
        if (ar.Hj()) {
            g.Dj().CY();
            ar.Hg();
            c.CW();
            MountReceiver.c(this.gyg).sendEmptyMessage(0);
        }
    }
}
