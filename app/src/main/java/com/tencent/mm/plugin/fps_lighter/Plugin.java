package com.tencent.mm.plugin.fps_lighter;

import com.tencent.mm.plugin.fps_lighter.b.g;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        x.d("MicroMsg.FPSLighterCore.Plugin", "[createSubCore]");
        return new g();
    }
}
