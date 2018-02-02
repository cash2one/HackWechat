package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;

class NoiseDetectMaskView$2 implements OnClickListener {
    final /* synthetic */ NoiseDetectMaskView shJ;

    NoiseDetectMaskView$2(NoiseDetectMaskView noiseDetectMaskView) {
        this.shJ = noiseDetectMaskView;
    }

    public final void onClick(View view) {
        if (NoiseDetectMaskView.b(this.shJ) != null) {
            NoiseDetectMaskView.b(this.shJ).bFP();
        }
    }
}
