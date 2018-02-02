package com.tencent.mm.plugin.card.sharecard.a;

import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class b$1$1 implements Runnable {
    final /* synthetic */ ArrayList kNb;
    final /* synthetic */ 1 kNc;

    b$1$1(1 1, ArrayList arrayList) {
        this.kNc = 1;
        this.kNb = arrayList;
    }

    public final void run() {
        Map map = (Map) am.auF().getValue("key_share_user_info_map");
        if (map == null) {
            map = new HashMap();
        }
        map.put(this.kNc.kMZ, this.kNb);
        am.auF().putValue("key_share_user_info_map", map);
    }
}
