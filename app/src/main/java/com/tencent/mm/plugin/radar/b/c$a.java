package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.b.c.b;
import com.tencent.mm.plugin.radar.b.c.d;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.xwalk.core.XWalkUpdater;

public final class c$a implements e {
    String jKk;
    final LinkedList<String> pwD = new LinkedList();
    LinkedList<Integer> pwE;
    private final d pwF;
    final /* synthetic */ c pwG;

    public c$a(c cVar, d dVar) {
        this.pwG = cVar;
        this.pwF = dVar;
    }

    public final void onStart() {
        g.CG().a(30, this);
    }

    private final void b(boolean z, boolean z2, String str, String str2) {
        g.CG().b(30, this);
        d dVar = this.pwF;
        if (dVar != null) {
            dVar.a(z, z2, str, str2);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        b.c.b.e.i(kVar, "scene");
        b bVar = c.pwC;
        x.d(c.access$getTAG$cp(), "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (kVar.getType() != 30) {
            bVar = c.pwC;
            x.w(c.access$getTAG$cp(), "not expected scene,  type = " + kVar.getType());
            return;
        }
        if (((o) kVar).bYt() == 2) {
            if (i == 0 && i2 == 0) {
                b(false, true, this.jKk, "");
                return;
            } else if (i == 4 && i2 == -34) {
                str = this.pwG.context.getString(f.eik);
            } else if (i == 4 && i2 == -94) {
                str = this.pwG.context.getString(f.eil);
            } else if (i != 4 || (!(i2 == -24 || i2 == XWalkUpdater.ERROR_SET_VERNUM) || str == null)) {
                str = this.pwG.context.getString(f.eKc);
            }
        } else if (i == 0 && i2 == 0) {
            b(true, false, this.jKk, "");
            return;
        } else if (i2 == -44) {
            g.CG().d(new o(2, this.pwD, this.pwE, "", ""));
            return;
        } else if (i2 == -87) {
            b(false, false, this.jKk, this.pwG.context.getString(f.dUz));
            return;
        } else if (i2 == -24 && !bh.ov(str)) {
            String str2 = this.jKk;
            if (str == null) {
                str = "";
            }
            b(false, false, str2, str);
            return;
        } else if (i == 4 && i2 == -22) {
            str = this.pwG.context.getString(f.lor);
        } else {
            str = this.pwG.context.getString(f.loq);
        }
        b(false, false, this.jKk, str);
    }
}
