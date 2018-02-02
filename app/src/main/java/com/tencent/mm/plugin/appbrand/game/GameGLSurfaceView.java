package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.EGLWindowSurfaceFactory;
import android.opengl.GLSurfaceView.GLWrapper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.mm.plugin.appbrand.game.e.b;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class GameGLSurfaceView extends SurfaceView implements Callback2 {
    private static final h iWe = new h((byte) 0);
    final WeakReference<GameGLSurfaceView> iWf = new WeakReference(this);
    public g iWg;
    j iWh;
    EGLConfigChooser iWi;
    EGLContextFactory iWj;
    EGLWindowSurfaceFactory iWk;
    private GLWrapper iWl;
    boolean iWm = false;
    private int iWn;
    int iWo;
    boolean iWp;
    public final b iWq = new b();
    private boolean mDetached;

    private static class d implements EGLWindowSurfaceFactory {
        private d() {
        }

        public final EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                com.tencent.magicbrush.a.c.f.e("GameGLSurfaceView", "eglCreateWindowSurface", new Object[]{e});
            }
            return eGLSurface;
        }

        public final void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    private static class f {
        WeakReference<GameGLSurfaceView> iWy;
        EGLConfig iWz;
        EGL10 ipk;
        EGLDisplay ipl;
        EGLContext ipm;
        EGLSurface ipn;

        public f(WeakReference<GameGLSurfaceView> weakReference) {
            this.iWy = weakReference;
        }

        final void adw() {
            if (this.ipn != null && this.ipn != EGL10.EGL_NO_SURFACE) {
                this.ipk.eglMakeCurrent(this.ipl, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GameGLSurfaceView gameGLSurfaceView = (GameGLSurfaceView) this.iWy.get();
                if (gameGLSurfaceView != null) {
                    gameGLSurfaceView.iWk.destroySurface(this.ipk, this.ipl, this.ipn);
                }
                this.ipn = null;
            }
        }

        public static void aw(String str, int i) {
            String ax = ax(str, i);
            com.tencent.magicbrush.a.c.f.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + ax, new Object[0]);
            throw new RuntimeException(ax);
        }

        public static void k(String str, String str2, int i) {
            com.tencent.magicbrush.a.c.f.w(str, ax(str2, i), new Object[0]);
        }

        private static String ax(String str, int i) {
            return str + " failed: " + e.kd(i);
        }
    }

    public GameGLSurfaceView(Context context) {
        super(context);
        init();
    }

    public GameGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected void finalize() {
        try {
            if (this.iWg != null) {
                this.iWg.adD();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    private void init() {
        h.iXm.iXo = this;
        getHolder().addCallback(this);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        g gVar = this.iWg;
        synchronized (iWe) {
            com.tencent.magicbrush.a.c.f.i("GLThread", "surfaceCreated tid=" + gVar.getId(), new Object[0]);
            gVar.iWG = true;
            gVar.iWL = false;
            gVar.iWE = true;
            iWe.notifyAll();
            while (gVar.iWI && !gVar.iWL && !gVar.iWB) {
                try {
                    iWe.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        g gVar = this.iWg;
        synchronized (iWe) {
            com.tencent.magicbrush.a.c.f.i("GLThread", "surfaceDestroyed tid=" + gVar.getId(), new Object[0]);
            gVar.iWG = false;
            gVar.iWE = true;
            iWe.notifyAll();
            while (!gVar.iWI && !gVar.iWB) {
                try {
                    iWe.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Thread thread = this.iWg;
        synchronized (iWe) {
            if (thread.mWidth != i2 || thread.mHeight != i3) {
                thread.mWidth = i2;
                thread.mHeight = i3;
                thread.iWR = true;
                thread.iWN = true;
                thread.iWP = false;
                thread.iWE = true;
                if (Thread.currentThread() != thread) {
                    iWe.notifyAll();
                    while (!thread.iWB && !thread.iqR && !thread.iWP) {
                        Object obj = (thread.iWJ && thread.iWK && thread.adB()) ? 1 : null;
                        if (obj == null) {
                            break;
                        }
                        com.tencent.magicbrush.a.c.f.i("Main thread", "onWindowResize waiting for render complete from tid=" + thread.getId(), new Object[0]);
                        try {
                            iWe.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.iWg != null) {
            g gVar = this.iWg;
            synchronized (iWe) {
                gVar.iWN = true;
                iWe.notifyAll();
            }
        }
    }

    public final void queueEvent(Runnable runnable) {
        g gVar = this.iWg;
        if (runnable == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        synchronized (iWe) {
            gVar.iWQ.add(runnable);
            iWe.notifyAll();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.tencent.magicbrush.a.c.f.d("GameGLSurfaceView", "onAttachedToWindow reattach =" + this.mDetached, new Object[0]);
        if (this.mDetached && this.iWh != null) {
            int renderMode;
            if (this.iWg != null) {
                renderMode = this.iWg.getRenderMode();
            } else {
                renderMode = 1;
            }
            this.iWg = new g(this.iWf);
            if (renderMode != 1) {
                g gVar = this.iWg;
                if (renderMode < 0 || renderMode > 1) {
                    throw new IllegalArgumentException("renderMode");
                }
                synchronized (iWe) {
                    gVar.mRenderMode = renderMode;
                    iWe.notifyAll();
                }
            }
            this.iWg.start();
        }
        this.mDetached = false;
    }

    protected void onDetachedFromWindow() {
        com.tencent.magicbrush.a.c.f.d("GameGLSurfaceView", "onDetachedFromWindow", new Object[0]);
        if (this.iWg != null) {
            this.iWg.adD();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    final void adu() {
        if (this.iWg != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }
}
