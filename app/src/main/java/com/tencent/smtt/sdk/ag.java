package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import java.lang.reflect.Method;
import java.util.Map;

final class ag {
    DexLoader zZb;

    public ag(DexLoader dexLoader) {
        this.zZb = dexLoader;
    }

    public final int a(Context context, String str, Map<String, String> map, String str2, ValueCallback<String> valueCallback) {
        if (p.gK(context)) {
            return -103;
        }
        Object invokeStaticMethod;
        if (str2 == null) {
            invokeStaticMethod = this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class, ValueCallback.class}, new Object[]{context, str, map, valueCallback});
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class}, new Object[]{context, str, map});
            }
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class}, new Object[]{context, str});
            }
            return invokeStaticMethod == null ? -104 : ((Integer) invokeStaticMethod).intValue();
        } else {
            invokeStaticMethod = this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, String.class}, new Object[]{context, str, str2});
            return invokeStaticMethod == null ? -104 : ((Integer) invokeStaticMethod).intValue();
        }
    }

    public final boolean cFj() {
        Method method = this.zZb.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        return invoke instanceof Boolean ? ((Boolean) invoke).booleanValue() : ((Boolean) invoke).booleanValue();
    }

    public final Object cFk() {
        return this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
    }

    public final IX5WebViewBase hD(Context context) {
        IX5WebViewBase iX5WebViewBase;
        Object invokeStaticMethod = this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[]{Context.class}, new Object[]{context});
        if (invokeStaticMethod == null) {
            try {
                Object invokeStaticMethod2 = this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof Throwable)) {
                    m.cEf().a(context, 325, (Throwable) invokeStaticMethod2);
                }
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof String)) {
                    m.cEf().a(context, 325, new Throwable((String) invokeStaticMethod2));
                }
                iX5WebViewBase = null;
                invokeStaticMethod = null;
            } catch (Exception e) {
                iX5WebViewBase = null;
            }
        } else {
            iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
            if (iX5WebViewBase != null) {
                try {
                    if (iX5WebViewBase.getView() == null) {
                        m.cEf().a(context, 325, new Throwable("x5webview.getView is null!"));
                        invokeStaticMethod = null;
                    }
                } catch (Exception e2) {
                }
            }
        }
        return invokeStaticMethod == null ? null : iX5WebViewBase;
    }
}
