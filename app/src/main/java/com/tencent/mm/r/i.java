package com.tencent.mm.r;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.r.a.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class i implements ap {
    private static HashMap<Integer, d> gwY;
    private e gJY;
    private c gJZ = new c();
    Map<Integer, List<f>> gKa = new HashMap();

    static i Bk() {
        return (i) p.s(i.class);
    }

    public static e Bl() {
        if (Bk().gJY == null) {
            Bk().gJY = new e(g.Dj().gQj);
        }
        return Bk().gJY;
    }

    public static c Bm() {
        if (Bk().gJZ == null) {
            Bk().gJZ = new c();
        }
        return Bk().gJZ;
    }

    public static synchronized void a(f fVar) {
        synchronized (i.class) {
            x.i("MicroMsg.SubCoreFunctionMsg", "removeUpdateCallback, msgType: %s, callback: %s", new Object[]{Integer.valueOf(12399999), fVar});
            if (fVar != null) {
                List list = (List) Bk().gKa.get(Integer.valueOf(12399999));
                if (list != null && list.contains(fVar)) {
                    list.remove(fVar);
                    Bk().gKa.put(Integer.valueOf(12399999), list);
                }
            }
        }
    }

    public static synchronized void b(f fVar) {
        synchronized (i.class) {
            x.i("MicroMsg.SubCoreFunctionMsg", "addUpdateCallback, msgType: %s, callback: %s", new Object[]{Integer.valueOf(12399999), fVar});
            if (fVar != null) {
                List list = (List) Bk().gKa.get(Integer.valueOf(12399999));
                if (list == null) {
                    list = new ArrayList();
                }
                if (!list.contains(fVar)) {
                    list.add(fVar);
                }
                Bk().gKa.put(Integer.valueOf(12399999), list);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("FunctionMsgItem".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Bn() {
        x.i("MicroMsg.SubCoreFunctionMsg", "getBaseDBFactories");
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.SubCoreFunctionMsg", "onAccountPostReset");
        g.Dm().g(new 1(), 10000);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        x.d("MicroMsg.SubCoreFunctionMsg", "onAccountRelease");
    }
}
