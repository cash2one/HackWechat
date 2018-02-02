package com.tencent.mm.plugin.qqmail.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

class ComposeUI$2 implements TextWatcher {
    final /* synthetic */ ComposeUI prr;
    final /* synthetic */ ImageView prs;

    ComposeUI$2(ComposeUI composeUI, ImageView imageView) {
        this.prr = composeUI;
        this.prs = imageView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 4;
        if (this.prr.pqV) {
            ImageView imageView = this.prs;
            if (ComposeUI.j(this.prr).getText().length() > 0) {
                i4 = 0;
            }
            imageView.setVisibility(i4);
            return;
        }
        this.prs.setVisibility(4);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
