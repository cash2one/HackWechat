package com.tencent.mm.be;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.be.e.2;
import com.tencent.mm.sdk.platformtools.as.a;

class e$2$1 implements IdleHandler {
    final /* synthetic */ 2 hPu;

    e$2$1(2 2) {
        this.hPu = 2;
    }

    public final boolean queueIdle() {
        this.hPu.hPt.b(new a(this) {
            final /* synthetic */ e$2$1 hPv;

            {
                this.hPv = r1;
            }

            public final boolean JB() {
                return true;
            }

            public final boolean JC() {
                e.b(this.hPv.hPu.hPt);
                return false;
            }
        });
        return false;
    }
}
