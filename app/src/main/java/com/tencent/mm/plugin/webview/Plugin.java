package com.tencent.mm.plugin.webview;

import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new f();
    }
}
