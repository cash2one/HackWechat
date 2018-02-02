package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.d;

class CollectBillListUI$9 implements d {
    final /* synthetic */ CollectBillListUI llF;

    CollectBillListUI$9(CollectBillListUI collectBillListUI) {
        this.llF = collectBillListUI;
    }

    public final boolean azl() {
        int firstVisiblePosition = CollectBillListUI.e(this.llF).getFirstVisiblePosition();
        if (firstVisiblePosition == 0) {
            View childAt = CollectBillListUI.e(this.llF).getChildAt(firstVisiblePosition);
            if (childAt != null && childAt.getX() == 0.0f) {
                return true;
            }
        }
        return false;
    }
}
