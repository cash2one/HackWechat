package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.b.k;

class b$2 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ byte[] d;
    final /* synthetic */ long e;
    final /* synthetic */ b f;

    b$2(b bVar, int i, int i2, int i3, byte[] bArr, long j) {
        this.f = bVar;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = bArr;
        this.e = j;
    }

    public void run() {
        if (!(b.b(this.f) != null && b.b(this.f).n() == this.a && b.b(this.f).o() == this.b)) {
            if (b.b(this.f) != null) {
                b.b(this.f).d();
                b.a(this.f, null);
            }
            b.a(this.f, new k(this.c));
            if (b.b(this.f).a()) {
                b.b(this.f).a(true);
                b.b(this.f).a(this.a, this.b);
            } else {
                b.a(this.f).c();
                b.a(this.f, null);
                b.a(this.f, null);
                return;
            }
        }
        b.b(this.f).a(this.d);
        GLES20.glViewport(0, 0, this.a, this.b);
        int q = b.b(this.f).q();
        GLES20.glFlush();
        this.f.a(q, b.c(this.f).width, b.c(this.f).height, this.e);
    }
}
