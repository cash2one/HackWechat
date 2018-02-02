package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Handler;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandMainProcessService$3 extends Handler {
    AppBrandMainProcessService$3() {
    }

    public final void handleMessage(Message message) {
        MainProcessTask b = AppBrandMainProcessService.b(message.getData(), false);
        MainProcessTask rX = AppBrandMainProcessService.rX(b.jbo);
        if (rX == null) {
            x.e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", new Object[]{b.jbo});
            return;
        }
        AppBrandMainProcessService.b(b, rX);
        rX.Ys();
    }
}
