package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

public final class ah {
    private static int zZL = a.zZO;
    private static int zZM = a.zZO;
    private static int zZN = a.zZO;
    private final Context mContext;
    public Object wD = null;
    public WebView zVo = null;

    @Deprecated
    public ah(Context context) {
        this.mContext = context;
        if (hF(context)) {
            Object a = a("createX5JavaBridge", new Class[]{Context.class}, context);
            if (a != null) {
                this.wD = a;
                return;
            }
        }
        this.zVo = new WebView(context);
        this.zVo.getSettings().setJavaScriptEnabled(true);
    }

    protected static IX5JsVirtualMachine a(Context context, Looper looper) {
        if (hF(context)) {
            Object a = a("createX5JsVirtualMachine", new Class[]{Context.class, Looper.class}, context, null);
            if (a != null) {
                return (IX5JsVirtualMachine) a;
            }
        }
        return null;
    }

    public static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            af cFg = af.cFg();
            if (cFg != null && cFg.cFh()) {
                return cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", str, clsArr, objArr);
            }
            new StringBuilder("X5Jscore#").append(str).append(" - x5CoreEngine is null or is not x5core.");
            return null;
        } catch (Exception e) {
        }
    }

    protected static Object cFl() {
        return a("currentContextData", new Class[0], new Object[0]);
    }

    public static boolean hE(Context context) {
        if (zZN != a.zZO) {
            return zZN == a.zZQ;
        } else {
            zZN = a.zZP;
            Object a = a("canUseX5JsCoreNewAPI", new Class[]{Context.class}, context);
            if (a == null || !(a instanceof Boolean) || !((Boolean) a).booleanValue()) {
                return false;
            }
            zZN = a.zZQ;
            return true;
        }
    }

    public static boolean hF(Context context) {
        if (zZL != a.zZO) {
            return zZL == a.zZQ;
        } else {
            zZL = a.zZP;
            Object a = a("canUseX5JsCore", new Class[]{Context.class}, context);
            if (a == null || !(a instanceof Boolean) || !((Boolean) a).booleanValue()) {
                return false;
            }
            a("setJsValueFactory", new Class[]{Object.class}, e.cDQ());
            zZL = a.zZQ;
            return true;
        }
    }

    public static boolean hG(Context context) {
        if (zZM != a.zZO) {
            return zZM == a.zZQ;
        } else {
            zZM = a.zZP;
            if (!hF(context)) {
                return false;
            }
            Object a = a("canX5JsCoreUseBuffer", new Class[]{Context.class}, context);
            if (a == null || !(a instanceof Boolean) || !((Boolean) a).booleanValue()) {
                return false;
            }
            zZM = a.zZQ;
            return true;
        }
    }

    @Deprecated
    public final ByteBuffer ef(int i) {
        if (this.wD != null && hG(this.mContext)) {
            Object a = a("getNativeBuffer", new Class[]{Object.class, Integer.TYPE}, this.wD, Integer.valueOf(i));
            if (a != null && (a instanceof ByteBuffer)) {
                return (ByteBuffer) a;
            }
        }
        return null;
    }

    @Deprecated
    public final void evaluateJavascript(String str, ab<String> abVar) {
        if (this.wD != null) {
            a("evaluateJavascript", new Class[]{String.class, ValueCallback.class, Object.class}, str, abVar, this.wD);
        } else if (this.zVo != null) {
            this.zVo.evaluateJavascript(str, abVar);
        }
    }

    @Deprecated
    public final int getNativeBufferId() {
        if (this.wD != null && hG(this.mContext)) {
            Object a = a("getNativeBufferId", new Class[]{Object.class}, this.wD);
            if (a != null && (a instanceof Integer)) {
                return ((Integer) a).intValue();
            }
        }
        return -1;
    }

    @Deprecated
    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        if (this.wD != null && hG(this.mContext)) {
            a("setNativeBuffer", new Class[]{Object.class, Integer.TYPE, ByteBuffer.class}, this.wD, Integer.valueOf(i), byteBuffer);
        }
    }
}
