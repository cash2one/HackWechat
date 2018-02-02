package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMGridPaper.5;

class MMGridPaper$5$1 implements Runnable {
    final /* synthetic */ int ybi;
    final /* synthetic */ 5 ybj;

    MMGridPaper$5$1(5 5, int i) {
        this.ybj = 5;
        this.ybi = i;
    }

    public final void run() {
        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) this.ybj.ybh.yaH.getChildAt(this.ybj.ybh.yaH.getChildCount() - 1);
        x.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", new Object[]{Integer.valueOf(this.ybj.ybh.yaH.getChildCount() - 1), Integer.valueOf(this.ybi - (this.ybj.ybh.yaH.getChildCount() >> 1))});
        this.ybj.ybh.yaH.removeViewAt(this.ybj.ybh.yaH.getChildCount() - 1);
        mMGridPaperGridView.a(r1, this.ybj.ybh.leO, this.ybj.ybh.mNumColumns, this.ybj.ybh.yaI);
        this.ybj.ybh.yaH.addView(mMGridPaperGridView, 0);
        this.ybj.ybh.yaH.EJ(this.ybj.ybh.yaH.getChildCount() >> 1);
        MMGridPaper.a(this.ybj.ybh, -1);
    }
}
