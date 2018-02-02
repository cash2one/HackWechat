package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.plugin.backup.a.a;
import java.util.HashMap;

public final class d extends a {
    private static String TAG = "MicroMsg.BakOldItemFactory";
    private static d kql;
    private HashMap<Integer, k> kmY;

    public static d aqk() {
        if (kql == null) {
            a dVar = new d();
            kql = dVar;
            a(dVar);
        }
        return kql;
    }

    public final void aog() {
        kql = null;
    }

    public final k mQ(int i) {
        if (this.kmY == null) {
            this.kmY = new HashMap();
            this.kmY.put(Integer.valueOf(3), new e());
            this.kmY.put(Integer.valueOf(47), new c());
            this.kmY.put(Integer.valueOf(49), new b());
            this.kmY.put(Integer.valueOf(34), new h());
            g gVar = new g();
            this.kmY.put(Integer.valueOf(43), gVar);
            this.kmY.put(Integer.valueOf(44), gVar);
            this.kmY.put(Integer.valueOf(62), gVar);
            f fVar = new f();
            this.kmY.put(Integer.valueOf(48), fVar);
            this.kmY.put(Integer.valueOf(42), fVar);
            this.kmY.put(Integer.valueOf(10000), fVar);
            this.kmY.put(Integer.valueOf(1), fVar);
            this.kmY.put(Integer.valueOf(37), fVar);
            this.kmY.put(Integer.valueOf(40), fVar);
            this.kmY.put(Integer.valueOf(50), fVar);
        }
        return (k) this.kmY.get(Integer.valueOf(i));
    }
}
