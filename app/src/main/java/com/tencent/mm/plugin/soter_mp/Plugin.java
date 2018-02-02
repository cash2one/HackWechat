package com.tencent.mm.plugin.soter_mp;

import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    public Plugin() {
        x.i("SubCoreSoter", "soter plugin constructor");
    }

    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new b();
    }
}
