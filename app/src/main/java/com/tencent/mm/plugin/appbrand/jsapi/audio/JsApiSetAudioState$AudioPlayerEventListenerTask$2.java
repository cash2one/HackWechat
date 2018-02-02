package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState.AudioPlayerEventListenerTask;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class JsApiSetAudioState$AudioPlayerEventListenerTask$2 extends c<t> {
    final /* synthetic */ AudioPlayerEventListenerTask jfu;

    JsApiSetAudioState$AudioPlayerEventListenerTask$2(AudioPlayerEventListenerTask audioPlayerEventListenerTask) {
        this.jfu = audioPlayerEventListenerTask;
        this.xen = t.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        t tVar = (t) bVar;
        if (this.jfu.appId.equals(tVar.fnK.appId)) {
            Map hashMap = new HashMap();
            String str = tVar.fnK.state;
            x.i("MicroMsg.Audio.JsApiSetAudioState", "mAudioListener callback action:%d， audioId:%s, state:%s", new Object[]{Integer.valueOf(tVar.fnK.action), tVar.fnK.fnF, str});
            hashMap.put("state", str);
            hashMap.put("audioId", r4);
            this.jfu.action = tVar.fnK.action;
            if (this.jfu.action == 4) {
                hashMap.put("errMsg", tVar.fnK.fnL);
                hashMap.put("errCode", Integer.valueOf(tVar.fnK.errCode));
            }
            this.jfu.jeW = new JSONObject(hashMap).toString();
            AudioPlayerEventListenerTask.a(this.jfu);
            return true;
        }
        x.i("MicroMsg.Audio.JsApiSetAudioState", "appId is not equals preAppId, don't send any event, appId:%s, eventAppId:%s, action:%d", new Object[]{this.jfu.appId, tVar.fnK.appId, Integer.valueOf(tVar.fnK.action)});
        return false;
    }
}
