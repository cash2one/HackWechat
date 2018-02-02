package com.tencent.liteav;

import javax.microedition.khronos.egl.EGLContext;

class c$8 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ EGLContext c;
    final /* synthetic */ c d;

    c$8(c cVar, int i, int i2, EGLContext eGLContext) {
        this.d = cVar;
        this.a = i;
        this.b = i2;
        this.c = eGLContext;
    }

    public void run() {
        if (!this.d.a.b() || c.d(this.d).width != this.a || c.d(this.d).height != this.b) {
            this.d.a.a(this.c, c.e(this.d), c.a(this.d).t, this.a, this.b);
        }
    }
}
