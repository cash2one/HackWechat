package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import b.c.a.a;
import b.c.b.f;
import b.i;
import com.tencent.mm.plugin.radar.a.c;

final class RadarViewController$h extends f implements a<RadarWaveView> {
    final /* synthetic */ RadarViewController pzY;

    RadarViewController$h(RadarViewController radarViewController) {
        this.pzY = radarViewController;
    }

    public final /* synthetic */ Object invoke() {
        Context context = this.pzY.getContext();
        if (context != null) {
            return (RadarWaveView) ((Activity) context).findViewById(c.pvW);
        }
        throw new i("null cannot be cast to non-null type android.app.Activity");
    }
}
