package com.tencent.mm.plugin.appbrand.game;

import android.opengl.GLException;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.IOException;
import java.io.Writer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class GameGLSurfaceView$e implements EGL11 {
    private EGL10 iWt;
    Writer iWu;
    boolean iWv;
    boolean iWw;
    private int iWx;

    public final boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        qk("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        av("config_size", i);
        end();
        boolean eglChooseConfig = this.iWt.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        c("configs", eGLConfigArr);
        a("num_config", iArr2);
        cx(eglChooseConfig);
        checkError();
        return eglChooseConfig;
    }

    public final boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        qk("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        r("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.iWt.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        cx(eglCopyBuffers);
        checkError();
        return eglCopyBuffers;
    }

    public final EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        qk("eglCreateContext");
        a("display", eGLDisplay);
        r("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.iWt.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        ba(eglCreateContext);
        checkError();
        return eglCreateContext;
    }

    public final EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        qk("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        r("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.iWt.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        ba(eglCreatePbufferSurface);
        checkError();
        return eglCreatePbufferSurface;
    }

    public final EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        qk("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        r("config", eGLConfig);
        r("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.iWt.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        ba(eglCreatePixmapSurface);
        checkError();
        return eglCreatePixmapSurface;
    }

    public final EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        qk("eglCreateWindowSurface");
        a("display", eGLDisplay);
        r("config", eGLConfig);
        r("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.iWt.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        ba(eglCreateWindowSurface);
        checkError();
        return eglCreateWindowSurface;
    }

    public final boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        qk("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.iWt.eglDestroyContext(eGLDisplay, eGLContext);
        cx(eglDestroyContext);
        checkError();
        return eglDestroyContext;
    }

    public final boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        qk("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.iWt.eglDestroySurface(eGLDisplay, eGLSurface);
        cx(eglDestroySurface);
        checkError();
        return eglDestroySurface;
    }

    public final boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        qk("eglGetConfigAttrib");
        a("display", eGLDisplay);
        r("config", eGLConfig);
        av("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.iWt.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a(DownloadSettingTable$Columns.VALUE, iArr);
        cx(eglGetConfigAttrib);
        checkError();
        return false;
    }

    public final boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        qk("eglGetConfigs");
        a("display", eGLDisplay);
        av("config_size", i);
        end();
        boolean eglGetConfigs = this.iWt.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        c("configs", eGLConfigArr);
        a("num_config", iArr);
        cx(eglGetConfigs);
        checkError();
        return eglGetConfigs;
    }

    public final EGLContext eglGetCurrentContext() {
        qk("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.iWt.eglGetCurrentContext();
        ba(eglGetCurrentContext);
        checkError();
        return eglGetCurrentContext;
    }

    public final EGLDisplay eglGetCurrentDisplay() {
        qk("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.iWt.eglGetCurrentDisplay();
        ba(eglGetCurrentDisplay);
        checkError();
        return eglGetCurrentDisplay;
    }

    public final EGLSurface eglGetCurrentSurface(int i) {
        qk("eglGetCurrentSurface");
        av("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.iWt.eglGetCurrentSurface(i);
        ba(eglGetCurrentSurface);
        checkError();
        return eglGetCurrentSurface;
    }

    public final EGLDisplay eglGetDisplay(Object obj) {
        qk("eglGetDisplay");
        r("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.iWt.eglGetDisplay(obj);
        ba(eglGetDisplay);
        checkError();
        return eglGetDisplay;
    }

    public final int eglGetError() {
        qk("eglGetError");
        end();
        int eglGetError = this.iWt.eglGetError();
        rF(kd(eglGetError));
        return eglGetError;
    }

    public final boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        qk("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.iWt.eglInitialize(eGLDisplay, iArr);
        cx(eglInitialize);
        a("major_minor", iArr);
        checkError();
        return eglInitialize;
    }

    public final boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        qk("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.iWt.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        cx(eglMakeCurrent);
        checkError();
        return eglMakeCurrent;
    }

    public final boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        qk("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        av("attribute", i);
        end();
        boolean eglQueryContext = this.iWt.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        kc(iArr[0]);
        cx(eglQueryContext);
        checkError();
        return eglQueryContext;
    }

    public final String eglQueryString(EGLDisplay eGLDisplay, int i) {
        qk("eglQueryString");
        a("display", eGLDisplay);
        av("name", i);
        end();
        String eglQueryString = this.iWt.eglQueryString(eGLDisplay, i);
        rF(eglQueryString);
        checkError();
        return eglQueryString;
    }

    public final boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        qk("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        av("attribute", i);
        end();
        boolean eglQuerySurface = this.iWt.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        kc(iArr[0]);
        cx(eglQuerySurface);
        checkError();
        return eglQuerySurface;
    }

    public final boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        qk("eglSwapBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.iWt.eglSwapBuffers(eGLDisplay, eGLSurface);
        cx(eglSwapBuffers);
        checkError();
        return eglSwapBuffers;
    }

    public final boolean eglTerminate(EGLDisplay eGLDisplay) {
        qk("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.iWt.eglTerminate(eGLDisplay);
        cx(eglTerminate);
        checkError();
        return eglTerminate;
    }

    public final boolean eglWaitGL() {
        qk("eglWaitGL");
        end();
        boolean eglWaitGL = this.iWt.eglWaitGL();
        cx(eglWaitGL);
        checkError();
        return eglWaitGL;
    }

    public final boolean eglWaitNative(int i, Object obj) {
        qk("eglWaitNative");
        av("engine", i);
        r("bindTarget", obj);
        end();
        boolean eglWaitNative = this.iWt.eglWaitNative(i, obj);
        cx(eglWaitNative);
        checkError();
        return eglWaitNative;
    }

    private void checkError() {
        int eglGetError = this.iWt.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + kd(eglGetError);
            rE(str + '\n');
            if (this.iWw) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void rE(String str) {
        try {
            this.iWu.write(str);
        } catch (IOException e) {
        }
    }

    private void qk(String str) {
        rE(str + '(');
        this.iWx = 0;
    }

    private void bd(String str, String str2) {
        int i = this.iWx;
        this.iWx = i + 1;
        if (i > 0) {
            rE(", ");
        }
        if (this.iWv) {
            rE(str + "=");
        }
        rE(str2);
    }

    private void end() {
        rE(");\n");
        flush();
    }

    private void flush() {
        try {
            this.iWu.flush();
        } catch (IOException e) {
            this.iWu = null;
        }
    }

    private void av(String str, int i) {
        bd(str, Integer.toString(i));
    }

    private void r(String str, Object obj) {
        bd(str, toString(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            bd(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            bd(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            bd(str, toString(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            bd(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            bd(str, toString(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            bd(str, "EGL10.EGL_NO_SURFACE");
        } else {
            bd(str, toString(eGLSurface));
        }
    }

    private void rF(String str) {
        rE(" returns " + str + ";\n");
        flush();
    }

    private void kc(int i) {
        rF(Integer.toString(i));
    }

    private void cx(boolean z) {
        rF(Boolean.toString(z));
    }

    private void ba(Object obj) {
        rF(toString(obj));
    }

    private static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            bd(str, "null");
            return;
        }
        int length = iArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        int length2 = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i + 0;
            stringBuilder.append(" [" + i2 + "] = ");
            if (i2 < 0 || i2 >= length2) {
                stringBuilder.append("out of bounds");
            } else {
                stringBuilder.append(iArr[i2]);
            }
            stringBuilder.append('\n');
        }
        stringBuilder.append("}");
        bd(str, stringBuilder.toString());
    }

    private void c(String str, Object[] objArr) {
        if (objArr == null) {
            bd(str, "null");
            return;
        }
        int length = objArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        int length2 = objArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i + 0;
            stringBuilder.append(" [" + i2 + "] = ");
            if (i2 < 0 || i2 >= length2) {
                stringBuilder.append("out of bounds");
            } else {
                stringBuilder.append(objArr[i2]);
            }
            stringBuilder.append('\n');
        }
        stringBuilder.append("}");
        bd(str, stringBuilder.toString());
    }

    public static String kd(int i) {
        switch (i) {
            case 12288:
                return "EGL_SUCCESS";
            case 12289:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE";
            case 12296:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return "0x" + Integer.toHexString(i);
        }
    }
}
