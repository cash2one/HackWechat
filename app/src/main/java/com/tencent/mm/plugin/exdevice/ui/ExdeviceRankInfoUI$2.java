package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.c;

class ExdeviceRankInfoUI$2 implements c {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$2(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final boolean azm() {
        View childAt = ExdeviceRankInfoUI.q(this.lXj).getChildAt(ExdeviceRankInfoUI.q(this.lXj).getChildCount() - 1);
        int count = ExdeviceRankInfoUI.q(this.lXj).getCount();
        if (count <= 0 || childAt == null || childAt.getBottom() > ExdeviceRankInfoUI.q(this.lXj).getHeight() || ExdeviceRankInfoUI.q(this.lXj).getLastVisiblePosition() != count - 1) {
            return false;
        }
        return true;
    }
}
