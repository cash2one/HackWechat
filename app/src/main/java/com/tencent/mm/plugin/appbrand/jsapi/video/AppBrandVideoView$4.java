package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class AppBrandVideoView$4 implements AppBrandVideoViewControlBar$a {
    final /* synthetic */ AppBrandVideoView jsL;

    AppBrandVideoView$4(AppBrandVideoView appBrandVideoView) {
        this.jsL = appBrandVideoView;
    }

    public final void da(boolean z) {
        if (!z) {
            AppBrandVideoView.c(this.jsL).hide();
        } else if (AppBrandVideoView.b(this.jsL).isPlaying()) {
            AppBrandVideoView.c(this.jsL).show();
        } else {
            AppBrandVideoView.c(this.jsL).pause();
        }
        if (AppBrandVideoView.d(this.jsL) != null) {
            e d = AppBrandVideoView.d(this.jsL);
            int e = AppBrandVideoView.e(this.jsL);
            try {
                x.i("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", new Object[]{Boolean.valueOf(z)});
                JSONObject ahm = d.ahm();
                ahm.put("showDanmu", z);
                ahm.put("videoPlayerId", e);
                d.a(new a((byte) 0), ahm);
            } catch (JSONException e2) {
                x.e("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", new Object[]{e2});
            }
        }
    }
}
