package com.tencent.mm.plugin.radar.ui;

import android.os.Looper;
import android.os.Message;
import b.c.b.e;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.ui.RadarTipsView.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarTipsView$f extends af {
    final /* synthetic */ RadarTipsView pzA;

    RadarTipsView$f(RadarTipsView radarTipsView, Looper looper) {
        this.pzA = radarTipsView;
        super(looper);
    }

    public final void handleMessage(Message message) {
        e.i(message, "msg");
        int i = message.what;
        if (i == RadarTipsView.c(this.pzA)) {
            this.pzA.blW();
        } else if (i == RadarTipsView.d(this.pzA)) {
            if (RadarTipsView.e(this.pzA) && this.pzA.pzp) {
                RadarTipsView.a(this.pzA, f.pwq);
            }
        } else if (i == RadarTipsView.f(this.pzA)) {
            RadarTipsView radarTipsView = this.pzA;
            radarTipsView.pzm = true;
            a aVar = RadarTipsView.pzz;
            radarTipsView.pzt = RadarTipsView.pzx;
            aVar = RadarTipsView.pzz;
            x.d(RadarTipsView.access$getTAG$cp(), "showNoviceEducation");
            radarTipsView.pzo = true;
            radarTipsView.blT().setVisibility(8);
            radarTipsView.blT().clearAnimation();
            radarTipsView.setVisibility(0);
            radarTipsView.blU().setVisibility(0);
            radarTipsView.blU().startAnimation(radarTipsView.blR());
            radarTipsView.blU().requestFocus();
        } else if (i == RadarTipsView.g(this.pzA)) {
            this.pzA.blV();
        }
    }
}
