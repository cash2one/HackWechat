package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;

final class s implements Runnable {
    private String appId = null;
    private int hNr = 0;
    private af handler = null;
    private String url = null;

    public s(af afVar, String str, int i, String str2) {
        this.handler = afVar;
        this.appId = str;
        this.hNr = i;
        this.url = str2;
    }

    public final void run() {
        if (this.appId != null && this.appId.length() != 0 && this.url != null && this.url.length() != 0) {
            u uVar = new u(this.appId, this.hNr, bh.VM(this.url));
            Message obtain = Message.obtain();
            obtain.obj = uVar;
            this.handler.sendMessage(obtain);
        }
    }
}
