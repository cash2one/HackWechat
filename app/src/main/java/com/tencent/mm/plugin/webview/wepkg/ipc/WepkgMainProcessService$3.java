package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;

class WepkgMainProcessService$3 extends Handler {
    WepkgMainProcessService$3(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        WepkgMainProcessTask ad = WepkgMainProcessService.ad(message.getData());
        WepkgMainProcessTask Bh = WepkgMainProcessService.Bh(i);
        if (Bh == null) {
            x.e("MicroMsg.Wepkg.WepkgMainProcessService", "receive client msg, get null task by id %s", new Object[]{Integer.valueOf(i)});
            return;
        }
        WepkgMainProcessService.b(ad, Bh);
        Bh.Ys();
    }
}
