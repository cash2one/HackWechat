package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.d;

class MassSendHistoryUI$7 implements d {
    final /* synthetic */ MassSendHistoryUI onL;

    MassSendHistoryUI$7(MassSendHistoryUI massSendHistoryUI) {
        this.onL = massSendHistoryUI;
    }

    public final boolean azl() {
        View childAt = MassSendHistoryUI.d(this.onL).getChildAt(MassSendHistoryUI.d(this.onL).getFirstVisiblePosition());
        if (childAt == null || childAt.getTop() != 0) {
            return false;
        }
        return true;
    }
}
