package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;

class ae$4 implements Runnable {
    final /* synthetic */ ae qWL;
    final /* synthetic */ int val$id;

    ae$4(ae aeVar, int i) {
        this.qWL = aeVar;
        this.val$id = i;
    }

    public final void run() {
        Looper.prepare();
        ae.a(this.qWL)[this.val$id] = new af();
        Looper.loop();
    }
}
