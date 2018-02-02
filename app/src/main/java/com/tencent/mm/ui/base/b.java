package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class b {

    public interface a {
        void me(boolean z);
    }

    private static class b implements InvocationHandler {
        public WeakReference<a> xWH;

        private b() {
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            boolean z = false;
            if (this.xWH == null) {
                x.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
            } else {
                a aVar = (a) this.xWH.get();
                if (aVar == null) {
                    x.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
                } else {
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                        z = ((Boolean) objArr[0]).booleanValue();
                    }
                    aVar.me(z);
                }
            }
            return null;
        }
    }

    public static int YD(String str) {
        Class YE = YE(str);
        if (YE != null) {
            return H(YE);
        }
        return 0;
    }

    public static int H(Class<?> cls) {
        do {
            a aVar = (a) cls.getAnnotation(a.class);
            if (aVar != null) {
                return aVar.value();
            }
            cls = cls.getSuperclass();
        } while (cls != null);
        return 0;
    }

    private static Class<?> YE(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ActivityUtil", e, "", new Object[0]);
            x.e("MicroMsg.ActivityUtil", "Class %s not found in dex", str);
            return null;
        }
    }

    public static boolean I(Class<?> cls) {
        return (H(cls) & 1) == 0;
    }

    public static void Z(Activity activity) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityFromTranslucent Fail: %s", th.getMessage());
        }
    }

    public static void fE(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.w.a.a.bqk, com.tencent.mm.w.a.a.bpQ);
        }
    }

    public static void fF(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.w.a.a.bqk, com.tencent.mm.w.a.a.bql);
        }
    }

    public static void B(Context context, Intent intent) {
        if (intent != null && context != null && (context instanceof Activity) && intent.getBooleanExtra("animation_pop_in", false)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.w.a.a.bqk, com.tencent.mm.w.a.a.bpQ);
        }
    }

    public static void fG(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.w.a.a.bpQ, com.tencent.mm.w.a.a.bql);
        }
    }

    public static void fH(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.w.a.a.bpQ, com.tencent.mm.w.a.a.bpQ);
        }
    }
}
