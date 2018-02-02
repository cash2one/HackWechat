package com.tencent.mm.ca;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements Runnable {
    final /* synthetic */ boolean xCY;
    final /* synthetic */ boolean xCZ;
    final /* synthetic */ boolean xDa;
    final /* synthetic */ boolean xDb;

    c$1(boolean z, boolean z2, boolean z3, boolean z4) {
        this.xCY = z;
        this.xCZ = z2;
        this.xDa = z3;
        this.xDb = z4;
    }

    public final void run() {
        if (c.ya()) {
            x.w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
            return;
        }
        String R;
        if (this.xCY) {
            R = b.R(true, false);
        } else {
            R = null;
        }
        Process.setThreadPriority(10);
        boolean isWifi = an.isWifi(ac.getContext());
        if (!this.xCZ || isWifi) {
            if (!this.xDa || r0 == null) {
                R = this.xDb ? b.xCV : null;
            }
            c.bc(true);
            c.lK(R);
            c.bc(false);
            return;
        }
        x.w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
    }
}
