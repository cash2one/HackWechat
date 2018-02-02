package com.tencent.mm.plugin.qqmail.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class MailAddrsViewControl$4 implements OnEditorActionListener {
    final /* synthetic */ MailAddrsViewControl ptc;

    MailAddrsViewControl$4(MailAddrsViewControl mailAddrsViewControl) {
        this.ptc = mailAddrsViewControl;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5) {
            String obj = this.ptc.psV.getEditableText().toString();
            if (obj != null && obj.length() > 0) {
                MailAddrsViewControl.a(this.ptc, obj, false);
                this.ptc.bla();
            }
        }
        return true;
    }
}
