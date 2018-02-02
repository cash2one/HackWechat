package com.tencent.mm.plugin.search.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.search.a.c;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.af;

class i$1 extends af {
    final /* synthetic */ i qcO;

    i$1(i iVar, Looper looper) {
        this.qcO = iVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (!i.f(this.qcO) && this.qcO.getCount() > 0) {
                    c.bpQ().aNt();
                    n.qQy.start();
                    this.qcO.notifyDataSetChanged();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
