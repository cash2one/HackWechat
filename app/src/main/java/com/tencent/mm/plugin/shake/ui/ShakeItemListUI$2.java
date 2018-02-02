package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ShakeItemListUI$2 implements OnClickListener {
    final /* synthetic */ ShakeItemListUI qqB;

    ShakeItemListUI$2(ShakeItemListUI shakeItemListUI) {
        this.qqB = shakeItemListUI;
    }

    public final void onClick(View view) {
        ShakeItemListUI.a(this.qqB, ShakeItemListUI.a(this.qqB) ^ -1);
        this.qqB.wg(ShakeItemListUI.a(this.qqB));
    }
}
