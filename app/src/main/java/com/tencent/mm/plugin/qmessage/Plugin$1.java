package com.tencent.mm.plugin.qmessage;

import android.content.Context;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;

class Plugin$1 implements b {
    final /* synthetic */ Plugin pnp;

    Plugin$1(Plugin plugin) {
        this.pnp = plugin;
    }

    public final a Q(Context context, String str) {
        if ("widget_type_contact".equals(str)) {
            return new com.tencent.mm.plugin.qmessage.ui.a(context);
        }
        return new com.tencent.mm.plugin.qmessage.ui.b(context);
    }
}
