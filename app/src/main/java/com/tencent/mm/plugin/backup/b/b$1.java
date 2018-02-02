package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.b.a;
import java.util.LinkedList;

class b$1 implements Runnable {
    final /* synthetic */ a kjg;
    final /* synthetic */ LinkedList kjh;
    final /* synthetic */ b kji;

    b$1(b bVar, a aVar, LinkedList linkedList) {
        this.kji = bVar;
        this.kjg = aVar;
        this.kjh = linkedList;
    }

    public final void run() {
        if (this.kjg != null) {
            this.kjg.v(this.kjh);
        }
    }
}
