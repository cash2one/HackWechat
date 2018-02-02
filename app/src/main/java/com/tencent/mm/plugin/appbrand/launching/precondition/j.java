package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class j {
    static int jzi = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
    private static Object jzj;
    private static Handler jzk;

    public static void cb(Context context) {
        try {
            Handler be = be(cc(context));
            Field declaredField = be.getClass().getDeclaredField("NEW_INTENT");
            declaredField.setAccessible(true);
            jzi = ((Integer) declaredField.get(be)).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", e, "hack constants in ActivityThread$H", new Object[0]);
        }
    }

    private static Handler be(Object obj) {
        if (jzk != null) {
            return jzk;
        }
        Field declaredField = obj.getClass().getDeclaredField("mH");
        declaredField.setAccessible(true);
        Handler handler = (Handler) declaredField.get(obj);
        jzk = handler;
        return handler;
    }

    private static Object cc(Context context) {
        if (jzj != null) {
            return jzj;
        }
        Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null) {
            jzj = invoke;
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        invoke = field.get(context);
        Field declaredField = invoke.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        invoke = declaredField.get(invoke);
        jzj = invoke;
        return invoke;
    }

    static boolean kR(int i) {
        Handler be;
        try {
            be = be(cc(ac.getContext()));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", e, "hasPendingMessageInQueue, hack mH", new Object[0]);
            be = null;
        }
        if (be == null) {
            return false;
        }
        return be.hasMessages(i);
    }
}
