package com.tencent.mm.plugin.wallet_ecard;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_ecard.a.1.1;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.a;

class a$1$1$1 implements a {
    final /* synthetic */ 1 sYS;

    a$1$1$1(1 1) {
        this.sYS = 1;
    }

    public final Intent l(int i, Bundle bundle) {
        x.i("MicroMsg.SubCoreECard", "open process end: %s", new Object[]{Integer.valueOf(i)});
        if (i == -1) {
            this.sYS.sYP.fqC.retCode = 0;
            g.pQN.h(14954, new Object[]{f.ccU(), "openEcard:ok"});
        } else {
            this.sYS.sYP.fqC.retCode = -1;
            if (!f.ccT()) {
                g.pQN.h(14954, new Object[]{f.ccU(), "openEcard:fail"});
            }
        }
        this.sYS.sYP.fqB.fqI.run();
        if (!f.ccT()) {
            f.ccV();
        }
        return null;
    }
}
