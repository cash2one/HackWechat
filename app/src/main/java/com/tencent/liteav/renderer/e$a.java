package com.tencent.liteav.renderer;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

abstract class e$a implements e$e {
    protected int[] a;
    final /* synthetic */ e b;

    abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

    public e$a(e eVar, int[] iArr) {
        this.b = eVar;
        this.a = a(iArr);
    }

    public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        if (egl10.eglChooseConfig(eGLDisplay, this.a, null, 0, iArr)) {
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i, iArr)) {
                EGLConfig a = a(egl10, eGLDisplay, eGLConfigArr);
                if (a != null) {
                    return a;
                }
                throw new IllegalArgumentException("No config chosen");
            }
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        }
        throw new IllegalArgumentException("eglChooseConfig failed");
    }

    private int[] a(int[] iArr) {
        if (e.h(this.b) != 2) {
            return iArr;
        }
        int length = iArr.length;
        Object obj = new int[(length + 2)];
        System.arraycopy(iArr, 0, obj, 0, length - 1);
        obj[length - 1] = 12352;
        obj[length] = 4;
        obj[length + 1] = 12344;
        return obj;
    }
}
