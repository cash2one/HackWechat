package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Process;
import com.tencent.mm.app.g.AnonymousClass1;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.loader.stub.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.lib.a.a;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.util.HashMap;

public class MMApplicationLike extends DefaultApplicationLike {
    private static final String NO_SPACE_FOR_DEX_PROCESS = ":nospace";
    private static final String TAG = "MicroMsg.MMApplication";
    public static MMApplicationLike applicationLike;
    public static String hash = "";
    public static long sAppStartTime;
    public long mGetRevTime;
    public String mNewVersionCode;
    public String mOldVersionCode;
    public long mSetRevTime;
    private ApplicationLifeCycle wrapper;

    public static ApplicationLike getTinkerApplicationLike() {
        return applicationLike;
    }

    public MMApplicationLike(Application application, int i, boolean z, long j, long j2, Intent intent) {
        super(application, i, z, j, j2, intent);
    }

    private void setPatchRev(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike == null || applicationLike.getApplication() == null) {
                throw new TinkerRuntimeException("tinkerApplication is null");
            }
            Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
            HashMap ax = (tinkerResultIntent == null || ShareIntentUtil.ar(tinkerResultIntent) != 0) ? null : ShareIntentUtil.ax(tinkerResultIntent);
            if (ax != null) {
                BaseBuildInfo.PATCH_REV = (String) ax.get("patch.rev");
                x.w(TAG, "application set patch rev:%s", BaseBuildInfo.PATCH_REV);
            }
        }
    }

    public void onBaseContextAttached(Context context) {
        super.onBaseContextAttached(context);
        if (b.b(this) && b.c(this)) {
            a.a((ApplicationLike) this, "armeabi-v7a");
            a.a((ApplicationLike) this, "armeabi");
        }
        com.tencent.mm.blink.a.at(getApplicationStartMillisTime());
        sAppStartTime = getApplicationStartMillisTime();
        applicationLike = this;
        setPatchRev(applicationLike);
        hash += "/" + hashCode();
        ac.lA(false);
        ac.setContext(getApplication());
        String r = d.r(context, Process.myPid());
        x.De(0);
        Application application = getApplication();
        if (!"com.tencent.mm:cuploader".equals(r)) {
            aj.a(new AnonymousClass1(application, r));
            aj.a(new aj.a() {
                public final void tR() {
                    String str = BaseBuildInfo.PATCH_REV;
                }
            });
        }
        r.endsWith(NO_SPACE_FOR_DEX_PROCESS);
        clearOldDirIfNewVersion();
        try {
            this.wrapper = (ApplicationLifeCycle) Class.forName(ac.getPackageName() + ".app.MMApplicationWrapper").getConstructor(new Class[]{MMApplicationLike.class, String.class}).newInstance(new Object[]{this, r});
            this.wrapper.onBaseContextAttached(context);
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "failed to create application wrapper class", new Object[0]);
            throw new RuntimeException("failed to create application wrapper class", e);
        }
    }

    private void clearOldDirIfNewVersion() {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.e.a aVar = new com.tencent.mm.sdk.e.a(com.tencent.mm.loader.stub.a.gZK + "NowRev.ini");
        this.mOldVersionCode = aVar.getValue("NowRev");
        this.mNewVersionCode = BaseBuildInfo.baseRevision();
        long currentTimeMillis2 = System.currentTimeMillis();
        this.mGetRevTime = currentTimeMillis2 - currentTimeMillis;
        this.mSetRevTime = 0;
        if (!this.mNewVersionCode.equals(this.mOldVersionCode)) {
            ac.xft = true;
            com.tencent.mm.loader.stub.b.h(getApplication().getDir("lib", 0));
            com.tencent.mm.loader.stub.b.h(getApplication().getDir("dex", 0));
            com.tencent.mm.loader.stub.b.h(getApplication().getDir("cache", 0));
            com.tencent.mm.loader.stub.b.h(getApplication().getDir("recover_lib", 0));
            b.e(applicationLike);
            aVar.fv("NowRev", this.mNewVersionCode);
            this.mSetRevTime = System.currentTimeMillis() - currentTimeMillis2;
            x.w(TAG, "application hash:%s, %s", hash, new ai().toString());
        }
        x.i(TAG, "clearOldDirIfNewVersion oldversion:%s, newversion:%s, gettime:%d, settime:%d", this.mOldVersionCode, this.mNewVersionCode, Long.valueOf(this.mGetRevTime), Long.valueOf(this.mSetRevTime));
    }

    public void onCreate() {
        if (this.wrapper != null) {
            this.wrapper.onCreate();
        }
    }

    public void onTerminate() {
        super.onTerminate();
        if (this.wrapper != null) {
            this.wrapper.onTerminate();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        x.d(TAG, "configuration changed");
        super.onConfigurationChanged(configuration);
        if (this.wrapper != null) {
            this.wrapper.onConfigurationChanged(configuration);
        }
    }

    public Resources getResources(Resources resources) {
        return ac.getResources() == null ? resources : ac.getResources();
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.wrapper != null) {
            this.wrapper.onLowMemory();
        }
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (this.wrapper != null) {
            this.wrapper.onTrimMemory(i);
        }
    }
}
