package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class d implements e {
    public Map<Integer, Set<t>> hmZ = new HashMap();

    public d() {
        g.Di().gPJ.a(452, this);
    }

    public final void a(int i, t tVar) {
        if (!this.hmZ.containsKey(Integer.valueOf(i))) {
            this.hmZ.put(Integer.valueOf(i), new HashSet());
        }
        if (!((Set) this.hmZ.get(Integer.valueOf(i))).contains(tVar)) {
            ((Set) this.hmZ.get(Integer.valueOf(i))).add(tVar);
        }
    }

    public final void b(int i, t tVar) {
        if (this.hmZ.get(Integer.valueOf(i)) != null) {
            ((Set) this.hmZ.get(Integer.valueOf(i))).remove(tVar);
        }
    }

    public static void a(int i, w wVar) {
        g.Di().gPJ.a(new x(i, wVar), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x xVar = (x) kVar;
        Set set = (Set) this.hmZ.get(Integer.valueOf(xVar.veD));
        if (set != null && set.size() > 0) {
            Set<t> hashSet = new HashSet();
            hashSet.addAll(set);
            for (t tVar : hashSet) {
                if (tVar != null && set.contains(tVar)) {
                    tVar.a(i, i2, str, xVar.veE);
                }
            }
        }
    }
}
