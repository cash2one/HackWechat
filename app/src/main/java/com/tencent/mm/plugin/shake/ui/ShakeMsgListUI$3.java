package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ShakeMsgListUI$3 implements OnClickListener {
    final /* synthetic */ View oPn;
    final /* synthetic */ ShakeMsgListUI qqQ;

    ShakeMsgListUI$3(ShakeMsgListUI shakeMsgListUI, View view) {
        this.qqQ = shakeMsgListUI;
        this.oPn = view;
    }

    public final void onClick(View view) {
        ShakeMsgListUI.a(this.qqQ, ShakeMsgListUI.d(this.qqQ) + 8);
        ShakeMsgListUI.b(this.qqQ).wf(ShakeMsgListUI.d(this.qqQ));
        if (ShakeMsgListUI.e(this.qqQ) <= ShakeMsgListUI.d(this.qqQ)) {
            ShakeMsgListUI.f(this.qqQ).removeFooterView(this.oPn);
        }
    }
}
