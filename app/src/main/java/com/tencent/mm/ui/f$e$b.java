package com.tencent.mm.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f.e;

class f$e$b extends af {
    final /* synthetic */ e xEM;
    boolean xEN;
    public final int xEO = 1;
    public final int xEP = 2;

    public f$e$b(e eVar, Looper looper) {
        this.xEM = eVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (!this.xEN) {
            synchronized (this.xEM) {
                this.xEM.xEK = this.xEM.cmg();
                x.i(this.xEM.xED.TAG, "newcursor updateWorkerRefresh status %d", new Object[]{Integer.valueOf(this.xEM.xEK)});
            }
            if (message.what == 1) {
                f.d(this.xEM.xED);
            } else if (message.what == 2) {
                f.a(this.xEM.xED, (f$c) message.obj, false, true);
            }
        }
    }
}
