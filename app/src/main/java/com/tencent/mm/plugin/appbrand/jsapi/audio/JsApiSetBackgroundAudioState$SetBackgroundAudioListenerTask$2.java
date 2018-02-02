package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask;
import com.tencent.mm.plugin.appbrand.media.d.a;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask$2 extends c<js> {
    final /* synthetic */ SetBackgroundAudioListenerTask jfy;

    JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask$2(SetBackgroundAudioListenerTask setBackgroundAudioListenerTask) {
        this.jfy = setBackgroundAudioListenerTask;
        this.xen = js.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        js jsVar = (js) bVar;
        x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "musicPlayerListener callback action : %d", new Object[]{Integer.valueOf(jsVar.fAz.action)});
        Map hashMap = new HashMap();
        String str = jsVar.fAz.state;
        if (jsVar.fAz.action == 10) {
            if (jsVar.fAz.appId.equals(this.jfy.appId)) {
                x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is same, don't send ON_PREEMPTED event");
                return false;
            }
            x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send ON_PREEMPTED event, sender appId:%s,  receive appId:%s", new Object[]{jsVar.fAz.appId, this.jfy.appId});
            hashMap.put("state", str);
            this.jfy.jeW = new JSONObject(hashMap).toString();
            this.jfy.action = jsVar.fAz.action;
            SetBackgroundAudioListenerTask.b(this.jfy);
            return true;
        }
        asv com_tencent_mm_protocal_c_asv = jsVar.fAz.fAv;
        if (com_tencent_mm_protocal_c_asv == null) {
            x.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "wrapper is null");
            return false;
        } else if (jsVar.fAz.fAB) {
            int i;
            if (jsVar.fAz.action == 2 && jsVar.fAz.fAC) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i != 0) {
                x.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "isSwitchMusicIng, don't callback!");
                return false;
            }
            if (this.jfy.appId.equals(a.aio().jzA)) {
                hashMap.put("src", com_tencent_mm_protocal_c_asv.wAo);
                hashMap.put("state", str);
                hashMap.put("errCode", Integer.valueOf(jsVar.fAz.errCode));
                Object obj = "";
                if (!TextUtils.isEmpty(jsVar.fAz.fnL)) {
                    obj = jsVar.fAz.fnL;
                }
                hashMap.put("errMsg", obj);
                this.jfy.jeW = new JSONObject(hashMap).toString();
                this.jfy.action = jsVar.fAz.action;
                SetBackgroundAudioListenerTask.c(this.jfy);
                return true;
            }
            x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is not equals preAppId, don't send any event, appId:%s, preAppId:%s", new Object[]{this.jfy.appId, a.aio().jzA});
            return false;
        } else {
            x.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "is not from QQMusicPlayer, don't callback!");
            return false;
        }
    }
}
