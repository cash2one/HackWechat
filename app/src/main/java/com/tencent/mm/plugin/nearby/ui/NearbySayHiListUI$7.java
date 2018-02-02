package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView$c;

class NearbySayHiListUI$7 implements MMSlideDelView$c {
    final /* synthetic */ NearbySayHiListUI oPo;

    NearbySayHiListUI$7(NearbySayHiListUI nearbySayHiListUI) {
        this.oPo = nearbySayHiListUI;
    }

    public final int ci(View view) {
        return NearbySayHiListUI.d(this.oPo).getPositionForView(view);
    }
}
