package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class q {
    public HashMap<Integer, a> tjb = new HashMap();

    public final void a(a aVar) {
        for (Integer intValue : aVar.bOG()) {
            x.d("MicroMsg.Wear.WearHttpServerLogic", "add funId %d %s", new Object[]{Integer.valueOf(intValue.intValue()), aVar});
            this.tjb.put(Integer.valueOf(r0), aVar);
        }
    }

    public final a zE(int i) {
        return (a) this.tjb.get(Integer.valueOf(i));
    }
}
