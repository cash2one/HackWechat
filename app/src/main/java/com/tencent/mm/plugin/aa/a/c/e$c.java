package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;
import java.util.Map;

public class e$c implements e<d<Boolean, String, Long>, Map<String, Object>> {
    final /* synthetic */ e ihz;

    public e$c(e eVar) {
        this.ihz = eVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        Map map = (Map) obj;
        a aVar = this.ihz.ihv;
        int intExtra = aVar.zAZ.getIntExtra("enter_scene", 1);
        if (intExtra == 1) {
            map.put(k.igI, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.ifK));
        } else if (intExtra == 2) {
            map.put(k.igI, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.ifL));
        } else if (intExtra == 3) {
            map.put(k.igI, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.ifM));
        }
        g.a(g.cp(map).b(aVar.iht.igQ));
        return null;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
