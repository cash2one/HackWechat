package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.a.f$b;
import com.tencent.mm.plugin.backup.b.b.b;
import java.util.LinkedList;

class b$3 implements Runnable {
    final /* synthetic */ b kji;
    final /* synthetic */ b kjj;
    final /* synthetic */ LinkedList kjk;
    final /* synthetic */ f$b kjl;
    final /* synthetic */ int kjm;

    public b$3(b bVar, b bVar2, LinkedList linkedList, f$b com_tencent_mm_plugin_backup_a_f_b, int i) {
        this.kji = bVar;
        this.kjj = bVar2;
        this.kjk = linkedList;
        this.kjl = com_tencent_mm_plugin_backup_a_f_b;
        this.kjm = i;
    }

    public final void run() {
        if (!this.kji.kjf && this.kjj != null) {
            this.kjj.a(this.kjk, this.kjl, this.kjm);
        }
    }
}
