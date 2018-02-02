package com.tencent.mm.plugin.webview.fts.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.plugin.webview.fts.c.d.1;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class FtsWebVideoView$13 implements b {
    final /* synthetic */ FtsWebVideoView trm;

    FtsWebVideoView$13(FtsWebVideoView ftsWebVideoView) {
        this.trm = ftsWebVideoView;
    }

    public final void c(String str, String str2, String str3, int i, int i2) {
        x.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(i2)});
        g.pQN.h(14911, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), FtsWebVideoView.n(this.trm), an.eP(this.trm.getContext())});
        if (FtsWebVideoView.h(this.trm) != null) {
            d h = FtsWebVideoView.h(this.trm);
            x.e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            h.clean();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", String.valueOf(i2));
                h.af(h.a(7, jSONObject));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
            }
        }
        this.trm.pause();
        FtsWebVideoView.a(this.trm, this.trm.getContext().getString(R.l.eSV, new Object[]{i + ":" + i2}), this.trm.getContext().getString(R.l.eTp));
    }

    public final void bk(String str, String str2) {
        x.i("MicroMsg.FtsWebVideoView", "onPrepared");
        a o = FtsWebVideoView.o(this.trm);
        o.jtA = -1;
        o.jtB = 0;
        o.jtz = 0.0f;
        FtsWebVideoView.c(this.trm).kn(FtsWebVideoView.f(this.trm));
    }

    public final void bl(String str, String str2) {
        x.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
        if (FtsWebVideoView.h(this.trm) != null) {
            d h = FtsWebVideoView.h(this.trm);
            x.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", new Object[]{h.toString()});
            h.ahn();
            try {
                h.af(h.a(3, null));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
            }
        }
        if (FtsWebVideoView.p(this.trm)) {
            this.trm.w(0, true);
            return;
        }
        this.trm.w(0, false);
        this.trm.pause();
        FtsWebVideoView.q(this.trm);
        FtsWebVideoView.r(this.trm).setImageResource(R.g.bCw);
        FtsWebVideoView.c(this.trm).setVisibility(8);
    }

    public final void d(String str, String str2, int i, int i2) {
        x.i("MicroMsg.FtsWebVideoView", "onGetVideoSize width=%d height=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (FtsWebVideoView.s(this.trm) == FtsWebVideoView.b.trn) {
            FtsWebVideoView.a(this.trm, i < i2 ? FtsWebVideoView.b.trp : FtsWebVideoView.b.tro);
            x.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[]{FtsWebVideoView.s(this.trm)});
        }
    }

    public final void bm(String str, String str2) {
        x.i("MicroMsg.FtsWebVideoView", "onVideoPause");
        if (FtsWebVideoView.h(this.trm) != null && FtsWebVideoView.h(this.trm) != null) {
            d h = FtsWebVideoView.h(this.trm);
            x.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", new Object[]{h.toString()});
            h.ahn();
            try {
                h.af(h.a(2, null));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
            }
        }
    }

    public final void bn(String str, String str2) {
        x.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", new Object[]{Boolean.valueOf(FtsWebVideoView.t(this.trm))});
        if (FtsWebVideoView.h(this.trm) != null) {
            d h = FtsWebVideoView.h(this.trm);
            x.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", new Object[]{h.toString()});
            h.jts = 0;
            if (h.jtr == null) {
                h.jtr = new ak(new 1(h), true);
            }
            h.jtr.J(250, 250);
            try {
                h.af(h.a(1, null));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
            }
        }
        if (FtsWebVideoView.u(this.trm) > 0 && FtsWebVideoView.u(this.trm) != Long.MAX_VALUE) {
            long currentTimeMillis = System.currentTimeMillis() - FtsWebVideoView.u(this.trm);
            g.pQN.h(14909, new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis()), Long.valueOf(currentTimeMillis), an.eP(this.trm.getContext()), FtsWebVideoView.n(this.trm)});
        }
    }

    public final void bo(String str, String str2) {
        x.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
        FtsWebVideoView.c(this.trm).bQu();
        FtsWebVideoView.a(this.trm, true);
    }

    public final void bp(String str, String str2) {
        x.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
        FtsWebVideoView.a(this.trm, false);
        FtsWebVideoView.c(this.trm).bQv();
        FtsWebVideoView.c(this.trm).bQr();
    }
}
