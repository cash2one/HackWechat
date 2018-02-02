package com.tencent.mm.plugin.luckymoney.b;

import android.os.Looper;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Iterator;

public final class ai implements e {
    boolean odH;
    public af odI;
    public ac odJ;
    private v odK;
    public c odL = new 1(this);

    public ai() {
        a.xef.b(this.odL);
    }

    public final void a(int i, int i2, String str, k kVar) {
        g.Dk();
        g.Di().gPJ.b(1581, (e) this);
        g.Dk();
        g.Di().gPJ.b(1685, (e) this);
        g.Dk();
        g.Di().gPJ.b(1585, (e) this);
        if (kVar instanceof af) {
            af afVar = (af) kVar;
            if (i != 0 || i2 != 0) {
                this.odH = false;
                dF(afVar.fqm);
            } else if (afVar.fLD == 4) {
                if (this.odK != null) {
                    g.Dk();
                    g.Di().gPJ.c(this.odK);
                    this.odK = null;
                }
                g.Dk();
                g.Di().gPJ.a(1585, (e) this);
                this.odK = new v(afVar.nZa, 11, 0, afVar.fLC, "v1.0");
                this.odK.talker = afVar.talker;
                this.odK.fqm = afVar.fqm;
                g.Dk();
                g.Di().gPJ.a(this.odK, 0);
                x.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
            } else if (afVar.fLE == 1 || afVar.fLD == 5 || afVar.fLD == 1) {
                this.odH = false;
                x.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
                dF(afVar.fqm);
            } else {
                if (this.odJ != null) {
                    g.Dk();
                    g.Di().gPJ.c(this.odJ);
                    this.odJ = null;
                }
                g.Dk();
                g.Di().gPJ.a(1685, (e) this);
                this.odJ = new ac(afVar.msgType, afVar.fdS, afVar.nZa, afVar.fLC, n.aXg(), q.FU(), afVar.talker, "v1.0", afVar.odE);
                this.odJ.fqm = afVar.fqm;
                g.Dk();
                g.Di().gPJ.a(this.odJ, 0);
                x.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
            }
        } else if (kVar instanceof ac) {
            this.odH = false;
            ac acVar = (ac) kVar;
            if (i == 0 && i2 == 0) {
                e eVar = acVar.ocQ;
                if (eVar.fLE == 2) {
                    a(eVar, acVar.fqm, acVar.talker);
                    return;
                } else {
                    dF(acVar.fqm);
                    return;
                }
            }
            dF(acVar.fqm);
        } else if (kVar instanceof v) {
            this.odH = false;
            v vVar = (v) kVar;
            if (i == 0 && i2 == 0) {
                a(vVar.ocQ, vVar.fqm, vVar.talker);
            } else {
                dF(vVar.fqm);
            }
        }
    }

    private static void dF(long j) {
        b tjVar = new tj();
        tjVar.fLO.action = 2;
        tjVar.fLP.fpG = j;
        tjVar.fLP.fLR = 0;
        tjVar.fLP.fLS = "";
        a.xef.a(tjVar, Looper.getMainLooper());
    }

    private static void a(e eVar, long j, String str) {
        b tjVar = new tj();
        tjVar.fLO.action = 2;
        tjVar.fLP.fpG = j;
        tjVar.fLP.fLR = eVar.fLR;
        tjVar.fLP.fLS = eVar.obZ;
        tjVar.fLP.fLT = new ArrayList();
        if (s.eV(str)) {
            Iterator it = eVar.och.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                tjVar.fLP.fLT.add(n.JS().jb(mVar.ocE) + "=" + mVar.ocD + "=" + mVar.ocq);
            }
        }
        a.xef.a(tjVar, Looper.getMainLooper());
    }
}
