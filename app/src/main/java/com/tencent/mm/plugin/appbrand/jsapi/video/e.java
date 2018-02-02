package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e implements com.tencent.mm.plugin.appbrand.page.p.e {
    AppBrandVideoView jtp;
    private p jtq;
    ak jtr;
    int jts;

    private static final class a extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 131;
        private static final String NAME = "onVideoClickDanmuBtn";

        private a() {
        }
    }

    private static final class b extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 138;
        private static final String NAME = "onVideoEnded";

        private b() {
        }
    }

    private static final class d extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 130;
        private static final String NAME = "onVideoFullScreenChange";

        private d() {
        }
    }

    private static final class e extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 128;
        private static final String NAME = "onVideoPause";

        private e() {
        }
    }

    private static final class f extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 127;
        private static final String NAME = "onVideoPlay";

        private f() {
        }
    }

    private static final class g extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 127;
        private static final String NAME = "onVideoTimeUpdate";

        private g() {
        }
    }

    private static final class h extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 350;
        private static final String NAME = "onVideoWaiting";

        private h() {
        }
    }

    public e(AppBrandVideoView appBrandVideoView, p pVar) {
        this.jtp = appBrandVideoView;
        this.jtq = pVar;
        this.jtq.a(this);
    }

    public final void onDestroy() {
        x.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.jtp.jsy = null;
    }

    public final void clean() {
        this.jtq.b(this);
        ahn();
    }

    final void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject) {
        if (!(fVar instanceof g)) {
            x.i("MicroMsg.JsApiVideoCallback", "dispatchEvent event %s", new Object[]{fVar.getName()});
        }
        com.tencent.mm.plugin.appbrand.jsapi.f az = fVar.az(this.jtq.mAppId, this.jtq.hashCode());
        az.mData = jSONObject.toString();
        az.afs();
    }

    final JSONObject ahm() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, this.jtp.jsv);
        return jSONObject;
    }

    final void ahn() {
        if (this.jtr != null) {
            this.jtr.TG();
        }
    }
}
