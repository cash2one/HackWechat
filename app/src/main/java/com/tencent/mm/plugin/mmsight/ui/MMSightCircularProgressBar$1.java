package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class MMSightCircularProgressBar$1 implements a {
    final /* synthetic */ MMSightCircularProgressBar oAT;

    MMSightCircularProgressBar$1(MMSightCircularProgressBar mMSightCircularProgressBar) {
        this.oAT = mMSightCircularProgressBar;
    }

    public final void an(float f) {
        MMSightCircularProgressBar.a(this.oAT, f);
        this.oAT.invalidate();
    }

    public final void onAnimationEnd() {
        x.i("MicroMsg.MMSightCircularProgressBar", "onAnimationEnd");
        ag.y(new 1(this));
    }
}
