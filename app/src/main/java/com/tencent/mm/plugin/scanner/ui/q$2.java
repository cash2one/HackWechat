package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;

class q$2 extends af {
    final /* synthetic */ q pYI;

    q$2(q qVar) {
        this.pYI = qVar;
    }

    public final void handleMessage(Message message) {
        if (q.f(this.pYI) != null) {
            this.pYI.pXp.hG(true);
            q.f(this.pYI).setText(R.l.eIk);
            q.f(this.pYI).setVisibility(0);
        }
    }
}
