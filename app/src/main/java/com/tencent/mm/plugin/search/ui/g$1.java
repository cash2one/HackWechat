package com.tencent.mm.plugin.search.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.search.a.c;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class g$1 extends af {
    final /* synthetic */ g qcw;

    g$1(g gVar, Looper looper) {
        this.qcw = gVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                x.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
                if (!g.a(this.qcw) && this.qcw.getCount() > 0) {
                    c.bpQ().aNt();
                    n.qQy.start();
                    this.qcw.notifyDataSetChanged();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
