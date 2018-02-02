package com.tencent.liteav.beauty.a.a;

import com.tencent.liteav.basic.log.TXCLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class a {
    private EGL10 a;
    private final EGLContext b;
    private EGLDisplay c;
    private EGLConfig d;
    private EGLSurface e;

    public a() {
        this(null);
    }

    public a(EGLConfig eGLConfig) {
        this.a = (EGL10) EGLContext.getEGL();
        this.c = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.c == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL10 display");
        }
        if (this.a.eglInitialize(this.c, new int[2])) {
            if (eGLConfig != null) {
                this.d = eGLConfig;
            } else {
                this.d = b();
            }
            this.b = this.a.eglCreateContext(this.c, this.d, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            return;
        }
        this.c = null;
        throw new RuntimeException("unable to initialize EGL10");
    }

    private EGLConfig b() {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (this.a.eglChooseConfig(this.c, new int[]{12339, 1, 12325, 16, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
            return eGLConfigArr[0];
        }
        TXCLog.w("ImageEglSurface", "unable to find RGB8888  EGLConfig");
        return null;
    }

    public void a() {
        this.a.eglMakeCurrent(this.c, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.a.eglDestroyContext(this.c, this.b);
        this.a.eglTerminate(this.c);
    }

    public void a(EGLSurface eGLSurface) {
        this.a.eglDestroySurface(this.c, eGLSurface);
    }

    public EGLSurface a(int i, int i2) {
        this.e = this.a.eglCreatePbufferSurface(this.c, this.d, new int[]{12375, i, 12374, i2, 12344});
        a("eglCreatePbufferSurface");
        if (this.e != null) {
            return this.e;
        }
        throw new RuntimeException("surface was null");
    }

    public void b(EGLSurface eGLSurface) {
        EGLDisplay eGLDisplay = this.c;
        if (eGLDisplay == EGL11.EGL_NO_DISPLAY) {
            TXCLog.d("EglCore", "NOTE: makeCurrent w/o display");
        }
        if (!this.a.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    private void a(String str) {
        int eglGetError = this.a.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }
}
