package com.tencent.mm.plugin.location.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;

class SimpleImageView$a implements Runnable {
    private af handler;
    private String url;

    public SimpleImageView$a(String str, af afVar) {
        this.url = str;
        this.handler = afVar;
    }

    public final void run() {
        Object VM = bh.VM(this.url);
        Message obtain = Message.obtain();
        obtain.obj = VM;
        this.handler.sendMessage(obtain);
    }
}
