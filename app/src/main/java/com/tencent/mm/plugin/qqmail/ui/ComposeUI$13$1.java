package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.qqmail.ui.ComposeUI.13;

class ComposeUI$13$1 implements OnCancelListener {
    final /* synthetic */ 13 prx;

    ComposeUI$13$1(13 13) {
        this.prx = 13;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ComposeUI.E(this.prx.prr).bkP();
        ComposeUI.E(this.prx.prr).psq = null;
    }
}
