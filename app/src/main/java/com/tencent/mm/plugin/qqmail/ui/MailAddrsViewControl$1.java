package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;

class MailAddrsViewControl$1 implements OnClickListener {
    final /* synthetic */ MailAddrsViewControl ptc;

    MailAddrsViewControl$1(MailAddrsViewControl mailAddrsViewControl) {
        this.ptc = mailAddrsViewControl;
    }

    public final void onClick(View view) {
        this.ptc.psV.requestFocus();
        ((InputMethodManager) this.ptc.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
    }
}
