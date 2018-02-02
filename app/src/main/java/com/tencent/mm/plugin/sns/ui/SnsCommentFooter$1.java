package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;

class SnsCommentFooter$1 implements TextWatcher {
    final /* synthetic */ SnsCommentFooter rBl;

    SnsCommentFooter$1(SnsCommentFooter snsCommentFooter) {
        this.rBl = snsCommentFooter;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (SnsCommentFooter.a(this.rBl).getText() != null) {
            SnsCommentFooter.a(this.rBl).requestFocus();
            boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
            if (z && this.rBl.okB) {
                SnsCommentFooter.a(this.rBl, true);
                this.rBl.okB = false;
            }
            if (!z) {
                SnsCommentFooter.a(this.rBl, false);
                this.rBl.okB = true;
            }
        }
    }
}
