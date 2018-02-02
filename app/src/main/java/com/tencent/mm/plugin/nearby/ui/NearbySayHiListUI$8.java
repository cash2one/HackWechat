package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class NearbySayHiListUI$8 implements f {
    final /* synthetic */ NearbySayHiListUI oPo;

    NearbySayHiListUI$8(NearbySayHiListUI nearbySayHiListUI) {
        this.oPo = nearbySayHiListUI;
    }

    public final void t(View view, int i) {
        NearbySayHiListUI.d(this.oPo).performItemClick(view, i, 0);
    }
}
