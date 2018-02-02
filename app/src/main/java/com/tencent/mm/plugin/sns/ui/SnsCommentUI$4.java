package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;

class SnsCommentUI$4 implements TextWatcher {
    final /* synthetic */ SnsCommentUI rBv;

    SnsCommentUI$4(SnsCommentUI snsCommentUI) {
        this.rBv = snsCommentUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (SnsCommentUI.b(this.rBv).getText().toString().trim().length() > 0) {
            this.rBv.enableOptionMenu(true);
        } else {
            this.rBv.enableOptionMenu(false);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
