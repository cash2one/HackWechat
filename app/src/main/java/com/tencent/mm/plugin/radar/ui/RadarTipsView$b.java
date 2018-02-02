package com.tencent.mm.plugin.radar.ui;

import android.os.Message;
import b.c.b.e;
import com.tencent.mm.sdk.platformtools.af;

public final class RadarTipsView$b extends af {
    final /* synthetic */ RadarTipsView pzA;

    RadarTipsView$b(RadarTipsView radarTipsView) {
        this.pzA = radarTipsView;
    }

    public final void handleMessage(Message message) {
        e.i(message, "msg");
        this.pzA.setVisibility(8);
    }
}
