package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ComposeUI$7 implements OnClickListener {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$7(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final void onClick(View view) {
        ComposeUI.z(this.prr).setVisibility(8);
        ComposeUI.A(this.prr).setVisibility(0);
        ComposeUI.B(this.prr).setVisibility(0);
        ComposeUI.z(this.prr).post(new 1(this));
    }
}
