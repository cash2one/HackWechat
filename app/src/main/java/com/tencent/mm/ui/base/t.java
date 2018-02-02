package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@TargetApi(16)
final class t extends SurfaceTexture {
    public SurfaceTexture mlH = null;

    public t() {
        super(0);
    }

    public final void setOnFrameAvailableListener(OnFrameAvailableListener onFrameAvailableListener) {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setOnFrameAvailableListener");
        this.mlH.setOnFrameAvailableListener(onFrameAvailableListener);
    }

    public final void setDefaultBufferSize(int i, int i2) {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setDefaultBufferSize");
        this.mlH.setDefaultBufferSize(i, i2);
    }

    public final void updateTexImage() {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, updateTexImage");
        this.mlH.updateTexImage();
    }

    public final void detachFromGLContext() {
        boolean z;
        String str;
        String str2;
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, detachFromGLContext");
        try {
            this.mlH.detachFromGLContext();
            z = false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e, "%s", new Object[]{"detect texture problem, RuntimeException detachFromGLContext"});
            z = true;
        }
        if (z) {
            try {
                Method declaredMethod = SurfaceTexture.class.getDeclaredMethod("nativeDetachFromGLContext", new Class[0]);
                declaredMethod.setAccessible(true);
                str = IJ() + " detect texture problem error code = " + ((Integer) declaredMethod.invoke(this.mlH, new Object[0])).intValue() + ", detach = true, and error = " + z;
                b.z(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(r0), Boolean.valueOf(true), Boolean.valueOf(z)});
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e2, "%s", new Object[]{"detect texture problem, IllegalArgumentException"});
                str2 = IJ() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.z(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str2);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z)});
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e22, "%s", new Object[]{"detect texture problem, IllegalAccessException"});
                str2 = IJ() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.z(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str2);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z)});
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e222, "%s", new Object[]{"detect texture problem, InvocationTargetException"});
                str2 = IJ() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.z(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str2);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z)});
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e2222, "%s", new Object[]{"detect texture problem, NoSuchMethodException"});
                str2 = IJ() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.z(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str2);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z)});
            } catch (Throwable e22222) {
                x.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e22222, "%s", new Object[]{"detect texture problem, Exception"});
                str2 = IJ() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.z(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str2);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z)});
            } catch (Throwable th) {
                str = IJ() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.z(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z)});
            }
        }
    }

    private static String IJ() {
        String format;
        StringBuilder stringBuilder = new StringBuilder(256);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = ac.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + e.REV);
        stringBuilderPrinter.println("#accinfo.build=" + e.TIME + ":" + e.HOSTNAME + ":" + f.fdS);
        stringBuilderPrinter.println("#accinfo.env=" + (b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + b.xdY);
        String str = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.e.bnD);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getMemoryClass()), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), com.tencent.mm.compatible.util.e.bnD, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            x.e("MicroMsg.MMSurfaceTextureWrap", "check data size failed :%s", new Object[]{e.getMessage()});
            format = str;
        }
        stringBuilderPrinter.println("#accinfo.data=" + format);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }

    public final void attachToGLContext(int i) {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, attachToGLContext");
        this.mlH.attachToGLContext(i);
    }

    public final void getTransformMatrix(float[] fArr) {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTransformMatrix");
        this.mlH.getTransformMatrix(fArr);
    }

    public final long getTimestamp() {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTimestamp");
        return this.mlH.getTimestamp();
    }

    public final void release() {
        super.release();
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, release");
        this.mlH.release();
    }

    public final boolean equals(Object obj) {
        return this.mlH.equals(obj);
    }

    public final int hashCode() {
        return this.mlH.hashCode();
    }

    public final String toString() {
        return this.mlH.toString();
    }

    @TargetApi(19)
    public final void releaseTexImage() {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, releaseTexImage");
        this.mlH.releaseTexImage();
    }
}
