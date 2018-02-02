package com.tencent.liteav.basic.b;

import android.os.Looper;

class a$4 implements Runnable {
    final /* synthetic */ a a;

    a$4(a aVar) {
        this.a = aVar;
    }

    public void run() {
        a.a(this.a, false);
        a.l(this.a);
        try {
            Looper.myLooper().quit();
        } catch (Exception e) {
        }
    }
}
