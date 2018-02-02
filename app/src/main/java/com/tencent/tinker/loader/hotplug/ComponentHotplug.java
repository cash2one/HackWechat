package com.tencent.tinker.loader.hotplug;

import android.content.Context;
import android.os.Handler;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.handler.AMSInterceptHandler;
import com.tencent.tinker.loader.hotplug.handler.MHMessageHandler;
import com.tencent.tinker.loader.hotplug.handler.PMSInterceptHandler;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;

public final class ComponentHotplug {
    private static volatile boolean Aiy = false;
    private static ServiceBinderInterceptor AjY;
    private static ServiceBinderInterceptor AjZ;
    private static HandlerMessageInterceptor Aka;

    public static synchronized void a(TinkerApplication tinkerApplication, ShareSecurityCheck shareSecurityCheck) {
        synchronized (ComponentHotplug.class) {
            if (!Aiy) {
                try {
                    if (IncrementComponentManager.a((Context) tinkerApplication, shareSecurityCheck)) {
                        AjY = new ServiceBinderInterceptor(tinkerApplication, "activity", new AMSInterceptHandler(tinkerApplication));
                        AjZ = new ServiceBinderInterceptor(tinkerApplication, "package", new PMSInterceptHandler());
                        Aka = new HandlerMessageInterceptor(ix(tinkerApplication), new MHMessageHandler(tinkerApplication));
                        AjY.cHe();
                        AjZ.cHe();
                        Aka.cHe();
                        Aiy = true;
                    }
                } catch (Throwable th) {
                    cHc();
                    UnsupportedEnvironmentException unsupportedEnvironmentException = new UnsupportedEnvironmentException(th);
                }
            }
        }
    }

    public static synchronized void cHb() {
        synchronized (ComponentHotplug.class) {
            if (Aiy) {
                try {
                    AjY.cHe();
                    AjZ.cHe();
                    Aka.cHe();
                } catch (Throwable th) {
                    cHc();
                    UnsupportedEnvironmentException unsupportedEnvironmentException = new UnsupportedEnvironmentException(th);
                }
            }
        }
    }

    private static Handler ix(Context context) {
        Object c = ShareReflectUtil.c(context, null);
        if (c == null) {
            throw new IllegalStateException("failed to fetch instance of ActivityThread.");
        }
        try {
            return (Handler) ShareReflectUtil.a(c, "mH").get(c);
        } catch (Throwable th) {
            IllegalStateException illegalStateException = new IllegalStateException(th);
        }
    }

    private static synchronized void cHc() {
        synchronized (ComponentHotplug.class) {
            if (Aiy) {
                try {
                    AjY.cHc();
                    AjZ.cHc();
                    Aka.cHc();
                } catch (Throwable th) {
                }
                Aiy = false;
            }
        }
    }

    private ComponentHotplug() {
        throw new UnsupportedOperationException();
    }
}
