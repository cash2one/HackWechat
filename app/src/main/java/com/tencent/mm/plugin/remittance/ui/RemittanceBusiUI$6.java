package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import java.util.HashSet;
import java.util.List;

class RemittanceBusiUI$6 implements c {
    final /* synthetic */ RemittanceBusiUI pOd;
    final /* synthetic */ List pOe;
    final /* synthetic */ HashSet pOf;

    RemittanceBusiUI$6(RemittanceBusiUI remittanceBusiUI, List list, HashSet hashSet) {
        this.pOd = remittanceBusiUI;
        this.pOe = list;
        this.pOf = hashSet;
    }

    public final void a(n nVar) {
        int i = 0;
        RemittanceBusiUI.a(this.pOd, RemittanceBusiUI.n(this.pOd));
        if (!RemittanceBusiUI.B(this.pOd).bnF() || RemittanceBusiUI.o(this.pOd) <= 0.0d) {
            for (vv vvVar : this.pOe) {
                nVar.a(i, vvVar.wfO, vvVar.wfQ, null, true);
                this.pOf.add(Integer.valueOf(i));
                i++;
            }
            return;
        }
        for (vv vvVar2 : this.pOe) {
            if (vvVar2.wfW == 1) {
                nVar.a(i, vvVar2.wfO, vvVar2.wfQ, null, true);
                this.pOf.add(Integer.valueOf(i));
            } else {
                nVar.a(i, vvVar2.wfO, vvVar2.wfQ);
            }
            i++;
        }
    }
}
