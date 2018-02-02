package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class MailAddrsViewControl$7 implements OnFocusChangeListener {
    final /* synthetic */ MailAddrsViewControl ptc;

    MailAddrsViewControl$7(MailAddrsViewControl mailAddrsViewControl) {
        this.ptc = mailAddrsViewControl;
    }

    public final void onFocusChange(View view, boolean z) {
        if (MailAddrsViewControl.g(this.ptc) != null) {
            MailAddrsViewControl.g(this.ptc).ho(z);
        }
        String obj = this.ptc.psV.getEditableText().toString();
        if (!z && obj.trim().length() > 0) {
            MailAddrsViewControl.a(this.ptc, obj, false);
        }
        if (MailAddrsViewControl.c(this.ptc) != null && MailAddrsViewControl.c(this.ptc).isSelected()) {
            MailAddrsViewControl.c(this.ptc).setSelected(z);
            MailAddrsViewControl.a(this.ptc, null);
        }
        this.ptc.bla();
    }
}
