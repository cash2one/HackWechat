package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

final class RadarTipsView$c implements OnClickListener {
    final /* synthetic */ RadarTipsView pzA;

    RadarTipsView$c(RadarTipsView radarTipsView) {
        this.pzA = radarTipsView;
    }

    public final void onClick(View view) {
        RadarTipsView$a radarTipsView$a = RadarTipsView.pzz;
        x.d(RadarTipsView.access$getTAG$cp(), "noviceEducationTips onclick");
        this.pzA.blV();
    }
}
