package com.tencent.mm.plugin.downloader.d;

import com.tencent.mm.plugin.downloader.model.q;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements q {
    final /* synthetic */ a lrq;

    a$1(a aVar) {
        this.lrq = aVar;
    }

    public final void azW() {
        x.i("MicroMsg.CDNDownloadClient", "notify add");
        this.lrq.azQ();
        a aVar = this.lrq;
        x.i("MicroMsg.CDNDownloadClient", "startCheckProcessActiveTimer");
        aVar.lrn.J(20000, 20000);
    }

    public final void remove() {
        x.i("MicroMsg.CDNDownloadClient", "notify remove");
        if (this.lrq.lrk.size() == 0) {
            a.a(this.lrq);
            a.b(this.lrq);
        }
    }

    public final void clear() {
        x.i("MicroMsg.CDNDownloadClient", "notify clear");
        a.a(this.lrq);
        a.b(this.lrq);
    }
}
