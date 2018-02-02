package com.tencent.liteav.renderer;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class e extends SurfaceView implements Callback {
    private static final j a = new j(null);
    private i b;
    private Renderer c;
    protected boolean d = false;
    protected boolean e = false;
    protected final WeakReference<e> f = new WeakReference(this);
    protected boolean g;
    protected boolean h;
    private boolean i;
    private e j;
    private f k;
    private g l;
    private k m;
    private int n;
    private int o;
    private boolean p;

    private static class d implements g {
        private d() {
        }

        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                TXCLog.e("TXCGLSurfaceViewBase", "eglCreateWindowSurface");
                TXCLog.e("TXCGLSurfaceViewBase", e.toString());
            }
            return eGLSurface;
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    public interface f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    private class m extends b {
        final /* synthetic */ e j;

        public m(e eVar, boolean z) {
            int i;
            this.j = eVar;
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
            super(eVar, 8, 8, 8, 0, i, 0);
        }
    }

    public e(Context context) {
        super(context);
        b();
    }

    protected int c() {
        return 0;
    }

    protected void finalize() {
        try {
            if (this.b != null) {
                this.b.g();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    private void b() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.m = kVar;
    }

    public void setDebugFlags(int i) {
        this.n = i;
    }

    public int getDebugFlags() {
        return this.n;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.p = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.p;
    }

    public void setRenderer(Renderer renderer) {
        f();
        if (this.j == null) {
            this.j = new m(this, true);
        }
        if (this.k == null) {
            this.k = new c(this, null);
        }
        if (this.l == null) {
            this.l = new d();
        }
        this.c = renderer;
        this.b = new i(this.f);
        this.b.start();
    }

    public void setEGLContextFactory(f fVar) {
        f();
        this.k = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        f();
        this.l = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        f();
        this.j = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(this, z));
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser(new b(this, i, i2, i3, i4, i5, i6));
    }

    public void setEGLContextClientVersion(int i) {
        f();
        this.o = i;
    }

    public void setRenderMode(int i) {
        this.b.a(i);
    }

    public int getRenderMode() {
        return this.b.d();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.b.e();
        setRunInBackground(false);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        setRunInBackground(true);
        if (!this.d) {
            this.b.a(new 1(this));
            this.b.f();
        }
    }

    protected void a() {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.b.a(i2, i3);
    }

    public void c(boolean z) {
        this.d = z;
        if (!this.d && this.e && this.b != null) {
            TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when not enable background run");
            this.b.a(new Runnable(this) {
                final /* synthetic */ e a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.a();
                }
            });
            this.b.f();
        }
    }

    protected void setRunInBackground(boolean z) {
        this.e = z;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i && this.c != null) {
            int d;
            if (this.b != null) {
                d = this.b.d();
            } else {
                d = 1;
            }
            this.b = new i(this.f);
            if (d != 1) {
                this.b.a(d);
            }
            this.b.start();
        }
        this.i = false;
    }

    protected void onDetachedFromWindow() {
        if (this.b != null) {
            this.b.g();
        }
        this.i = true;
        super.onDetachedFromWindow();
    }

    private void f() {
        if (this.b != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public int d() {
        return this.b.a();
    }

    public h getEGLHelper() {
        return this.b.b();
    }
}
