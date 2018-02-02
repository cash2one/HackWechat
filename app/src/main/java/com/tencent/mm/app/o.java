package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.splash.b;
import com.tencent.mm.splash.e;
import com.tencent.mm.splash.k;
import com.tencent.mm.xlog.app.XLogSetup;

public final class o {
    private static h ffT;
    private static a ffU;
    private static boolean ffV = false;
    private static boolean ffW = false;
    private static com.tencent.mm.splash.k.a ffX;

    public interface a {
        void a(Application application, String str, MMApplicationLike mMApplicationLike);

        void c(com.tencent.mm.splash.k.a aVar);

        void uk();
    }

    public static h ue() {
        return ffT;
    }

    public static void a(h hVar) {
        ffT = hVar;
    }

    public static void uf() {
        e.a(new b() {
            public final void c(Activity activity) {
                if (o.ffT != null && o.ffT.DS()) {
                    SharedPreferences sharedPreferences = activity.getSharedPreferences("system_config_prefs", 4);
                    if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                        sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                        XLogSetup.realSetupXlog();
                    }
                }
            }

            public final void a(Throwable th, String str) {
                x.printErrStackTrace("WxSplash.WeChatSplash", th, str, new Object[0]);
                if (str == null) {
                    str = "";
                }
                e.chy().xmq.add(str + "  " + Log.getStackTraceString(th));
            }

            public final void a(String str, String str2, Object... objArr) {
                x.i(str, str2, objArr);
            }
        });
    }

    public static void a(Application application, String str, final String str2) {
        boolean z;
        com.tencent.mm.blink.a.av(MMApplicationLike.sAppStartTime);
        uf();
        e.a(new k() {
            public final void b(com.tencent.mm.splash.k.a aVar) {
                x.i("WxSplash.WeChatSplash", "do one more thing");
                o.ffX = aVar;
                o.cv(str2);
                o.ug();
            }
        });
        e.E(WeChatSplashActivity.class);
        e.F(WeChatFallbackSplashActivity.class);
        e.chy().mStartTimestamp = System.currentTimeMillis();
        if (!application.getPackageName().equals(str)) {
            e.a("WxSplash.WeChatSplash", "not main process(%s), no hack, do fallback.", str);
            z = true;
        } else if (e.e(application)) {
            z = false;
            e.cht();
        } else {
            e.chy().e(675, 5, 1);
            e.fk(application);
            e.a("WxSplash.WeChatSplash", "hack failed, do fallback logic.", new Object[0]);
            z = true;
        }
        ffV = z;
        com.tencent.mm.blink.a.fh(1);
        if (z) {
            if (com.tencent.mm.splash.a.fe(application)) {
                try {
                    com.tencent.mm.splash.a.fg(application);
                    e.a("WxSplash.WeChatSplash", "block checking dex opt result: %s", Boolean.valueOf(com.tencent.mm.splash.a.fi(application)));
                    if (!com.tencent.mm.splash.a.fi(application)) {
                        e.a("WxSplash.WeChatSplash", "dexopt service return failed or timeout. kill self.", new Object[0]);
                        e.chs();
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("WxSplash.WeChatSplash", e, "", new Object[0]);
                    throw new RuntimeException(e);
                }
            }
            com.tencent.mm.splash.a.ff(application);
        }
        if (com.tencent.mm.f.a.oG || z) {
            cv(str2);
        }
    }

    private static void cv(String str) {
        if (ffU == null) {
            a cw = cw(str);
            cw.a(ffT.gSI, ffT.gOs, ffT.gSK);
            ffU = cw;
        }
    }

    private static void ug() {
        if (ffW && ffX != null) {
            ffU.c(ffX);
        }
    }

    public static void uh() {
        if (ffW) {
            e.a("WxSplash.WeChatSplash", "applicationOnCreate sApplicationOnCreated", new Object[0]);
            return;
        }
        e.a("WxSplash.WeChatSplash", "applicationOnCreate", new Object[0]);
        e.cho();
        ffW = true;
        if (ffV) {
            ffU.uk();
        } else {
            ug();
        }
    }

    private static a cw(String str) {
        try {
            return (a) Class.forName(str).newInstance();
        } catch (Throwable e) {
            x.printErrStackTrace("WxSplash.WeChatSplash", e, "%s has problem!", str);
            throw new RuntimeException(e);
        }
    }
}
