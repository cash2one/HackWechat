package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.qqmail.ui.ComposeUI.19;

class ComposeUI$19$1 implements OnClickListener {
    final /* synthetic */ 19 prA;
    final /* synthetic */ MailAddrsViewControl prz;

    ComposeUI$19$1(19 19, MailAddrsViewControl mailAddrsViewControl) {
        this.prA = 19;
        this.prz = mailAddrsViewControl;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.prz.psV.setText("");
        ComposeUI.i(this.prA.prr).postDelayed(new 1(this), 150);
    }
}
