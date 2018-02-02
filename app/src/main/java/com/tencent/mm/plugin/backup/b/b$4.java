package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.b.b;
import java.util.LinkedList;

class b$4 implements Runnable {
    final /* synthetic */ b kji;
    final /* synthetic */ b kjj;
    final /* synthetic */ LinkedList kjk;

    public b$4(b bVar, b bVar2, LinkedList linkedList) {
        this.kji = bVar;
        this.kjj = bVar2;
        this.kjk = linkedList;
    }

    public final void run() {
        if (!this.kji.kjf && this.kjj != null) {
            this.kjj.w(this.kjk);
        }
    }
}
