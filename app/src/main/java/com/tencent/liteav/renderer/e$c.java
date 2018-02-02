package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.renderer.e.f;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class e$c implements f {
    final /* synthetic */ e a;
    private int b;

    private e$c(e eVar) {
        this.a = eVar;
        this.b = 12440;
    }

    public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int[] iArr = new int[]{this.b, e.h(this.a), 12344};
        EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
        if (e.h(this.a) == 0) {
            iArr = null;
        }
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
    }

    public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
            TXCLog.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            e$h.a("eglDestroyContex", egl10.eglGetError());
        }
    }
}
