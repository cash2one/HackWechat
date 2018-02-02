package com.tencent.liteav.screencapture;

import android.os.Handler;
import android.os.HandlerThread;

class a$2 implements Runnable {
    final /* synthetic */ Handler a;
    final /* synthetic */ HandlerThread b;
    final /* synthetic */ a c;

    a$2(a aVar, Handler handler, HandlerThread handlerThread) {
        this.c = aVar;
        this.a = handler;
        this.b = handlerThread;
    }

    public void run() {
        this.c.a.post(new 1(this));
    }
}
