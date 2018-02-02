package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import com.tencent.mm.z.u.b;
import org.json.JSONObject;

public final class JsApiSetBackgroundAudioState extends a {
    public static final int CTRL_INDEX = 160;
    public static final String NAME = "setBackgroundAudioState";
    public static int jfv = 0;
    private SetBackgroundAudioListenerTask jeM;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
            return;
        }
        String str = jVar.mAppId;
        x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", new Object[]{str, jSONObject.toString()});
        if (this.jeM == null) {
            this.jeM = new SetBackgroundAudioListenerTask(this, jVar, i);
        }
        this.jeM.jcN = i;
        this.jeM.appId = str;
        SetBackgroundAudioListenerTask.a(this.jeM);
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        this.jeM.fvM = appBrandSysConfig.iOI.iGK;
        this.jeM.frn = appBrandSysConfig.frn;
        this.jeM.fvL = appBrandSysConfig.fnl;
        x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", new Object[]{Integer.valueOf(this.jeM.fvM), this.jeM.frn, this.jeM.fvL});
        b t = u.GK().t(u.hz("AppBrandService#" + jVar.hashCode()), true);
        synchronized (t) {
            f fVar;
            f fVar2 = (f) t.get("StickyBannerChangeListener", null);
            if (fVar2 == null) {
                1 1 = new 1(this, t, jVar, i);
                t.o("pkgType", Integer.valueOf(appBrandSysConfig.iOI.iGK));
                t.o("StickyBannerChangeListener", 1);
                t.o("appId", jVar.mAppId);
                fVar = 1;
            } else {
                fVar = fVar2;
            }
            if (((c.b) t.get("AppBrandLifeCycle.Listener", null)) == null) {
                c.b 2 = new 2(this, t, jVar, i);
                t.o("AppBrandLifeCycle.Listener", 2);
                this.jeM.jeV = 2;
            }
            this.jeM.jeU = fVar;
            this.jeM.iTl = t;
        }
        AppBrandMainProcessService.a(this.jeM);
        MainProcessTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(this, jVar, i);
        setBackgroundAudioStateTask.jcN = i;
        setBackgroundAudioStateTask.appId = str;
        setBackgroundAudioStateTask.jeR = jSONObject.toString();
        AppBrandMainProcessService.a(setBackgroundAudioStateTask);
    }
}
