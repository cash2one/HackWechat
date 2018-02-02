package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class r {
    private static List<a> vze = new ArrayList();

    public static void a(a aVar) {
        if (aVar != null) {
            x.d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + aVar.getName());
            if (!vze.contains(aVar)) {
                vze.add(aVar);
            }
        }
    }

    public static List<a> ccP() {
        return vze;
    }

    public static void clear() {
        x.d("MicroMsg.WebViewPluginCenter", "clear");
        vze.clear();
    }
}
