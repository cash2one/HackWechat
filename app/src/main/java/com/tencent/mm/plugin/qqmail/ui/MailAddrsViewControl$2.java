package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Button;

class MailAddrsViewControl$2 implements Runnable {
    final /* synthetic */ MailAddrsViewControl ptc;
    final /* synthetic */ Button ptd;

    MailAddrsViewControl$2(MailAddrsViewControl mailAddrsViewControl, Button button) {
        this.ptc = mailAddrsViewControl;
        this.ptd = button;
    }

    public final void run() {
        this.ptd.invalidate();
        this.ptd.setOnTouchListener(new 1(this));
        this.ptc.bla();
        this.ptc.invalidate();
    }
}
