package com.tencent.mm.plugin.gai;

import com.tencent.mm.plugin.gai.a.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    public Plugin() {
        x.i("MicroMsg.Plugin.gai", "gai Plugin!");
        if (!ac.getContext().getSharedPreferences(ac.cfs() + "_google_aid", 4).getBoolean("already_report_googleaid", false)) {
            e.post(new 2(this, ac.getContext(), new 1(this)), "Advertisement-MAT-thread");
        }
    }

    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new com.tencent.mm.plugin.gai.b.a();
    }
}
