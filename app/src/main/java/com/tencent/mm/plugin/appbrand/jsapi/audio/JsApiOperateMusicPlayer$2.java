package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.c.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.3;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiOperateMusicPlayer$2 extends b {
    final /* synthetic */ j iZy;
    final /* synthetic */ u.b jeN;
    final /* synthetic */ JsApiOperateMusicPlayer jeT;

    JsApiOperateMusicPlayer$2(JsApiOperateMusicPlayer jsApiOperateMusicPlayer, u.b bVar, j jVar) {
        this.jeT = jsApiOperateMusicPlayer;
        this.jeN = bVar;
        this.iZy = jVar;
    }

    public final void a(c cVar) {
        String string = this.jeN.getString("appId", "");
        int i = this.jeN.getInt("pkgType", 0);
        switch (3.iHw[cVar.ordinal()]) {
            case 1:
            case 2:
                int i2 = a.oT(string).scene;
                if (!AppBrandStickyBannerLogic.a.aM(string, i) && i2 != 1023) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("operationType", "pause");
                    } catch (JSONException e) {
                    }
                    MainProcessTask operateMusicPlayer = new OperateMusicPlayer(this.jeT, this.iZy, OperateMusicPlayer.a(this.jeT.jeS));
                    operateMusicPlayer.fBZ = jSONObject.toString();
                    operateMusicPlayer.fFm = string;
                    operateMusicPlayer.iTl = this.jeN;
                    AppBrandMainProcessService.a(operateMusicPlayer);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void onDestroy() {
        x.d("MicroMsg.JsApiOperateMusicPlayer", "onDestroy");
        String string = this.jeN.getString("appId", "");
        this.jeN.getInt("pkgType", 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operationType", "stop");
        } catch (JSONException e) {
        }
        MainProcessTask operateMusicPlayer = new OperateMusicPlayer(this.jeT, this.iZy, OperateMusicPlayer.a(this.jeT.jeS));
        operateMusicPlayer.fBZ = jSONObject.toString();
        operateMusicPlayer.fFm = string;
        operateMusicPlayer.action = -1;
        operateMusicPlayer.iTl = this.jeN;
        AppBrandMainProcessService.b(operateMusicPlayer);
    }
}
