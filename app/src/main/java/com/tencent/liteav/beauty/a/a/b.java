package com.tencent.liteav.beauty.a.a;

import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLSurface;

public class b {
    protected a a;
    private EGLSurface b = EGL11.EGL_NO_SURFACE;
    private int c = -1;
    private int d = -1;

    protected b(a aVar) {
        this.a = aVar;
    }

    public void a(int i, int i2) {
        if (this.b != EGL11.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.b = this.a.a(i, i2);
        this.c = i;
        this.d = i2;
    }

    public void a() {
        this.a.a(this.b);
        this.b = EGL11.EGL_NO_SURFACE;
        this.d = -1;
        this.c = -1;
    }

    public void b() {
        this.a.b(this.b);
    }
}
