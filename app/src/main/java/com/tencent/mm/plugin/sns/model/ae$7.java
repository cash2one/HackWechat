package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;

class ae$7 implements Runnable {
    final /* synthetic */ ae qWL;

    ae$7(ae aeVar) {
        this.qWL = aeVar;
    }

    public final void run() {
        Looper.prepare();
        ae.b(this.qWL, new af());
        Looper.loop();
    }
}
