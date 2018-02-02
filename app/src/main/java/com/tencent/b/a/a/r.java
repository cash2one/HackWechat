package com.tencent.b.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class r {
    private static r bpL = null;
    private Map<Integer, q> bpJ;
    private int bpK;

    private r(Context context) {
        this.bpJ = null;
        this.bpK = 0;
        this.bpJ = new HashMap(3);
        this.bpJ.put(Integer.valueOf(1), new o(context));
        this.bpJ.put(Integer.valueOf(2), new d(context));
        this.bpJ.put(Integer.valueOf(4), new k(context));
    }

    static synchronized r Z(Context context) {
        r rVar;
        synchronized (r.class) {
            if (bpL == null) {
                bpL = new r(context);
            }
            rVar = bpL;
        }
        return rVar;
    }

    final g sP() {
        return w(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
    }

    final g w(List<Integer> list) {
        if (list.size() >= 0) {
            for (Integer num : list) {
                q qVar = (q) this.bpJ.get(num);
                if (qVar != null) {
                    g sP = qVar.sP();
                    if (sP != null && s.bK(sP.bpr)) {
                        return sP;
                    }
                }
            }
        }
        return new g();
    }

    final a sQ() {
        return x(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(4)})));
    }

    private a x(List<Integer> list) {
        if (list.size() > 0) {
            for (Integer num : list) {
                q qVar = (q) this.bpJ.get(num);
                if (qVar != null) {
                    a sQ = qVar.sQ();
                    if (sQ != null) {
                        return sQ;
                    }
                }
            }
        }
        return new a();
    }

    final void b(a aVar) {
        for (Entry value : this.bpJ.entrySet()) {
            ((q) value.getValue()).b(aVar);
        }
    }

    final void b(g gVar) {
        for (Entry value : this.bpJ.entrySet()) {
            ((q) value.getValue()).b(gVar);
        }
    }
}
