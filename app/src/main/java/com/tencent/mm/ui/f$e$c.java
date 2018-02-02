package com.tencent.mm.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.f.e;
import java.util.LinkedList;

class f$e$c extends af {
    long lastUpdateTime;
    final /* synthetic */ e xEM;
    long xEQ;
    final int xER = (hashCode() | 1910);
    final int xES = (hashCode() | 1914);

    public f$e$c(e eVar, Looper looper) {
        this.xEM = eVar;
        super(looper);
        eVar.xEJ = new LinkedList();
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == this.xES) {
            removeMessages(this.xER);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.xEQ > ((long) this.xEM.xED.xEv) || currentTimeMillis - this.xEQ < 0 || ((this.lastUpdateTime != 0 && currentTimeMillis - this.lastUpdateTime > ((long) this.xEM.xED.xEw)) || currentTimeMillis - this.lastUpdateTime < 0)) {
                e.a(this.xEM);
            } else {
                sendEmptyMessageDelayed(this.xER, (long) this.xEM.xED.xEv);
            }
            this.xEQ = currentTimeMillis;
        } else if (message.what == this.xER) {
            e.a(this.xEM);
        }
    }
}
