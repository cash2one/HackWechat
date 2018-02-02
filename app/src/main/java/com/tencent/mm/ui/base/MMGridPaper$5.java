package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFlipper.b;

class MMGridPaper$5 implements b {
    final /* synthetic */ MMGridPaper ybh;

    MMGridPaper$5(MMGridPaper mMGridPaper) {
        this.ybh = mMGridPaper;
    }

    public final void vJ(int i) {
        x.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.ybh.yaO), Integer.valueOf(this.ybh.yaP), Integer.valueOf(this.ybh.yaQ)});
        if (i <= this.ybh.yaO && this.ybh.yaO > 0) {
            this.ybh.pFW.post(new 1(this, i));
        } else if (i >= this.ybh.yaP && this.ybh.yaP < this.ybh.yaQ - 1) {
            this.ybh.pFW.post(new 2(this, i));
        }
        this.ybh.yaM = i;
        this.ybh.kba.EI(i);
    }
}
