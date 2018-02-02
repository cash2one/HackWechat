package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFlipper.a;

class MMGridPaper$4 implements a {
    final /* synthetic */ MMGridPaper ybh;

    MMGridPaper$4(MMGridPaper mMGridPaper) {
        this.ybh = mMGridPaper;
    }

    public final void dm(int i, int i2) {
        x.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.ybh.yaJ), Integer.valueOf(i2), Integer.valueOf(this.ybh.yaK), Boolean.valueOf(this.ybh.yaY), Boolean.valueOf(this.ybh.yaX)});
        if ((Math.abs(this.ybh.yaK - i2) < 50 && Math.abs(this.ybh.yaJ - i) < 50) || i2 == 0 || i == 0) {
            x.d("MicroMsg.MMGridPaper", "match width height limit, return");
        } else if (!this.ybh.yaY || this.ybh.yaJ <= i || this.ybh.yaX) {
            x.v("MicroMsg.MMGridPaper", "onMeasure: match");
            x.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", new Object[]{Boolean.valueOf(this.ybh.ybe)});
            this.ybh.yaX = false;
            if (!this.ybh.ybe) {
                this.ybh.yaK = i2;
                this.ybh.yaJ = i;
            }
            this.ybh.refresh();
        } else {
            x.d("MicroMsg.MMGridPaper", "match ori limit, return");
        }
    }
}
