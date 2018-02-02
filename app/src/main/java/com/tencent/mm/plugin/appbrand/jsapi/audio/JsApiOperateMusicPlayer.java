package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.z.u;
import com.tencent.mm.z.u.b;
import org.json.JSONObject;

public final class JsApiOperateMusicPlayer extends a {
    public static final int CTRL_INDEX = 47;
    public static final String NAME = "operateMusicPlayer";
    OperateMusicPlayer jeS;

    private static final class c extends f {
        private static final int CTRL_INDEX = 80;
        private static final String NAME = "onMusicPlay";

        private c() {
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        this.jeS = new OperateMusicPlayer(this, jVar, i);
        b t = u.GK().t(u.hz("AppBrandService#" + jVar.hashCode()), true);
        synchronized (t) {
            com.tencent.mm.plugin.appbrand.ui.banner.f fVar;
            com.tencent.mm.plugin.appbrand.ui.banner.f fVar2 = (com.tencent.mm.plugin.appbrand.ui.banner.f) t.get("StickyBannerChangeListener", null);
            if (fVar2 == null) {
                1 1 = new 1(this, t, jVar);
                AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
                if (appBrandSysConfig != null) {
                    t.o("pkgType", Integer.valueOf(appBrandSysConfig.iOI.iGK));
                }
                t.o("StickyBannerChangeListener", 1);
                t.o("appId", jVar.mAppId);
                fVar = 1;
            } else {
                fVar = fVar2;
            }
            if (((com.tencent.mm.plugin.appbrand.c.b) t.get("AppBrandLifeCycle.Listener", null)) == null) {
                com.tencent.mm.plugin.appbrand.c.b 2 = new 2(this, t, jVar);
                t.o("AppBrandLifeCycle.Listener", 2);
                this.jeS.jeV = 2;
            }
            this.jeS.jeU = fVar;
            this.jeS.iTl = t;
        }
        this.jeS.fBZ = jSONObject.toString();
        this.jeS.fFm = jVar.mAppId;
        AppBrandMainProcessService.a(this.jeS);
    }
}
