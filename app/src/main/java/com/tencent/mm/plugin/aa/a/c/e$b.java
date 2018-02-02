package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import java.util.Map;

public class e$b implements e<Boolean, c<Integer, Map<String, Object>>> {
    final /* synthetic */ e ihz;

    public e$b(e eVar) {
        this.ihz = eVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        c cVar = (c) obj;
        a aVar = this.ihz.ihv;
        int intValue = ((Integer) cVar.get(0)).intValue();
        Map map = (Map) cVar.get(1);
        int intExtra = aVar.zAZ.getIntExtra("enter_scene", 1);
        if (intExtra == 1) {
            map.put(k.igI, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.ifK));
        } else if (intExtra == 2) {
            map.put(k.igI, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.ifL));
        } else if (intExtra == 3) {
            map.put(k.igI, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.ifM));
        }
        g.a(g.t(Integer.valueOf(intValue), map).b(aVar.iht.igP));
        return null;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
