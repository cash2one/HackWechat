package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.z.u.b;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiOperateMusicPlayer$1 implements f {
    final /* synthetic */ j iZy;
    final /* synthetic */ b jeN;
    final /* synthetic */ JsApiOperateMusicPlayer jeT;

    JsApiOperateMusicPlayer$1(JsApiOperateMusicPlayer jsApiOperateMusicPlayer, b bVar, j jVar) {
        this.jeT = jsApiOperateMusicPlayer;
        this.jeN = bVar;
        this.iZy = jVar;
    }

    public final void ak(String str, int i) {
        String string = this.jeN.getString("appId", "");
        int i2 = this.jeN.getInt("pkgType", 0);
        if ((!string.equals(str) || i2 != i) && this.jeN.hA("Music#isPlaying") && c.pf(string) != a.iqe) {
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
        }
    }
}
