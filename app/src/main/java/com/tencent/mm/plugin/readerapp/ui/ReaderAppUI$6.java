package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.d;

class ReaderAppUI$6 implements d {
    final /* synthetic */ ReaderAppUI pAY;

    ReaderAppUI$6(ReaderAppUI readerAppUI) {
        this.pAY = readerAppUI;
    }

    public final boolean azl() {
        View childAt = ReaderAppUI.e(this.pAY).getChildAt(ReaderAppUI.e(this.pAY).getFirstVisiblePosition());
        if (childAt == null || childAt.getTop() != 0) {
            return false;
        }
        return true;
    }
}
