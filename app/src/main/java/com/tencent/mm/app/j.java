package com.tencent.mm.app;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends c<jk> {
    private static boolean ffy = false;
    private int ffA;
    private int ffz;

    public final /* synthetic */ boolean a(b bVar) {
        jk jkVar = (jk) bVar;
        if (jkVar != null) {
            x.w("MicroMsg.MediaLeakReporter", "event audio[%b %d] mediaplayer[%b %d] audioRecord[%b %d] hadRpt[%b]", new Object[]{Boolean.valueOf(jkVar.fzX.fzY), Integer.valueOf(jkVar.fzX.fzZ), Boolean.valueOf(jkVar.fzX.fAa), Integer.valueOf(jkVar.fzX.fAb), Boolean.valueOf(jkVar.fzX.fAc), Integer.valueOf(jkVar.fzX.fAd), Boolean.valueOf(ffy)});
            if (jkVar.fzX.fzY) {
                g.pQN.a(650, (long) this.ffz, 1, false);
            }
            if (jkVar.fzX.fAa) {
                g.pQN.a(650, (long) this.ffA, 1, false);
            }
            if (jkVar.fzX.fAc) {
                g.pQN.a(650, (long) (this.ffA + 1), 1, false);
            }
            if (!ffy && (jkVar.fzX.fzZ > 10 || jkVar.fzX.fAb > 10 || jkVar.fzX.fAd > 0)) {
                g.pQN.c("mediaLeak", f.xZ(), null);
                ffy = true;
            }
        }
        return false;
    }

    public j(int i, int i2) {
        this.ffz = i;
        this.ffA = i2;
        this.xen = jk.class.getName().hashCode();
    }
}
