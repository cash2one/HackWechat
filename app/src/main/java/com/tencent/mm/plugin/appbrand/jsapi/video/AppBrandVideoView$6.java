package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class AppBrandVideoView$6 implements b {
    final /* synthetic */ AppBrandVideoView jsL;

    AppBrandVideoView$6(AppBrandVideoView appBrandVideoView) {
        this.jsL = appBrandVideoView;
    }

    public final void c(String str, String str2, String str3, int i, int i2) {
        x.i("MicroMsg.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(i2)});
        if (AppBrandVideoView.d(this.jsL) != null) {
            e d = AppBrandVideoView.d(this.jsL);
            d.clean();
            try {
                JSONObject ahm = d.ahm();
                ahm.put("errMsg", str3);
                d.a(new c((byte) 0), ahm);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "onError e=%s", new Object[]{e});
            }
        }
    }

    public final void bk(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoView", "onPrepared");
        f n = AppBrandVideoView.n(this.jsL);
        n.jtA = -1;
        n.jtB = 0;
        n.jtz = 0.0f;
    }

    public final void bl(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoView", "onVideoEnded");
        AppBrandVideoView.o(this.jsL).setVisibility(0);
        if (AppBrandVideoView.p(this.jsL) || !AppBrandVideoView.q(this.jsL)) {
            AppBrandVideoView.r(this.jsL).setVisibility(8);
        } else {
            if (AppBrandVideoView.s(this.jsL) <= 0) {
                AppBrandVideoView.t(this.jsL).setText(AppBrandVideoView.a(this.jsL, AppBrandVideoView.b(this.jsL).ahi()));
            }
            AppBrandVideoView.r(this.jsL).setVisibility(0);
        }
        if (AppBrandVideoView.d(this.jsL) != null) {
            e d = AppBrandVideoView.d(this.jsL);
            try {
                d.a(new e.b((byte) 0), d.ahm());
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "OnVideoEnded e=%s", new Object[]{e});
            }
            d.ahn();
        }
        if (AppBrandVideoView.u(this.jsL)) {
            this.jsL.w(0, true);
        }
    }

    public final void d(String str, String str2, int i, int i2) {
        x.i("MicroMsg.AppBrandVideoView", "onGetVideoSize width=%d height=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (AppBrandVideoView.v(this.jsL) == -1) {
            AppBrandVideoView.b(this.jsL, i < i2 ? 0 : 90);
            x.i("MicroMsg.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[]{Integer.valueOf(AppBrandVideoView.v(this.jsL))});
        }
    }

    public final void bm(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoView", "onVideoPause");
        if (AppBrandVideoView.d(this.jsL) != null) {
            e d = AppBrandVideoView.d(this.jsL);
            try {
                d.a(new e((byte) 0), d.ahm());
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "OnVideoPause e=%s", new Object[]{e});
            }
            d.ahn();
        }
    }

    public final void bn(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoView", "onVideoPlay, isLive:%b", new Object[]{Boolean.valueOf(AppBrandVideoView.p(this.jsL))});
        if (AppBrandVideoView.s(this.jsL) <= 0 && !AppBrandVideoView.p(this.jsL)) {
            AppBrandVideoView.t(this.jsL).setText(AppBrandVideoView.a(this.jsL, AppBrandVideoView.b(this.jsL).ahi()));
        }
        AppBrandVideoView.a(this.jsL, AppBrandVideoView.p(this.jsL));
        if (AppBrandVideoView.f(this.jsL)) {
            AppBrandVideoView.g(this.jsL).aha();
        }
        if (AppBrandVideoView.d(this.jsL) != null) {
            e d = AppBrandVideoView.d(this.jsL);
            try {
                d.jts = 0;
                JSONObject ahm = d.ahm();
                ahm.put("timeStamp", System.currentTimeMillis());
                d.a(new f((byte) 0), ahm);
                if (d.jtr == null) {
                    d.jtr = new ak(new e$1(d), true);
                }
                d.jtr.J(250, 250);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "OnVideoPlay e=%s", new Object[]{e});
            }
        }
    }

    public final void bo(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoView", "onVideoWaiting");
        if (AppBrandVideoView.d(this.jsL) != null) {
            e d = AppBrandVideoView.d(this.jsL);
            try {
                JSONObject ahm = d.ahm();
                ahm.put("timeStamp", System.currentTimeMillis());
                d.a(new h((byte) 0), ahm);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "onVideoWaiting e=%s", new Object[]{e});
            }
        }
    }

    public final void bp(String str, String str2) {
    }
}
