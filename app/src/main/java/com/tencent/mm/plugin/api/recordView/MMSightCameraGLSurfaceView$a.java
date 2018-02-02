package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import com.tencent.mm.sdk.platformtools.x;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class MMSightCameraGLSurfaceView$a implements EGLConfigChooser {
    private int EGL_OPENGL_ES2_BIT = 4;
    private int[] ioY = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344};
    protected int ioZ = 5;
    protected int ipa = 6;
    protected int ipb = 5;
    protected int ipc = 0;
    protected int ipd = 0;
    protected int ipe = 0;
    private int[] ipf = new int[1];
    final /* synthetic */ MMSightCameraGLSurfaceView ipg;

    public MMSightCameraGLSurfaceView$a(MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView) {
        this.ipg = mMSightCameraGLSurfaceView;
    }

    public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eGLDisplay, this.ioY, null, 0, iArr);
        int i = iArr[0];
        if (i <= 0) {
            throw new IllegalArgumentException("No configs match configSpec");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        egl10.eglChooseConfig(eGLDisplay, this.ioY, eGLConfigArr, i, iArr);
        c(egl10, eGLDisplay, eGLConfigArr);
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

    private static void c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        x.i("GLConfigChooser", String.format("%d configurations", new Object[]{Integer.valueOf(eGLConfigArr.length)}));
        for (EGLConfig eGLConfig : eGLConfigArr) {
            x.i("GLConfigChooser", String.format("Configuration %d:\n", new Object[]{Integer.valueOf(r2)}));
            int[] iArr = new int[]{12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
            String[] strArr = new String[]{"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
            int[] iArr2 = new int[1];
            for (int i = 0; i < 33; i++) {
                egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, iArr[i], iArr2);
            }
        }
    }
}
