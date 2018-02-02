package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class ComposeUI$23 implements OnFocusChangeListener {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$23(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            ComposeUI.j(this.prr).setSelection(ComposeUI.j(this.prr).getText().length());
        }
    }
}
