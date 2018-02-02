package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ComposeUI$11 implements OnClickListener {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$11(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final void onClick(View view) {
        this.prr.aWs();
        ComposeUI.j(this.prr).getText().toString();
        ComposeUI.D(this.prr);
        if (this.prr.bkH()) {
            ComposeUI composeUI = this.prr;
            Context context = this.prr;
            this.prr.getString(R.l.dGO);
            ComposeUI.a(composeUI, h.a(context, this.prr.getString(R.l.eAk), true, new 1(this)));
            if (ComposeUI.E(this.prr).bkQ()) {
                ComposeUI.a(this.prr, ComposeUI.H(this.prr));
                return;
            }
            ComposeUI.G(this.prr).setMessage(this.prr.getString(R.l.eAh));
            ComposeUI.E(this.prr).psq = new 2(this);
        }
    }
}
