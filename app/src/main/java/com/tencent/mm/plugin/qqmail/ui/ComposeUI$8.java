package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ComposeUI$8 implements OnClickListener {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$8(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final void onClick(View view) {
        h.a(this.prr, null, new String[]{this.prr.getString(R.l.eAs), this.prr.getString(R.l.eAp), this.prr.getString(R.l.eAq)}, null, new 1(this));
    }
}
