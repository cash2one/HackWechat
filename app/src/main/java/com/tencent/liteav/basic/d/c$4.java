package com.tencent.liteav.basic.d;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

class c$4 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ float[] b;
    final /* synthetic */ c c;

    c$4(c cVar, int i, float[] fArr) {
        this.c = cVar;
        this.a = i;
        this.b = fArr;
    }

    public void run() {
        GLES20.glUniform4fv(this.a, 1, FloatBuffer.wrap(this.b));
    }
}
