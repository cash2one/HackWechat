package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMGridPaper.5;

class MMGridPaper$5$2 implements Runnable {
    final /* synthetic */ int ybi;
    final /* synthetic */ 5 ybj;

    MMGridPaper$5$2(5 5, int i) {
        this.ybj = 5;
        this.ybi = i;
    }

    public final void run() {
        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) this.ybj.ybh.yaH.getChildAt(0);
        x.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", Integer.valueOf(this.ybi + (this.ybj.ybh.yaH.getChildCount() >> 1)));
        this.ybj.ybh.yaH.removeViewAt(0);
        mMGridPaperGridView.a(r1, this.ybj.ybh.leO, this.ybj.ybh.mNumColumns, this.ybj.ybh.yaI);
        this.ybj.ybh.yaH.addView(mMGridPaperGridView);
        this.ybj.ybh.yaH.EJ(this.ybj.ybh.yaH.getChildCount() >> 1);
        MMGridPaper.a(this.ybj.ybh, 1);
    }
}
