package com.tencent.mm.plugin.hardwareopt;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.hardwareopt.a.a.a;
import com.tencent.mm.plugin.hardwareopt.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.x;

public class PluginHardwareOpt extends f implements c, b {
    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(g gVar) {
        if (gVar.DS()) {
            x.v("MicroMsg.PluginHardwareOpt", "hy: on config");
            com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.plugin.hardwareopt.a.a());
        }
    }

    public void execute(g gVar) {
        if (gVar.DS()) {
            x.i("MicroMsg.PluginHardwareOpt", "hy: on execute. ");
        }
    }

    public void onAccountInitialized(e.c cVar) {
        x.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountInitialized");
        ((a) com.tencent.mm.kernel.g.h(a.class)).fK(false);
    }

    public void onAccountRelease() {
        x.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountRelease");
    }
}
