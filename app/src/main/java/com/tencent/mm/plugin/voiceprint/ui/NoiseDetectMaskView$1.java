package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;

class NoiseDetectMaskView$1 implements OnClickListener {
    final /* synthetic */ NoiseDetectMaskView shJ;

    NoiseDetectMaskView$1(NoiseDetectMaskView noiseDetectMaskView) {
        this.shJ = noiseDetectMaskView;
    }

    public final void onClick(View view) {
        if (NoiseDetectMaskView.a(this.shJ) != null) {
            NoiseDetectMaskView.a(this.shJ).bFQ();
        }
    }
}
