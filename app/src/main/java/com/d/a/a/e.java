package com.d.a.a;

import android.os.Handler;

abstract class e {
    private a bgL;
    long bgM;
    final Handler handler;

    abstract void rV();

    e(Handler handler) {
        if (handler == null) {
            handler = new Handler();
        }
        this.handler = handler;
    }

    final void f(long j, long j2) {
        stop();
        this.bgM = j;
        this.bgL = new a(this, (byte) 0);
        a.a(this.bgL, j2);
    }

    final void stop() {
        if (this.bgL != null) {
            a.a(this.bgL);
        }
    }
}
