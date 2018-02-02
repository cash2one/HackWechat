package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView$c;

class ShakeSayHiListUI$4 implements MMSlideDelView$c {
    final /* synthetic */ ShakeSayHiListUI qsr;

    ShakeSayHiListUI$4(ShakeSayHiListUI shakeSayHiListUI) {
        this.qsr = shakeSayHiListUI;
    }

    public final int ci(View view) {
        return ShakeSayHiListUI.d(this.qsr).getPositionForView(view);
    }
}
