package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mm.plugin.appbrand.launching.precondition.d.1;
import com.tencent.mm.sdk.platformtools.x;

class d$1$1 implements Runnable {
    final /* synthetic */ 1 jzb;

    d$1$1(1 1) {
        this.jzb = 1;
    }

    public final void run() {
        x.i("MicroMsg.AppBrand.Precondition.FromClientPreconditionProcess", "finish(), before send result, ui finishing %b, ui destroyed %b", new Object[]{Boolean.valueOf(this.jzb.jza.isFinishing()), Boolean.valueOf(this.jzb.jza.aij())});
        ResultReceiver resultReceiver = (ResultReceiver) d.a(this.jzb.jza).getParcelableExtra("extra_result_receiver");
        if (resultReceiver != null) {
            resultReceiver.send(-1, Bundle.EMPTY);
        }
        d.b(this.jzb.jza);
    }
}
