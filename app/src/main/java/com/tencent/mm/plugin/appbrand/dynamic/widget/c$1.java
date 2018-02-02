package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.util.Log;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

class c$1 implements Runnable {
    c$1() {
    }

    public final void run() {
        a aVar = b.gNk;
        c fn = a.fn("100284");
        if (fn == null) {
            x.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
        } else if (fn.isValid()) {
            try {
                c.kb(bh.getInt((String) fn.chI().get("mode"), 0));
                x.i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", new Object[]{Integer.valueOf(c.bl())});
            } catch (Throwable e) {
                x.w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", new Object[]{Log.getStackTraceString(e)});
            }
        } else {
            c.kb(0);
        }
    }
}
