package com.tencent.mm.plugin.qmessage;

import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    private b kAA = new 1(this);

    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.kAA;
    }

    public ap createSubCore() {
        return new g();
    }
}
