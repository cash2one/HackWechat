package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class d$1 extends af {
    final /* synthetic */ d tHd;

    d$1(d dVar, Looper looper) {
        this.tHd = dVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                String str = (String) message.obj;
                if (!bh.ov(str)) {
                    d.b(this.tHd).add(str);
                }
                d.c(this.tHd);
                return;
            case 2:
                x.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + message.obj);
                return;
            default:
                return;
        }
    }
}
