package com.tencent.mm.plugin.readerapp;

import android.content.Context;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.sdk.platformtools.x;

class Plugin$1 implements b {
    final /* synthetic */ Plugin pAy;

    Plugin$1(Plugin plugin) {
        this.pAy = plugin;
    }

    public final a Q(Context context, String str) {
        x.i("MicroMsg.ReaderApp.Plugin", "create contact widget type[%s]", new Object[]{str});
        if ("widget_type_news".equals(str)) {
            return new com.tencent.mm.plugin.readerapp.ui.b(context);
        }
        return null;
    }
}
