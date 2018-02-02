package com.tencent.mm.modelstat;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements Runnable {
    final /* synthetic */ c hQj;
    final /* synthetic */ Intent val$intent;

    c$3(c cVar, Intent intent) {
        this.hQj = cVar;
        this.val$intent = intent;
    }

    public final void run() {
        String stringExtra = this.val$intent.getStringExtra("ui");
        int intExtra = this.val$intent.getIntExtra("uiHashCode", 0);
        int intExtra2 = this.val$intent.getIntExtra("opCode", 0);
        x.d("MicroMsg.ClickFlowStatReceiver", "onReceive op:%d ui:%s hash:0x%x time:%d, elapsed time:%d", new Object[]{Integer.valueOf(intExtra2), stringExtra, Integer.valueOf(intExtra), Long.valueOf(bh.bz(this.val$intent.getLongExtra("nowMilliSecond", 0))), Long.valueOf(this.val$intent.getLongExtra("elapsedRealtime", 0))});
        if (2147483632 == intExtra2) {
            c.a(this.hQj);
        } else {
            c.a(this.hQj, intExtra2, stringExtra, intExtra, r4, r6);
        }
    }
}
