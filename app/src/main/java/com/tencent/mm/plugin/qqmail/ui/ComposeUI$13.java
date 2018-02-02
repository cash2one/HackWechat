package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.ui.base.h;

class ComposeUI$13 implements OnClickListener {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$13(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final void onClick(View view) {
        if (ComposeUI.E(this.prr).bkQ()) {
            s.a(ComposeUI.s(this.prr), ComposeUI.n(this.prr), ComposeUI.x(this.prr));
            ComposeUI.I(this.prr);
            return;
        }
        ComposeUI.a(this.prr, h.a(this.prr, this.prr.getString(R.l.eAh), true, new 1(this)));
        ComposeUI.E(this.prr).psq = new 2(this);
    }
}
