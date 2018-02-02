package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;

class ae$5 implements Runnable {
    final /* synthetic */ ae qWL;
    final /* synthetic */ int val$id = 0;

    ae$5(ae aeVar) {
        this.qWL = aeVar;
    }

    public final void run() {
        Looper.prepare();
        ae.b(this.qWL)[this.val$id] = new af();
        Looper.loop();
    }
}
