package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.os.Message;
import android.os.Messenger;
import com.tencent.mm.plugin.webview.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.a;
import com.tencent.mm.plugin.webview.wepkg.utils.d;

class WepkgProcessPreloadService$4 extends a {
    final /* synthetic */ Messenger tMw;
    final /* synthetic */ Message tMx;

    WepkgProcessPreloadService$4(Messenger messenger, Message message) {
        this.tMw = messenger;
        this.tMx = message;
    }

    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
        if ((baseWepkgProcessTask instanceof WepkgCrossProcessTask) && baseWepkgProcessTask.fnI) {
            d.Dm().F(new 1(this, ((WepkgCrossProcessTask) baseWepkgProcessTask).tMW));
        }
    }
}
