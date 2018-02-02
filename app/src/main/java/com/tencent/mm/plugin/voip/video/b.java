package com.tencent.mm.plugin.voip.video;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

final class b implements EGLConfigChooser {
    private static int EGL_OPENGL_ES2_BIT = 4;
    private static int[] ioY = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, EGL_OPENGL_ES2_BIT, 12344};
    protected int ioZ = 5;
    protected int ipa = 6;
    protected int ipb = 5;
    protected int ipc = 0;
    protected int ipd = 0;
    protected int ipe = 0;
    private int[] ipf = new int[1];

    public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eGLDisplay, ioY, null, 0, iArr);
        int i = iArr[0];
        if (i <= 0) {
            throw new IllegalArgumentException("No configs match configSpec");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        egl10.eglChooseConfig(eGLDisplay, ioY, eGLConfigArr, i, iArr);
        return b(egl10, eGLDisplay, eGLConfigArr);
    }

    private EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
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
