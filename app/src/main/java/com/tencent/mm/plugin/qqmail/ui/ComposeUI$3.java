package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ComposeUI$3 implements OnClickListener {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$3(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final void onClick(View view) {
        ComposeUI.j(this.prr).getText().clear();
        ComposeUI.j(this.prr).requestFocus();
    }
}
