package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.u;

class ComposeUI$21 implements OnClickListener {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$21(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.prr, MailAddrListUI.class);
        intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.e(this.prr).a(false, null));
        intent.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
        intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
        this.prr.startActivityForResult(intent, 1);
        this.prr.overridePendingTransition(R.a.bqo, R.a.bqa);
    }
}
