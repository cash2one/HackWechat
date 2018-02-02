package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import com.tencent.mm.booter.c;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.b.h.AnonymousClass3;
import com.tencent.mm.kernel.b.h.AnonymousClass5;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;

public class MMApplicationWrapper implements ApplicationLifeCycle {
    private static final String TAG = "MicroMsg.MMApplicationWrapper";
    public Application app;
    private final MMApplicationLike lifeCycle;
    private h profile = null;
    private String thisProcess = "";

    public MMApplicationWrapper(MMApplicationLike mMApplicationLike, String str) {
        this.app = mMApplicationLike.getApplication();
        this.lifeCycle = mMApplicationLike;
        this.thisProcess = str;
    }

    public void onBaseContextAttached(Context context) {
        a.gRi = SystemClock.elapsedRealtime();
        this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
        l.tY();
        k.b("stlport_shared", context.getClassLoader());
        k.b(com.tencent.mm.sdk.a.xdV, context.getClassLoader());
        this.profile.gyS = c.aA(this.profile.gSI);
        setupXLogDebugger(this.profile);
        com.tencent.mm.splash.a.d(this.app);
        if (l.ct(this.thisProcess)) {
            x.i(TAG, "is plain process. load nothing");
            o.a(this.profile);
            o.uf();
        } else {
            o.a(this.profile);
            o.a(this.app, this.thisProcess, "com.tencent.mm.app.WeChatSplashStartup");
        }
        m.d(com.tencent.mm.boot.a.a.class);
        m.cu("com.tencent.mm.boot");
    }

    private void setupXLogDebugger(h hVar) {
        c cVar = hVar.gyS;
        if (hVar.DS()) {
            cVar.ee("MM");
        } else if (hVar.fR(":push")) {
            cVar.ee("PUSH");
        } else if (hVar.fR(":tools")) {
            cVar.ee("TOOL");
        } else if (hVar.fR(":sandbox")) {
            cVar.ee("SANDBOX");
        } else if (hVar.fR(":exdevice")) {
            cVar.ee("EXDEVICE");
        } else if (hVar.fR(":patch")) {
            cVar.ee("PATCH");
        } else if (hVar.fR(":appbrand")) {
            cVar.ee("APPBRAND");
        } else if (hVar.fR(":TMAssistantDownloadSDKService")) {
            cVar.ee("TMSDK");
        } else if (hVar.fR(":dexopt")) {
            cVar.ee("DEXOPT");
        }
    }

    public void onCreate() {
        o.uh();
    }

    public void onTerminate() {
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.gSL.a(new com.tencent.mm.cd.a.a<ApplicationLifeCycle>(hVar) {
                final /* synthetic */ h gSM;

                {
                    this.gSM = r1;
                }

                public final /* synthetic */ void az(Object obj) {
                    ((ApplicationLifeCycle) obj).onTerminate();
                }
            });
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.gSL.a(new AnonymousClass5(hVar, configuration));
        }
    }

    public void onLowMemory() {
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.gSL.a(new com.tencent.mm.cd.a.a<ApplicationLifeCycle>(hVar) {
                final /* synthetic */ h gSM;

                {
                    this.gSM = r1;
                }

                public final /* synthetic */ void az(Object obj) {
                    ((ApplicationLifeCycle) obj).onLowMemory();
                }
            });
        }
    }

    public void onTrimMemory(int i) {
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.gSL.a(new AnonymousClass3(hVar, i));
        }
    }
}
