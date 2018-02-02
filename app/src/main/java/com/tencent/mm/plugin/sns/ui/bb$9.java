package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.c;

class bb$9 implements c {
    final /* synthetic */ bb rLm;

    bb$9(bb bbVar) {
        this.rLm = bbVar;
    }

    public final boolean azm() {
        View childAt = this.rLm.nKG.getChildAt(this.rLm.nKG.getChildCount() - 1);
        if (childAt == null || childAt.getBottom() > this.rLm.nKG.getHeight() || this.rLm.nKG.getLastVisiblePosition() != this.rLm.nKG.getAdapter().getCount() - 1) {
            return false;
        }
        return true;
    }
}
