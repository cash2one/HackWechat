package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class ShakeSayHiListUI$5 implements f {
    final /* synthetic */ ShakeSayHiListUI qsr;

    ShakeSayHiListUI$5(ShakeSayHiListUI shakeSayHiListUI) {
        this.qsr = shakeSayHiListUI;
    }

    public final void t(View view, int i) {
        ShakeSayHiListUI.d(this.qsr).performItemClick(view, i, 0);
    }
}
