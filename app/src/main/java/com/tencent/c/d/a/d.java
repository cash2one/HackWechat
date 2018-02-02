package com.tencent.c.d.a;

import com.tencent.c.d.b.d.a;
import com.tencent.c.f.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class d implements b {
    private final HashSet<Integer> zTs = new HashSet();
    private final List<a> zTt = new ArrayList();

    public final void a(a aVar) {
        if (aVar.uid == 0) {
            if (aVar.zTy == 1 && !"/sbin/adbd".equals(aVar.name)) {
                h.aaX("ProcessRelationAnalyzer parent : " + aVar.toString());
                this.zTs.add(Integer.valueOf(aVar.pid));
            } else if (aVar.zTy > 1 && "sh".equals(aVar.name) && "/system/bin/sh".equals(aVar.name)) {
                h.aaX("ProcessRelationAnalyzer child : " + aVar.toString());
                this.zTt.add(aVar);
            }
        }
    }

    public final boolean cDr() {
        for (a aVar : this.zTt) {
            if (this.zTs.contains(Integer.valueOf(aVar.zTy))) {
                h.aaW("ProcessRelationAnalyzer match : " + aVar.toString());
                return true;
            }
        }
        return false;
    }
}
