package com.tencent.mm.plugin.appbrand.ipc;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.2;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandMainProcessService$2$1 implements DeathRecipient {
    final /* synthetic */ String gMo;
    final /* synthetic */ IBinder jaR;
    final /* synthetic */ 2 jaS;

    AppBrandMainProcessService$2$1(2 2, IBinder iBinder, String str) {
        this.jaS = 2;
        this.jaR = iBinder;
        this.gMo = str;
    }

    public final void binderDied() {
        this.jaR.unlinkToDeath((DeathRecipient) this.jaS.jaQ.jaG.get(this.gMo), 0);
        this.jaS.jaQ.jaG.remove(this.gMo);
        AppBrandMainProcessService.pK(this.gMo);
        x.e("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", new Object[]{this.gMo});
    }
}
