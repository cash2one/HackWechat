package com.tencent.mm.plugin.radar.ui;

import android.os.Message;
import b.c.b.e;
import com.tencent.mm.sdk.platformtools.af;

public final class RadarStateView$d extends af {
    final /* synthetic */ RadarStateView pyY;

    RadarStateView$d(RadarStateView radarStateView) {
        this.pyY = radarStateView;
    }

    public final void handleMessage(Message message) {
        e.i(message, "msg");
        RadarStateView.a(this.pyY);
        this.pyY.blO();
    }
}
