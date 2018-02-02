package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class b$2 implements Runnable {
    final /* synthetic */ b ksn;
    final /* synthetic */ Runnable ksp;

    public b$2(b bVar, Runnable runnable) {
        this.ksn = bVar;
        this.ksp = runnable;
    }

    public final void run() {
        x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb closeTempDB ok");
        x.cfk();
        ar.Dm().a(new 1(this));
    }
}
