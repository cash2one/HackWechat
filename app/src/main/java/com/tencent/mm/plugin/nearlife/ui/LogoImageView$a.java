package com.tencent.mm.plugin.nearlife.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;

class LogoImageView$a implements Runnable {
    private af handler;
    private String url;

    LogoImageView$a(String str, af afVar) {
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
