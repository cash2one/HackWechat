package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.pluginsdk.j.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

class b$a {
    public String ikn;
    public Queue<String> rWf = new LinkedList();

    b$a(String str) {
        this.ikn = str;
        x.d("MicroMsg.PushMessageExtension", "DoSceneStruct:" + str);
        ArrayList bb = a.bb(ac.getContext(), str);
        if (bb == null || bb.size() <= 0) {
            x.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
            return;
        }
        for (int i = 0; i < bb.size(); i++) {
            Map map = ((a) bb.get(i)).vip;
            if (map != null) {
                for (Entry value : map.entrySet()) {
                    this.rWf.offer(value.getValue());
                }
            }
        }
    }
}
