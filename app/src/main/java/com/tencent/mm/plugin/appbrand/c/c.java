package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class c {
    public HashMap<String, a> iLF = new HashMap();

    public final void a(a aVar) {
        if (aVar == null || bh.ov(aVar.fus)) {
            x.e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
            return;
        }
        x.i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", new Object[]{aVar.fus, aVar.iLu});
        this.iLF.put(aVar.fus, aVar);
    }

    public final a qj(String str) {
        if (!bh.ov(str)) {
            return (a) this.iLF.get(str);
        }
        x.e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
        return null;
    }
}
