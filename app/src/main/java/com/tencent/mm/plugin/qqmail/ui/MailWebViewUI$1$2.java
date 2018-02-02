package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.1;

class MailWebViewUI$1$2 implements Runnable {
    final /* synthetic */ String jqG;
    final /* synthetic */ 1 ptP;

    MailWebViewUI$1$2(1 1, String str) {
        this.ptP = 1;
        this.jqG = str;
    }

    public final void run() {
        Toast.makeText(this.ptP.ptN, this.jqG, 0).show();
    }
}
