package com.tencent.mm.pluginsdk.ui.applet;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;

class CdnImageView$a implements Runnable {
    private af handler;
    private String url;

    CdnImageView$a(String str, af afVar) {
        this.url = str;
        this.handler = afVar;
    }

    public final void run() {
        byte[] VM = bh.VM(this.url);
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putByteArray("k_data", VM);
        bundle.putString("k_url", this.url);
        obtain.setData(bundle);
        this.handler.sendMessage(obtain);
    }
}
