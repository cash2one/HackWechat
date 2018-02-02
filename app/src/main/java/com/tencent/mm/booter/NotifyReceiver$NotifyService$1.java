package com.tencent.mm.booter;

import android.content.Intent;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class NotifyReceiver$NotifyService$1 implements g {
    final /* synthetic */ long gyu;
    final /* synthetic */ Intent gyv;
    final /* synthetic */ NotifyService gyw;

    NotifyReceiver$NotifyService$1(NotifyService notifyService, long j, Intent intent) {
        this.gyw = notifyService;
        this.gyu = j;
        this.gyv = intent;
    }

    public final void ul() {
        com.tencent.mm.kernel.g.Dk().b(this);
        NotifyService.a(this.gyw);
        long currentTimeMillis = System.currentTimeMillis() - this.gyu;
        x.i("MicroMsg.NotifyReceiver", "summerboot startupDone[%b] take[%d]ms tid[%d] post last notify task", new Object[]{Boolean.valueOf(com.tencent.mm.kernel.g.Dk().gQE.gQX), Long.valueOf(currentTimeMillis), Long.valueOf(Thread.currentThread().getId())});
        d.pPH.h(11098, new Object[]{Integer.valueOf(3600), Long.valueOf(currentTimeMillis)});
        d.pPH.a(99, 214, 1, false);
        ag.h(new 1(this), 500);
    }

    public final void aG(boolean z) {
    }
}
