package com.tencent.mm.plugin.appbrand.game;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.magicbrush.a.c.f;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class GameGLSurfaceView$c implements EGLContextFactory {
    private int EGL_CONTEXT_CLIENT_VERSION;
    final /* synthetic */ GameGLSurfaceView iWs;

    private GameGLSurfaceView$c(GameGLSurfaceView gameGLSurfaceView) {
        this.iWs = gameGLSurfaceView;
        this.EGL_CONTEXT_CLIENT_VERSION = 12440;
    }

    public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int[] iArr = new int[]{this.EGL_CONTEXT_CLIENT_VERSION, GameGLSurfaceView.a(this.iWs), 12344};
        EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
        if (GameGLSurfaceView.a(this.iWs) == 0) {
            iArr = null;
        }
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
    }

    public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
            f.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext, new Object[0]);
            f.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId(), new Object[0]);
            GameGLSurfaceView.f.aw("eglDestroyContex", egl10.eglGetError());
        }
    }
}
