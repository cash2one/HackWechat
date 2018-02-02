package com.tencent.liteav.renderer;

import com.tencent.liteav.renderer.e.a;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class e$b extends a {
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    final /* synthetic */ e i;
    private int[] j = new int[1];

    public e$b(e eVar, int i, int i2, int i3, int i4, int i5, int i6) {
        this.i = eVar;
        super(eVar, new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.h = i6;
    }

    public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        for (EGLConfig eGLConfig : eGLConfigArr) {
            int a = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
            int a2 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
            if (a >= this.g && a2 >= this.h) {
                a = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                int a4 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                a2 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                if (a == this.c && a3 == this.d && a4 == this.e && a2 == this.f) {
                    return eGLConfig;
                }
            }
        }
        return null;
    }

    private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.j)) {
            return this.j[0];
        }
        return i2;
    }
}
