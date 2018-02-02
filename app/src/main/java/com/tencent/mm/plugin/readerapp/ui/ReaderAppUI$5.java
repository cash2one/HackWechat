package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.c;

class ReaderAppUI$5 implements c {
    final /* synthetic */ ReaderAppUI pAY;

    ReaderAppUI$5(ReaderAppUI readerAppUI) {
        this.pAY = readerAppUI;
    }

    public final boolean azm() {
        View childAt = ReaderAppUI.e(this.pAY).getChildAt(ReaderAppUI.e(this.pAY).getChildCount() - 1);
        if (childAt != null && childAt.getBottom() <= ReaderAppUI.e(this.pAY).getHeight() && ReaderAppUI.e(this.pAY).getLastVisiblePosition() == ReaderAppUI.e(this.pAY).getAdapter().getCount() - 1) {
            return true;
        }
        return false;
    }
}
