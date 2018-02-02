package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView.e;

class CollectBillListUI$2 implements e {
    final /* synthetic */ CollectBillListUI llF;

    CollectBillListUI$2(CollectBillListUI collectBillListUI) {
        this.llF = collectBillListUI;
    }

    public final boolean azk() {
        x.d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", new Object[]{Boolean.valueOf(CollectBillListUI.g(this.llF)), Boolean.valueOf(CollectBillListUI.h(this.llF))});
        if (CollectBillListUI.g(this.llF) || CollectBillListUI.h(this.llF)) {
            return true;
        }
        CollectBillListUI.i(this.llF);
        CollectBillListUI.j(this.llF);
        return false;
    }
}
