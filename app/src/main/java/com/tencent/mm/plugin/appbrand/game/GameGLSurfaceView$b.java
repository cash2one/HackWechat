package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.a;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class GameGLSurfaceView$b extends a {
    final /* synthetic */ GameGLSurfaceView iWs;
    protected int ioZ = 8;
    protected int ipa = 8;
    protected int ipb = 8;
    protected int ipc = 8;
    protected int ipd = 16;
    protected int ipe = 8;
    private int[] ipf = new int[1];

    public GameGLSurfaceView$b(GameGLSurfaceView gameGLSurfaceView, int i, int i2, int i3, int i4, int i5, int i6) {
        this.iWs = gameGLSurfaceView;
        super(gameGLSurfaceView, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 8, 12344});
    }

    public final EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        for (EGLConfig eGLConfig : eGLConfigArr) {
            int a = a(egl10, eGLDisplay, eGLConfig, 12325);
            int a2 = a(egl10, eGLDisplay, eGLConfig, 12326);
            if (a >= this.ipd && a2 >= this.ipe) {
                a = a(egl10, eGLDisplay, eGLConfig, 12324);
                a2 = a(egl10, eGLDisplay, eGLConfig, 12323);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12322);
                int a4 = a(egl10, eGLDisplay, eGLConfig, 12321);
                if (a == this.ioZ && a2 == this.ipa && a3 == this.ipb && a4 == this.ipc) {
                    return eGLConfig;
                }
            }
        }
        return null;
    }

    private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.ipf)) {
            return this.ipf[0];
        }
        return 0;
    }
}
