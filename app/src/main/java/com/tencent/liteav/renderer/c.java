package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class c extends Thread {
    private int a = 12440;
    private int b = 4;
    private WeakReference<b> c;
    private EGL10 d;
    private EGLContext e;
    private EGLDisplay f;
    private EGLSurface g;
    private EGLConfig h;
    private WeakReference<SurfaceTexture> i;
    private boolean j = false;

    c(WeakReference<b> weakReference) {
        this.c = weakReference;
    }

    public void run() {
        setName("VRender" + getId());
        try {
            this.j = true;
            f();
            c();
            while (this.j) {
                if (!(!e() || this.d == null || this.f == null || this.g == null)) {
                    this.d.eglSwapBuffers(this.f, this.g);
                }
            }
            d();
            g();
        } catch (Exception e) {
        }
    }

    public EGLContext a() {
        return this.e;
    }

    public void b() {
        this.j = false;
    }

    private void c() {
        try {
            b bVar = (b) this.c.get();
            if (bVar != null) {
                bVar.c();
            }
        } catch (Exception e) {
        }
    }

    private void d() {
        try {
            b bVar = (b) this.c.get();
            if (bVar != null) {
                bVar.d();
            }
        } catch (Exception e) {
        }
    }

    private boolean e() {
        try {
            Thread.sleep(10);
            if (this.c != null) {
                b bVar = (b) this.c.get();
                if (bVar != null) {
                    return bVar.e();
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private void f() {
        b bVar = (b) this.c.get();
        if (bVar != null) {
            this.d = (EGL10) EGLContext.getEGL();
            this.f = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.d.eglInitialize(this.f, new int[2]);
            this.h = h();
            SurfaceTexture f = bVar.f();
            if (f != null) {
                this.i = new WeakReference(f);
            }
            this.g = this.d.eglCreateWindowSurface(this.f, this.h, f, null);
            this.e = a(this.d, this.f, this.h, EGL10.EGL_NO_CONTEXT);
            TXCLog.w("TXCVideoRenderThread", "vrender: init egl @context=" + this.e + ",surface=" + this.g);
            try {
                if (this.g == null || this.g == EGL10.EGL_NO_SURFACE) {
                    throw new RuntimeException("GL error:" + GLUtils.getEGLErrorString(this.d.eglGetError()));
                } else if (!this.d.eglMakeCurrent(this.f, this.g, this.g, this.e)) {
                    throw new RuntimeException("GL Make current Error" + GLUtils.getEGLErrorString(this.d.eglGetError()));
                }
            } catch (Exception e) {
            }
        }
    }

    private void g() {
        this.d.eglMakeCurrent(this.f, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.d.eglDestroyContext(this.f, this.e);
        this.d.eglDestroySurface(this.f, this.g);
        this.d.eglTerminate(this.f);
        this.i = null;
        TXCLog.w("TXCVideoRenderThread", "vrender: uninit egl @context=" + this.e + ",surface=" + this.g);
    }

    private EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext) {
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{this.a, 2, 12344});
    }

    private EGLConfig h() {
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.d.eglChooseConfig(this.f, i(), eGLConfigArr, 1, iArr)) {
            throw new IllegalArgumentException("Failed to choose config:" + GLUtils.getEGLErrorString(this.d.eglGetError()));
        } else if (iArr[0] > 0) {
            return eGLConfigArr[0];
        } else {
            return null;
        }
    }

    private int[] i() {
        return new int[]{12352, this.b, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    }
}
