package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.ui.ComposeUI.11;

class ComposeUI$11$1 implements OnCancelListener {
    final /* synthetic */ 11 prw;

    ComposeUI$11$1(11 11) {
        this.prw = 11;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ComposeUI.E(this.prw.prr).bkP();
        ComposeUI.E(this.prw.prr).psq = null;
        w.bks().cancel(ComposeUI.F(this.prw.prr));
    }
}
