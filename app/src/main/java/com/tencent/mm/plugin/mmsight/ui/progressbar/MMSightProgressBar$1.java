package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mm.plugin.mmsight.ui.progressbar.b.1;
import com.tencent.mm.plugin.mmsight.ui.progressbar.b.2;
import com.tencent.mm.sdk.platformtools.af;

class MMSightProgressBar$1 extends af {
    final /* synthetic */ MMSightProgressBar oDL;

    MMSightProgressBar$1(MMSightProgressBar mMSightProgressBar, Looper looper) {
        this.oDL = mMSightProgressBar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 233 && MMSightProgressBar.a(this.oDL) && MMSightProgressBar.b(this.oDL).size() > 0 && MMSightProgressBar.b(this.oDL).size() < 5) {
            MMSightProgressBar.a(this.oDL, new b((a) MMSightProgressBar.b(this.oDL).get(MMSightProgressBar.b(this.oDL).size() - 1), new a(MMSightProgressBar.b(this.oDL).size(), MMSightProgressBar.c(this.oDL), MMSightProgressBar.d(this.oDL), MMSightProgressBar.aJR()[MMSightProgressBar.b(this.oDL).size()]), new 1(this)));
            b g = MMSightProgressBar.g(this.oDL);
            g.jWC = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
            g.jWC.addUpdateListener(new 1(g));
            g.jWC.addListener(new 2(g));
            g.jWC.setInterpolator(new AccelerateDecelerateInterpolator());
            g.jWC.setDuration(2000);
            g.jWC.start();
        }
    }
}
