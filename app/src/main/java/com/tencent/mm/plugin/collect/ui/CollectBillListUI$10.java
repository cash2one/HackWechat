package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView.c;

class CollectBillListUI$10 implements c {
    final /* synthetic */ CollectBillListUI llF;

    CollectBillListUI$10(CollectBillListUI collectBillListUI) {
        this.llF = collectBillListUI;
    }

    public final boolean azm() {
        if (CollectBillListUI.f(this.llF).getVisibility() == 0) {
            x.d("MicroMsg.CollectBillListUI", "empty view");
            return true;
        }
        View childAt = CollectBillListUI.e(this.llF).getChildAt(CollectBillListUI.e(this.llF).getChildCount() - 1);
        if (childAt == null || childAt.getBottom() > CollectBillListUI.e(this.llF).getHeight() || CollectBillListUI.e(this.llF).getLastVisiblePosition() != CollectBillListUI.e(this.llF).getAdapter().getCount() - 1) {
            return false;
        }
        return true;
    }
}
