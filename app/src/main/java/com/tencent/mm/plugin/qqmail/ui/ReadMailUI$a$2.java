package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a;

class ReadMailUI$a$2 implements Runnable {
    final /* synthetic */ a puQ;

    ReadMailUI$a$2(a aVar) {
        this.puQ = aVar;
    }

    public final void run() {
        ReadMailUI.h(this.puQ.puG).setEnabled(false);
        ReadMailUI.h(this.puQ.puG).setText(R.l.eCl);
        ReadMailUI.h(this.puQ.puG).setTextColor(-7829368);
        ReadMailUI.h(this.puQ.puG).setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bv.a.b(this.puQ.puG, R.g.bFL), null, null, null);
    }
}
