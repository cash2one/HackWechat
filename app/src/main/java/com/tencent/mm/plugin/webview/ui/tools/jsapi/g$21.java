package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.g.a.js;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class g$21 extends c<js> {
    final /* synthetic */ g tIj;

    g$21(g gVar) {
        this.tIj = gVar;
        this.xen = js.class.getName().hashCode();
    }

    private boolean a(js jsVar) {
        x.i("MicroMsg.MsgHandler", "backgroundAudioListener callback in, state:%s", jsVar.fAz.state);
        int i = (int) (jsVar.fAz.duration / 1000);
        if (jsVar.fAz.fAB) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("background_audio_state_player_state", r2);
                bundle.putInt("background_audio_state_player_duration", i);
                if (jsVar.fAz.fAv != null) {
                    bundle.putString("background_audio_state_player_src", jsVar.fAz.fAv.wAo);
                    bundle.putString("background_audio_state_player_src_id", jsVar.fAz.fAv.hHP);
                }
                bundle.putInt("background_audio_state_player_err_code", jsVar.fAz.errCode);
                String str = "";
                if (!TextUtils.isEmpty(jsVar.fAz.fnL)) {
                    str = jsVar.fAz.fnL;
                }
                bundle.putString("background_audio_state_player_err_msg", str);
                if (g.z(this.tIj) != null) {
                    x.i("MicroMsg.MsgHandler", "onBackgroundAudioStateChange");
                    g.z(this.tIj).n(2100, bundle);
                } else {
                    x.e("MicroMsg.MsgHandler", "backgroundAudioListener callbacker is null");
                }
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", e.getMessage());
                return false;
            }
        }
        x.e("MicroMsg.MsgHandler", "is not from QQMusicPlayer, don't callback!");
        return false;
    }
}
