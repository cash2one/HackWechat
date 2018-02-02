package com.tencent.liteav.basic.d;

import android.opengl.GLES20;

class c$1 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ float b;
    final /* synthetic */ c c;

    c$1(c cVar, int i, float f) {
        this.c = cVar;
        this.a = i;
        this.b = f;
    }

    public void run() {
        GLES20.glUniform1f(this.a, this.b);
    }
}
