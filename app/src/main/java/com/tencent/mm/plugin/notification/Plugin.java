package com.tencent.mm.plugin.notification;

import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    a oTX = new a();

    public p createApplication() {
        return this.oTX;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return f.bgH();
    }
}
