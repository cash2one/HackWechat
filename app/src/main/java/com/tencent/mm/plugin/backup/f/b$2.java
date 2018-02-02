package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.ae.e;
import java.util.HashSet;
import java.util.Set;

class b$2 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ b koQ;

    b$2(b bVar, int i, int i2, String str) {
        this.koQ = bVar;
        this.fma = i;
        this.fmb = i2;
        this.hnj = str;
    }

    public final void run() {
        synchronized (b.RP()) {
            Set set = (Set) b.RP().get(Integer.valueOf(this.koQ.getType()));
        }
        if (set != null && set.size() > 0) {
            Set<e> hashSet = new HashSet();
            hashSet.addAll(set);
            for (e eVar : hashSet) {
                if (eVar != null && set.contains(eVar)) {
                    eVar.a(this.fma, this.fmb, this.hnj, this.koQ);
                }
            }
        }
    }
}
