package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class JsApiOperateMusicPlayer$OperateMusicPlayer$6 extends c<js> {
    final /* synthetic */ OperateMusicPlayer jfe;

    JsApiOperateMusicPlayer$OperateMusicPlayer$6(OperateMusicPlayer operateMusicPlayer) {
        this.jfe = operateMusicPlayer;
        this.xen = js.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        js jsVar = (js) bVar;
        x.i("MicroMsg.JsApiOperateMusicPlayer", "callback in(action : %s)", new Object[]{Integer.valueOf(jsVar.fAz.action)});
        asv com_tencent_mm_protocal_c_asv = jsVar.fAz.fAv;
        if (com_tencent_mm_protocal_c_asv != null) {
            String str = com_tencent_mm_protocal_c_asv.wAo;
            Map hashMap = new HashMap();
            hashMap.put("dataUrl", str);
            this.jfe.jeW = new JSONObject(hashMap).toString();
            this.jfe.action = jsVar.fAz.action;
            OperateMusicPlayer.h(this.jfe);
        }
        return false;
    }
}
