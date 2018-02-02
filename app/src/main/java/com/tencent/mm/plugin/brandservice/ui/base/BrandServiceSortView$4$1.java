package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.4;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.List;

class BrandServiceSortView$4$1 implements Runnable {
    final /* synthetic */ 4 kHr;

    BrandServiceSortView$4$1(4 4) {
        this.kHr = 4;
    }

    public final void run() {
        List list = this.kHr.kHq.yjZ.ykb;
        if (this.kHr.kI >= 0 && list != null && this.kHr.kI < list.size()) {
            list.remove(this.kHr.kI);
            ag.y(this.kHr.kHq.yjZ.yki);
        }
    }
}
