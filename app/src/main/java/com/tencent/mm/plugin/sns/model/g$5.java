package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.model.g.b;
import com.tencent.mm.sdk.platformtools.x;

class g$5 implements Runnable {
    final /* synthetic */ g qTk;

    g$5(g gVar) {
        this.qTk = gVar;
    }

    public final void run() {
        if (g.d(this.qTk)) {
            x.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
        } else if (g.e(this.qTk).size() > 0) {
            x.i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + g.e(this.qTk).size());
            ((b) g.e(this.qTk).removeLast()).m(new String[]{""});
        }
    }
}
