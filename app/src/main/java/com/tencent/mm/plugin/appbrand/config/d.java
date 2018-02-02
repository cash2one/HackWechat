package com.tencent.mm.plugin.appbrand.config;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public d iNc;
    public d iNd;
    public boolean mFinished;

    private d() {
        this.mFinished = false;
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Activity activity, b bVar, a aVar) {
        b bQ = bQ(activity);
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s]", bVar, aVar, bQ);
        if (activity == null) {
            x.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", new RuntimeException(), "No Activity found when request device orientation", new Object[0]);
            a(aVar, bQ, false);
        } else if (bVar == null) {
            a(aVar, bQ, false);
        } else if (bVar == bQ) {
            x.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation currentOrientation hit. [%s]", bVar);
            a(aVar, bVar, true);
        } else {
            d dVar = null;
            synchronized (this) {
                if (this.mFinished) {
                    x.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation mFinished = true");
                } else if (this.iNc == null) {
                    this.iNc = new d(this, bVar, aVar, (byte) 0);
                    a(activity, this.iNc);
                } else {
                    if (this.iNd != null) {
                        dVar = this.iNd;
                    }
                    this.iNd = new d(this, bVar, aVar, (byte) 0);
                }
            }
        }
    }

    public static void a(Activity activity, d dVar) {
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", dVar);
        activity.setRequestedOrientation(dVar.iNj.iNg);
    }

    public static b bQ(Context context) {
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return null;
        }
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
        return b(context.getResources().getConfiguration());
    }

    private static void a(a aVar, b bVar, boolean z) {
        if (aVar != null) {
            aVar.a(bVar, z);
        }
    }

    public static b qC(String str) {
        if ("landscape".equals(str)) {
            return b.iNf;
        }
        if ("portrait".equals(str)) {
            return b.iNe;
        }
        return null;
    }

    public static b a(AppBrandInitConfig appBrandInitConfig, a aVar) {
        b bVar = null;
        if (!(aVar == null || aVar.iMC == null)) {
            x.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex]AppBrandAppConfig has deviceOrientation field [%s]", aVar.abL());
            bVar = qC(aVar.abL());
        }
        if (bVar == null) {
            if (!appBrandInitConfig.Yz()) {
                return b.iNe;
            }
            x.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex]AppBrandInitConfig has orientation field [%s]", appBrandInitConfig.iNT);
            bVar = qC(appBrandInitConfig.iNT);
        }
        if (bVar == null) {
            return b.iNe;
        }
        return bVar;
    }

    public static b b(Configuration configuration) {
        if (configuration == null) {
            x.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == null ");
            return null;
        } else if (configuration.orientation == 2) {
            x.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
            return b.iNf;
        } else if (configuration.orientation == 1) {
            x.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
            return b.iNe;
        } else {
            x.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", Integer.valueOf(configuration.orientation));
            return null;
        }
    }
}
