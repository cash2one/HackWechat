package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.ui.base.MMPullDownView.c;

class MassSendHistoryUI$6 implements c {
    final /* synthetic */ MassSendHistoryUI onL;

    MassSendHistoryUI$6(MassSendHistoryUI massSendHistoryUI) {
        this.onL = massSendHistoryUI;
    }

    public final boolean azm() {
        if (MassSendHistoryUI.d(this.onL).getChildAt(MassSendHistoryUI.d(this.onL).getChildCount() - 1).getBottom() > MassSendHistoryUI.d(this.onL).getHeight() || MassSendHistoryUI.d(this.onL).getLastVisiblePosition() != MassSendHistoryUI.d(this.onL).getAdapter().getCount() - 1) {
            return false;
        }
        return true;
    }
}
