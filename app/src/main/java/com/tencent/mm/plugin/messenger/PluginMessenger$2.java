package com.tencent.mm.plugin.messenger;

import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;

class PluginMessenger$2 implements a {
    final /* synthetic */ PluginMessenger oom;

    PluginMessenger$2(PluginMessenger pluginMessenger) {
        this.oom = pluginMessenger;
    }

    public final String g(Map<String, String> map, String str) {
        if (map == null) {
            return null;
        }
        return bh.ou((String) map.get(str + ".plain"));
    }
}
