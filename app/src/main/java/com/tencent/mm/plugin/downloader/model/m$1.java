package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.plugin.downloader.e.a;

class m$1 implements Runnable {
    final /* synthetic */ long lrL;
    final /* synthetic */ m lsR;

    m$1(m mVar, long j) {
        this.lsR = mVar;
        this.lrL = j;
    }

    public final void run() {
        a ce = e.ce(this.lrL);
        if (ce != null) {
            g.MJ().kI(ce.field_downloadUrl);
            if (ce.field_status != 5) {
                e.j(ce.field_downloadId, 5);
                this.lsR.lsp.cb(this.lrL);
            }
        }
    }
}
