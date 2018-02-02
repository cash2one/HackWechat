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

public final class JsApiOperateBackgroundAudio extends a {
    public static final int CTRL_INDEX = 161;
    public static final String NAME = "operateBackgroundAudio";
    private JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask jeM;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
            return;
        }
        String str = jVar.mAppId;
        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", new Object[]{str});
        if (this.jeM == null) {
            this.jeM = new JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask(this, jVar, i);
        }
        this.jeM.jcN = i;
        this.jeM.appId = str;
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        this.jeM.fvM = appBrandSysConfig.iOI.iGK;
        this.jeM.frn = appBrandSysConfig.frn;
        this.jeM.fvL = appBrandSysConfig.fnl;
        MainProcessTask operateBackgroundAudioTask = new OperateBackgroundAudioTask(this, jVar, i);
        operateBackgroundAudioTask.jcN = i;
        operateBackgroundAudioTask.appId = str;
        operateBackgroundAudioTask.jeR = jSONObject.toString();
        b t = u.GK().t(u.hz("AppBrandService#" + jVar.hashCode()), true);
        synchronized (t) {
            f fVar;
            f fVar2 = (f) t.get("StickyBannerChangeListener", null);
            if (fVar2 == null) {
                1 1 = new 1(this, t, jVar, i);
                appBrandSysConfig = jVar.irP.iqx;
                if (appBrandSysConfig != null) {
                    t.o("pkgType", Integer.valueOf(appBrandSysConfig.iOI.iGK));
                }
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
        AppBrandMainProcessService.a(operateBackgroundAudioTask);
    }
}
