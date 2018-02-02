package com.tencent.mm.plugin.messenger;

import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class PluginMessenger$5 implements a {
    final /* synthetic */ PluginMessenger oom;

    PluginMessenger$5(PluginMessenger pluginMessenger) {
        this.oom = pluginMessenger;
    }

    public final String g(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String az = bh.az((String) map.get(str + ".separator"), "、");
        int i = 0;
        while (true) {
            String str2 = str + ".memberlist.member" + (i != 0 ? Integer.valueOf(i) : "");
            if (map.get(str2) == null) {
                return stringBuilder.toString();
            }
            if (i != 0) {
                stringBuilder.append(az);
            }
            str2 = (String) map.get(str2 + ".nickname");
            if (bh.ov(str2)) {
                x.w("MicroMsg.PluginMessenger", "hy: can not resolve username or nickname");
            } else {
                stringBuilder.append(str2);
            }
            i++;
        }
    }
}
