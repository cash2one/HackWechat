package com.tencent.mm.plugin.appbrand.launching;

import android.os.HandlerThread;
import android.support.v4.e.a;
import android.support.v4.e.h;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class d {
    static final h<AppBrandSysConfig, AppBrandLaunchErrorAction> jxC = h.d(null, null);
    private static final a<String, d> jxv = new a();
    final String appId;
    final int fIs;
    final int iKd;
    final String iNW;
    final AppBrandLaunchReferrer iNZ;
    final boolean jwY;
    final String jxA;
    final int jxB;
    final boolean jxw;
    volatile b jxx;
    volatile h<AppBrandSysConfig, AppBrandLaunchErrorAction> jxy;
    final int jxz;
    volatile boolean started;

    static /* synthetic */ void a(d dVar) {
        x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "preDownload, appId %s, versionType %d", new Object[]{dVar.appId, Integer.valueOf(dVar.iKd)});
        if (dVar.jxx != null) {
            dVar.jxx.ahO();
        }
    }

    static /* synthetic */ void a(d dVar, h hVar) {
        x.v("MicroMsg.AppBrand.AppLaunchPrepareProcess", "[applaunch] onPrepareDone %s %d in mm process", new Object[]{dVar.appId, Integer.valueOf(dVar.iKd)});
        dVar.a(hVar);
        LaunchBroadCast.a(dVar.appId, dVar.iKd, dVar.jxz, ((AppBrandSysConfig) hVar.first) != null);
    }

    static /* synthetic */ void b(d dVar) {
        x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "postDownload, appId %s, versionType %d", new Object[]{dVar.appId, Integer.valueOf(dVar.iKd)});
        if (dVar.jxx != null) {
            b bVar = dVar.jxx;
        }
    }

    static d sY(String str) {
        d dVar;
        synchronized (jxv) {
            dVar = (d) jxv.remove(str);
        }
        return dVar;
    }

    public d(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        this(appBrandInitConfig.appId, appBrandInitConfig.iGA, appBrandStatObject.fIs, appBrandStatObject.scene, appBrandInitConfig.iNW, appBrandInitConfig.iNZ, appBrandInitConfig.irG, -1, true, appBrandInitConfig.Yz());
        if (appBrandInitConfig.Yz()) {
            i.pz(appBrandInitConfig.appId);
        }
    }

    public d(String str, int i, int i2, int i3, String str2, AppBrandLaunchReferrer appBrandLaunchReferrer, String str3, int i4, boolean z, boolean z2) {
        this.appId = str;
        this.iKd = i;
        this.fIs = i2;
        this.jxz = i3;
        this.iNW = str2;
        this.iNZ = appBrandLaunchReferrer;
        this.jxA = str3;
        this.jxB = i4;
        this.jwY = z2;
        this.jxw = z;
    }

    final void a(h<AppBrandSysConfig, AppBrandLaunchErrorAction> hVar) {
        this.jxy = hVar;
        if (this.jxx != null) {
            this.jxx.a((AppBrandSysConfig) hVar.first, (AppBrandLaunchErrorAction) hVar.second);
            sY(this.jxA);
        }
    }

    public final void ahN() {
        if (!this.started) {
            this.started = true;
            x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "[applaunch] startPrepare in mm %s %d", new Object[]{this.appId, Integer.valueOf(this.iKd)});
            if (this.jxw) {
                synchronized (jxv) {
                    jxv.put(this.jxA, this);
                }
                ak aVar = new a(this.jxA);
                long toMillis = TimeUnit.SECONDS.toMillis(300);
                aVar.J(toMillis, toMillis);
            }
            HandlerThread Wf = e.Wf(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[]{this.appId, Integer.valueOf(this.iKd)}));
            Wf.start();
            new af(Wf.getLooper()).post(new 1(this, Wf));
        }
    }
}
