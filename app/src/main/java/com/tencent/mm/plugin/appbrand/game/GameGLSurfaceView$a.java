package com.tencent.mm.plugin.appbrand.game;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

abstract class GameGLSurfaceView$a implements EGLConfigChooser {
    protected int[] iWr;
    final /* synthetic */ GameGLSurfaceView iWs;

    abstract EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

    public GameGLSurfaceView$a(GameGLSurfaceView gameGLSurfaceView, int[] iArr) {
        this.iWs = gameGLSurfaceView;
        if (GameGLSurfaceView.a(this.iWs) == 2 || GameGLSurfaceView.a(this.iWs) == 3) {
            Object obj = new int[15];
            System.arraycopy(iArr, 0, obj, 0, 12);
            obj[12] = 12352;
            if (GameGLSurfaceView.a(this.iWs) == 2) {
                obj[13] = 4;
            } else {
                obj[13] = 64;
            }
            obj[14] = 12344;
            Object obj2 = obj;
        }
        this.iWr = iArr;
    }

    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        if (egl10.eglChooseConfig(eGLDisplay, this.iWr, null, 0, iArr)) {
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (egl10.eglChooseConfig(eGLDisplay, this.iWr, eGLConfigArr, i, iArr)) {
                EGLConfig b = b(egl10, eGLDisplay, eGLConfigArr);
                if (b != null) {
                    return b;
                }
                throw new IllegalArgumentException("No config chosen");
            }
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        }
        throw new IllegalArgumentException("eglChooseConfig failed");
    }
}
