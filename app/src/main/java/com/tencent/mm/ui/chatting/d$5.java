package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;

class d$5 implements Runnable {
    final /* synthetic */ d yqB;

    d$5(d dVar) {
        this.yqB = dVar;
    }

    public final void run() {
        if (this.yqB.yqo != null && this.yqB.fhr.csy() != null) {
            x.i("MicroMsg.AutoPlay", "resetAutoPlay notifyDataSetChanged");
            this.yqB.fhr.csy().notifyDataSetChanged();
        }
    }
}
