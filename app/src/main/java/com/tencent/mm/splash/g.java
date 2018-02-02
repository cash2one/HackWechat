package com.tencent.mm.splash;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mm.blink.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import java.lang.reflect.Field;

final class g implements Callback {
    public static int xlT = 100;
    public static int xlU = 113;
    public static int xlV = 114;
    public static int xlW = 115;
    public static int xlX = 116;
    public static int xlY = 121;
    public static int xlZ = 122;
    public static int xma = 126;
    public static int xmb = c.CTRL_INDEX;
    private static boolean xmc = false;
    private static Runnable xmd;
    private static boolean xmf = false;
    private Context mContext;
    Callback oTm;
    private boolean xme = false;

    public g(Context context, Callback callback) {
        this.mContext = context;
        this.oTm = callback;
    }

    public static void Y(Runnable runnable) {
        xmc = true;
        xmd = runnable;
    }

    public static boolean chE() {
        return xmf;
    }

    public final boolean handleMessage(Message message) {
        if (this.xme) {
            e.a("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
            return true;
        }
        xmf = false;
        e.a("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", Integer.valueOf(message.what), Boolean.valueOf(e.chq()), Boolean.valueOf(e.chr()));
        if (xmc && message.what == 987654321) {
            if (xmd != null) {
                e.a("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
                xmd.run();
            }
            return true;
        }
        if (e.chq() && !e.chr()) {
            e.a("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", Integer.valueOf(message.what), Boolean.valueOf(e.chq()));
            if (message.what == xlU || message.what == xlV || message.what == xlW || message.what == xlX || message.what == xlY || message.what == xlZ || message.what == xmb) {
                Message obtain = Message.obtain();
                obtain.copyFrom(message);
                e.xly.add(obtain);
                a.wj();
                return true;
            }
        }
        if (message.what == xma) {
            xmf = true;
            e.a("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message", new Object[0]);
            Object obj = message.obj;
            if (d.fO(25)) {
                try {
                    if (i.xmp == null) {
                        Field declaredField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
                        declaredField.setAccessible(true);
                        i.xmp = declaredField;
                    }
                    e.a("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", Boolean.valueOf(((Boolean) i.xmp.get(obj)).booleanValue()));
                    i.xmp.set(obj, Boolean.valueOf(false));
                } catch (Throwable e) {
                    e.a(e, "");
                }
            }
        }
        if (this.oTm == null) {
            return false;
        }
        this.xme = true;
        boolean handleMessage = this.oTm.handleMessage(message);
        this.xme = false;
        return handleMessage;
    }
}
