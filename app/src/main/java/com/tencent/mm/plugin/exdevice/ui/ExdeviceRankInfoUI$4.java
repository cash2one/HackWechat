package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.d;

class ExdeviceRankInfoUI$4 implements d {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$4(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final boolean azl() {
        int firstVisiblePosition = ExdeviceRankInfoUI.q(this.lXj).getFirstVisiblePosition();
        if (firstVisiblePosition == 0) {
            View childAt = ExdeviceRankInfoUI.q(this.lXj).getChildAt(firstVisiblePosition);
            if (childAt != null && childAt.getTop() >= 0) {
                return true;
            }
        }
        return false;
    }
}
