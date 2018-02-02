package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mm.sdk.platformtools.x;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class MMSightCameraGLSurfaceView$b implements EGLContextFactory {
    private int EGL_CONTEXT_CLIENT_VERSION = 12440;
    final /* synthetic */ MMSightCameraGLSurfaceView ipg;

    MMSightCameraGLSurfaceView$b(MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView) {
        this.ipg = mMSightCameraGLSurfaceView;
    }

    public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        x.w("MicroMsg.MMSightCameraGLSurfaceView", "creating OpenGL ES 2.0 context");
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
    }

    public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
    }
}
