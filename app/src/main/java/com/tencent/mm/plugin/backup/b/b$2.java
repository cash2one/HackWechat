package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.b.a;
import java.util.LinkedList;

class b$2 implements Runnable {
    final /* synthetic */ a kjg;
    final /* synthetic */ LinkedList kjh;
    final /* synthetic */ b kji;

    b$2(b bVar, a aVar, LinkedList linkedList) {
        this.kji = bVar;
        this.kjg = aVar;
        this.kjh = linkedList;
    }

    public final void run() {
        if (!this.kji.kjf && this.kjg != null) {
            this.kjg.v(this.kjh);
        }
    }
}
