package com.tencent.mm.plugin.normsg;

import android.os.Build.VERSION;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.normsg.utils.NativeLogic;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.platformtools.x;

public class PluginNormsg extends f implements c, a {
    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(d.class);
        dependsOn(b.class);
        dependsOn(a.class);
    }

    public void configure(g gVar) {
        com.tencent.mm.plugin.normsg.a.d.a(b.oSn);
        com.tencent.mm.plugin.normsg.a.c.a(NativeLogic.a.oTA);
    }

    public void execute(g gVar) {
    }

    public void onAccountInitialized(e.c cVar) {
        com.tencent.mm.plugin.normsg.utils.a bfK = com.tencent.mm.plugin.normsg.utils.a.bfK();
        g CN = com.tencent.mm.kernel.g.Dg().CN();
        if (com.tencent.mm.plugin.normsg.utils.a.c.isEnabled()) {
            int bfQ = com.tencent.mm.plugin.normsg.utils.a.c.bfQ();
            if (bfQ <= 0) {
                bfQ = 26;
            }
            if (VERSION.SDK_INT > bfQ) {
                x.w("MircoMsg.AEDHLP", "[tomys] unsupported system, aedh is not enabled.");
                return;
            } else if (com.tencent.mm.plugin.normsg.utils.a.oSx.contains(com.tencent.mm.plugin.normsg.utils.a.GI(CN.gOs))) {
                try {
                    com.tencent.mm.plugin.normsg.utils.b bfR = com.tencent.mm.plugin.normsg.utils.b.bfR();
                    bfR.initialize(CN.gSI);
                    bfR.El();
                    bfR.oSZ.add(bfK);
                    x.i("MircoMsg.AEDHLP", "[tomys] aed installed.");
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MircoMsg.AEDHLP", e, "[tomys] aed install failed.", new Object[0]);
                    bfK.g(e);
                    return;
                }
            } else {
                x.w("MircoMsg.AEDHLP", "[tomys] not target process, skip installing aed.");
                return;
            }
        }
        x.w("MircoMsg.AEDHLP", "[tomys] aedh is not enabled.");
    }

    public void onAccountRelease() {
    }
}
