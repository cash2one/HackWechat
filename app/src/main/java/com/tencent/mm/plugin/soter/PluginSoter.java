package com.tencent.mm.plugin.soter;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.c.d;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.soter.d.b;
import com.tencent.mm.sdk.platformtools.x;

public class PluginSoter extends f implements c, a {
    private d rRZ = null;
    private boolean rSa = false;

    public String name() {
        return "plugin-soter";
    }

    public void execute(g gVar) {
        if (gVar.DS()) {
            x.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", new Object[]{gVar.gOs});
            this.rSa = true;
            x.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
            this.rRZ = new d();
            safeAddListener(this.rRZ);
        }
    }

    public void uninstalled() {
        super.uninstalled();
        safeRemoveListener(this.rRZ);
    }

    private void safeAddListener(com.tencent.mm.sdk.b.c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
        } else if (com.tencent.mm.sdk.b.a.xef.d(cVar)) {
            x.w("MicroMsg.PluginSoter", "hy: already has listener");
        } else {
            com.tencent.mm.sdk.b.a.xef.b(cVar);
        }
    }

    private void safeRemoveListener(com.tencent.mm.sdk.b.c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.PluginSoter", "alvinluo listener is null");
        } else {
            com.tencent.mm.sdk.b.a.xef.c(cVar);
        }
    }

    public void onAccountInitialized(e.c cVar) {
        x.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", new Object[]{Boolean.valueOf(this.rSa)});
        if (this.rSa) {
            h.bCQ();
            b.a(false, false, null);
        }
    }

    public void onAccountRelease() {
        x.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
    }
}
