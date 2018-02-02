package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;

class b$5 implements Runnable {
    final /* synthetic */ b kqA;

    b$5(b bVar) {
        this.kqA = bVar;
    }

    public final void run() {
        Looper.prepare();
        b.a(this.kqA, new af());
        Looper.loop();
    }
}
