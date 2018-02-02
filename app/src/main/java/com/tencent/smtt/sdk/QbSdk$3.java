package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;

class QbSdk$3 extends Thread {
    final /* synthetic */ Context val$context;
    final /* synthetic */ Handler zWk;

    QbSdk$3(Context context, Handler handler) {
        this.val$context = context;
        this.zWk = handler;
    }

    public final void run() {
        if (t.cEF().b(true, this.val$context) == 0) {
            t.cEF().x(this.val$context, true);
        }
        h.nO(true).a(this.val$context, null);
        af cFg = af.cFg();
        cFg.b(this.val$context, null);
        boolean cFh = cFg.cFh();
        this.zWk.sendEmptyMessage(3);
        if (cFh) {
            this.zWk.sendEmptyMessage(1);
        } else {
            this.zWk.sendEmptyMessage(2);
        }
    }
}
