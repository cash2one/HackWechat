package com.tencent.pb.common.b;

import java.util.HashSet;
import java.util.Set;

class e$3 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ e zMn;
    final /* synthetic */ d zMo;

    e$3(e eVar, d dVar, int i, int i2, String str) {
        this.zMn = eVar;
        this.zMo = dVar;
        this.fma = i;
        this.fmb = i2;
        this.hnj = str;
    }

    public final void run() {
        Set set = (Set) e.b(this.zMn).get(this.zMo.getType());
        if (set != null && set.size() > 0) {
            Set<b> hashSet = new HashSet();
            hashSet.addAll(set);
            for (b bVar : hashSet) {
                if (bVar != null && set.contains(bVar)) {
                    bVar.a(this.fma, this.fmb, this.hnj, this.zMo);
                }
            }
        }
    }
}
