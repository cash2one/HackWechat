package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.a.a;
import java.util.HashMap;

public final class c extends a {
    private static String TAG = "MicroMsg.BackupItemFactory";
    private static c kmX;
    private HashMap<Integer, l> kmY;

    public static c apq() {
        if (kmX == null) {
            a cVar = new c();
            kmX = cVar;
            a(cVar);
        }
        return kmX;
    }

    public final void aog() {
        kmX = null;
    }

    public final l mH(int i) {
        if (this.kmY == null) {
            this.kmY = new HashMap();
            this.kmY.put(Integer.valueOf(3), new d());
            this.kmY.put(Integer.valueOf(47), new b());
            this.kmY.put(Integer.valueOf(49), new a());
            this.kmY.put(Integer.valueOf(34), new g());
            f fVar = new f();
            this.kmY.put(Integer.valueOf(43), fVar);
            this.kmY.put(Integer.valueOf(44), fVar);
            this.kmY.put(Integer.valueOf(62), fVar);
            e eVar = new e();
            this.kmY.put(Integer.valueOf(48), eVar);
            this.kmY.put(Integer.valueOf(42), eVar);
            this.kmY.put(Integer.valueOf(10000), eVar);
            this.kmY.put(Integer.valueOf(1), eVar);
            this.kmY.put(Integer.valueOf(37), eVar);
            this.kmY.put(Integer.valueOf(40), eVar);
            this.kmY.put(Integer.valueOf(50), eVar);
        }
        return (l) this.kmY.get(Integer.valueOf(i));
    }
}
